package com.hk.service;

import java.util.List;

import com.hk.dao.UserDao;
import com.hk.domain.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author h.hassankhani@gmail.com
 * @version 1.1.20160827
 * @change 
 * @target
 * 
 */
 

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao; 
	
	@Override
	public Long saveOrUpdate(UserModel user) {
		return userDao.saveOrUpdate(user);

	}

	@Override
	public UserModel getEntityById(long id) throws Exception {
		UserModel user = userDao.getEntityById(id);
		return user ;
	}

	@Override
	public List<UserModel> getEntityList(int page,int size) throws Exception {
		List<UserModel> users = userDao.getEntityList(page,size);
		return users;
	}
	
	@Override
	public List<UserModel> getEntityList() throws Exception {
		List<UserModel> users = userDao.getEntityList();
		return users;
	}

	@Override
	public boolean deleteEntity(long id) throws Exception {
		userDao.deleteEntity(id);
		return false;
	}
	
	

}
