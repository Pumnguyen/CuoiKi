package me.quangtruong.config;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import me.quangtruong.services.IProductCategoryService;
import me.quangtruong.services.IRatingService;
import me.quangtruong.services.IUserService;
import me.quangtruong.services.impl.ProductCategoryServiceImpl;
import me.quangtruong.services.impl.RatingServiceImpl;
import me.quangtruong.services.impl.UserServiceImpl;

public class Test {
	
	public static void main(String[] args) {
		
		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		IRatingService s = new RatingServiceImpl();
		
		
		try {
			trans.begin();
			trans.commit();
			System.out.println("ok");
			s.count();
		}catch(Exception e) {
			e.printStackTrace();
			trans.rollback();
			throw e;
		} finally {
			enma.close();
		}

	}
	
	

}
