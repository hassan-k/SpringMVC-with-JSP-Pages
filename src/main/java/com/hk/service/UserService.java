package com.hk.service;

import java.util.List;
import com.hk.domain.UserModel;

/**
 * 
 * @author h.hassankhani@gmail.com
 * @version 1.1.20160827
 * @change 
 * @target
 * 
 */

public interface UserService {

	public Long saveOrUpdate(UserModel User) ;

    public UserModel getEntityById(long id) throws Exception;

	public List<UserModel> getEntityList(int page,int size) throws Exception;
	
	public List<UserModel> getEntityList() throws Exception;

	public boolean deleteEntity(long id) throws Exception;

}
