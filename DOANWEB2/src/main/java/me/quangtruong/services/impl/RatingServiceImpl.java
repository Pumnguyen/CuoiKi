package me.quangtruong.services.impl;

import java.util.List;

import me.quangtruong.dao.IRatingDao;
import me.quangtruong.dao.impl.RatingDaoImpl;
import me.quangtruong.entity.Rating;
import me.quangtruong.services.IRatingService;

public class RatingServiceImpl implements IRatingService{
	
	IRatingDao idao = new RatingDaoImpl();
	
	@Override
	public List<Rating> findAll() {
		// TODO Auto-generated method stub
		return idao.findAll();
	}

	@Override
	public List<Rating> findAll(int page, int pageSize) {
		// TODO Auto-generated method stub
		return idao.findAll(page, pageSize);
	}

	@Override
	public Rating findById(int id) {
		// TODO Auto-generated method stub
		return idao.findById(id);
	}

	@Override
	public void insert(Rating rating) {
		// TODO Auto-generated method stub
		idao.insert(rating);
	}

	@Override
	public boolean update(Rating rating) {
		// TODO Auto-generated method stub
		return idao.update(rating);
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return idao.delete(id);
	}

	@Override
	public List<Rating> findByIdList(int id) {
		// TODO Auto-generated method stub
		return idao.findAll(id, id);
	}

	@Override
	public List<Rating> findByIdList(int id, int page, int pageSize) {
		// TODO Auto-generated method stub
		return idao.findByIdList(id, page, pageSize);
	}

	@Override
	public boolean softDelete(Rating rating) {
		// TODO Auto-generated method stub
		return idao.softDelete(rating);
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return idao.count();
	}
	
}
