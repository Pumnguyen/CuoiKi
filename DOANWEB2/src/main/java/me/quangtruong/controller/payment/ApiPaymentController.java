/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.quangtruong.controller.payment;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import me.quangtruong.entity.Orders;
import me.quangtruong.entity.Users;
import me.quangtruong.services.IOrdersService;
import me.quangtruong.services.impl.OrdersServiceImpl;
import me.quangtruong.vnpay.VNPayConfig;

@WebServlet(urlPatterns = { "/api/payment/create"})
public class ApiPaymentController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI();
		Users user = (Users) req.getAttribute("user");
		if (user==null)
			return;
		if (url.contains("/api/payment/create")) {
		
			int cost = (int) Integer.parseInt(req.getParameter("price"));
			///////////////////////////////////////////////////
			String baseUrl = req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort();
			String vnpayUrl = createOrder(cost, "Thanh toan VNPAY", "");
			System.out.println(vnpayUrl);
			IOrdersService ios = new OrdersServiceImpl();
	        List<Orders> list = ios.findAll(); 
	        if (list!=null && list.size() >0) {
	        	for (Orders o: list) {
	            	o.setOrderStatus(3);
	            	ios.update(o);
	            }
	        	System.out.println("orders prepare: "+list.size());
	        }
			resp.sendRedirect(vnpayUrl);
			
		} 

	}

	public String createOrder(int total, String orderInfor, String urlReturn) throws UnsupportedEncodingException {
		String vnp_Version = "2.1.0";
		String vnp_Command = "pay";
		String vnp_TxnRef = VNPayConfig.getRandomNumber(8);
		String vnp_IpAddr = "192.162.1.1";
		String vnp_TmnCode = VNPayConfig.vnp_TmnCode;
		String orderType = "other";

		Map<String, String> vnp_Params = new HashMap<>();
		vnp_Params.put("vnp_Version", vnp_Version);
		vnp_Params.put("vnp_Command", vnp_Command);
		vnp_Params.put("vnp_TmnCode", vnp_TmnCode);
		vnp_Params.put("vnp_Amount", String.valueOf(total * 100));
		vnp_Params.put("vnp_CurrCode", "VND");

		vnp_Params.put("vnp_TxnRef", vnp_TxnRef);
		vnp_Params.put("vnp_OrderInfo", "Thanh toan don hang 123456");
		System.out.println("OrderInfo: "+orderInfor);
		vnp_Params.put("vnp_OrderType", orderType);

		String locate = "vn";
		vnp_Params.put("vnp_Locale", locate); 
		vnp_Params.put("vnp_BankCode", "NCB");

		urlReturn = VNPayConfig.vnp_Returnurl;
		vnp_Params.put("vnp_ReturnUrl", VNPayConfig.vnp_Returnurl);
		vnp_Params.put("vnp_IpAddr", vnp_IpAddr);

		Calendar cld = Calendar.getInstance(TimeZone.getTimeZone("Etc/GMT+7"));
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		String vnp_CreateDate = formatter.format(cld.getTime());
		vnp_Params.put("vnp_CreateDate", vnp_CreateDate);
		System.out.println("CREATE_DATE: "+vnp_CreateDate);

		cld.add(Calendar.MINUTE, 15);
		String vnp_ExpireDate = formatter.format(cld.getTime());
		vnp_Params.put("vnp_ExpireDate", vnp_ExpireDate);
		//bill
		
		List fieldNames = new ArrayList(vnp_Params.keySet());
		Collections.sort(fieldNames);
		StringBuilder hashData = new StringBuilder();
		StringBuilder query = new StringBuilder(); 
		Iterator itr = fieldNames.iterator();
		while (itr.hasNext()) {
            String fieldName = (String) itr.next();
            String fieldValue = (String) vnp_Params.get(fieldName);
            if ((fieldValue != null) && (fieldValue.length() > 0)) {
                //Build hash data
                hashData.append(fieldName);
                hashData.append('=');
                hashData.append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII.toString()));
                //Build query
                query.append(URLEncoder.encode(fieldName, StandardCharsets.US_ASCII.toString()));
                query.append('=');
                query.append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII.toString()));
                if (itr.hasNext()) {
                    query.append('&');
                    hashData.append('&');
                }
                
            }
        }
        String queryUrl = query.toString();
        String vnp_SecureHash = VNPayConfig.hmacSHA512(VNPayConfig.vnp_HashSecret, hashData.toString());
        queryUrl += "&vnp_SecureHash=" + vnp_SecureHash;
		String paymentUrl = VNPayConfig.vnp_PayUrl + "?" + queryUrl;
		return paymentUrl;
	}

	

}
