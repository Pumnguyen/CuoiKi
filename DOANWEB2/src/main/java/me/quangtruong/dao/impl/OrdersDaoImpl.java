package me.quangtruong.dao.impl;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import me.quangtruong.config.JPAConfig;
import me.quangtruong.dao.IOrdersDao;
import me.quangtruong.entity.Orders;
import me.quangtruong.services.IUserService;
import me.quangtruong.services.impl.UserServiceImpl;

public class OrdersDaoImpl implements IOrdersDao{

	@Override
	public List<Orders> findAll() {
		EntityManager enma = JPAConfig.getEntityManager();
		TypedQuery<Orders> query = enma.createNamedQuery("Orders.findAll", Orders.class);
		return query.getResultList();
	}

	@Override
	public List<Orders> findAll(int page, int pageSize) {
		EntityManager enma = JPAConfig.getEntityManager();
		TypedQuery<Orders> query = enma.createNamedQuery("Orders.findAll", Orders.class);
		query.setFirstResult(page*pageSize);
		query.setMaxResults(pageSize);
		return query.getResultList();
	}

	@Override
	public Orders findById(int id) {
		EntityManager enma = JPAConfig.getEntityManager();
		Orders orders = enma.find(Orders.class, id);
		return orders;
	}

	@Override
	public void insert(Orders order) {
		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		try {
			trans.begin();
			enma.persist(order);
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		}finally {
			enma.close();
		}
		
	}

	@Override
	public boolean update(Orders order) {
		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		try {
			trans.begin();
			enma.merge(order);
			trans.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
			return false;
		}finally {
			enma.close();
		}
		return true;
	}

	@Override
	public boolean delete(int id) {
		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		try {
			trans.begin();
			Orders order = enma.find(Orders.class, id);
			if(order!=null)
				enma.remove(order);
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
			return false;
		}finally {
			enma.close();
		}
		return true;
	}

	@Override
	public List<Orders> findByIdUser(int id, int type) {
		String sql = "SELECT o FROM Orders o WHERE o.user = :userid AND o.orderStatus = :status";
		EntityManager enma = JPAConfig.getEntityManager();
		TypedQuery<Orders> query = enma.createQuery(sql, Orders.class);
		IUserService ius = new UserServiceImpl();
		query.setParameter("userid", ius.findById(id));
		query.setParameter("status", type);
		return query.getResultList();
	}

	@Override
	public List<Orders> findByIdUser(int id, int page, int pageSize, int type) {
		String sql = "SELECT o FROM Orders o WHERE o.user = :userid AND o.orderStatus = :status";
		EntityManager enma = JPAConfig.getEntityManager();
		TypedQuery<Orders> query = enma.createQuery(sql, Orders.class);
		IUserService ius = new UserServiceImpl();
		query.setParameter("userid", ius.findById(id));
		query.setFirstResult(page*pageSize);
		query.setMaxResults(pageSize);
		query.setParameter("status", type);
		return query.getResultList();
	}

	@Override
	public boolean softDelete(Orders order) {
		// TODO Auto-generated method stub
		return false;
	}

}
