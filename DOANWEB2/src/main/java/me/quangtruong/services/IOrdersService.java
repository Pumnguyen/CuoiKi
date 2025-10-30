package me.quangtruong.services;

import java.util.List;

import me.quangtruong.entity.Orders;

public interface IOrdersService {
	
	List<Orders> findAll();
	
	List<Orders> findAll(int page, int pageSize);
	
	Orders findById(int id);
	
	void insert(Orders order);
		 
	boolean update(Orders order); 
	
	boolean delete(int id);
	
	List<Orders> findByIdUser(int id, int type);
	
	List<Orders> findByIdUser(int id, int page, int pageSize, int type);
	
	boolean softDelete(Orders order);
}
