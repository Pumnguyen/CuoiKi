package me.quangtruong.services.impl;

import java.util.List;

import me.quangtruong.dao.IUserDao;
import me.quangtruong.dao.impl.UserDaoImpl;
import me.quangtruong.entity.Users;
import me.quangtruong.services.IUserService;

public class UserServiceImpl implements IUserService{
	
	IUserDao iud = new UserDaoImpl();
	
	@Override
	public List<Users> findAll() {
		// TODO Auto-generated method stub
		return iud.findAll();
	}

	@Override
	public List<Users> findAll(int page, int pageSize) {
		// TODO Auto-generated method stub
		return iud.findAll(page, pageSize);
	}

	@Override
	public Users findById(int id) {
		// TODO Auto-generated method stub
		return iud.findById(id);
	}

	@Override
	public Users findByEmail(String email) {
		// TODO Auto-generated method stub
		return iud.findByEmail(email);
	}

	@Override
	public void insert(Users users) {
		// TODO Auto-generated method stub
		iud.insert(users);
	}

	@Override
	public boolean update(Users users) {
		// TODO Auto-generated method stub
		return iud.update(users);
	}

	@Override
	public boolean delete(String username) {
		// TODO Auto-generated method stub
		return iud.delete(username);
	}

	@Override
	public boolean login(String username, String pass) {
		// TODO Auto-generated method stub
		return iud.login(username, pass);
	}

	@Override
	public boolean softDelete(Users users) {
		// TODO Auto-generated method stub
		return iud.softDelete(users);
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return iud.count();
	}

	@Override
	public Users findByUserName(String username) {
		// TODO Auto-generated method stub
		return iud.findByUserName(username);
	}

	@Override
	public boolean register(Users users) {
		// TODO Auto-generated method stub
		return iud.register(users);
	}

}
