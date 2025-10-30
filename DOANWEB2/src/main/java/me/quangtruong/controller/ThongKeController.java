package me.quangtruong.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import me.quangtruong.entity.Transaction;
import me.quangtruong.entity.Users;
import me.quangtruong.services.ITransactionService;
import me.quangtruong.services.IUserService;
import me.quangtruong.services.impl.TransactionServiceImpl;
import me.quangtruong.services.impl.UserServiceImpl;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/admin/thongke", "/admin/thongke/date"}) 
public class ThongKeController extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
//		Utils.resetCookie(req, resp);
//		resp.sendRedirect(req.getContextPath() + "/login");
		
	}
	
	
	
		
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		Users user = (Users) req.getAttribute("user");
		if (user==null)
			return;
		ITransactionService its = new TransactionServiceImpl();
		IUserService ius = new UserServiceImpl();
		String url = req.getRequestURI();
		List<Transaction> list = new ArrayList<>();
	
		if (url.endsWith("/admin/thongke")) {
			list = its.findAll();
		}else if (url.contains("/admin/thongke/date")) {
			String start = req.getParameter("startDate");
			String end = req.getParameter("endDate");
			list = its.findByRangeDate(start, end);
		}
		long total = 0;
		for (Transaction t : list) {
			total += t.getTransTotalValue();
		}
		System.out.println("thong ke: "+list.size());
		req.setAttribute("trans", list);
		req.setAttribute("total", total);
		req.setAttribute("users", ius.findAll());
		req.getRequestDispatcher("/views/thongke.jsp").forward(req, resp);
//		resp.sendRedirect(req.getContextPath() + "/login");
	}
}
