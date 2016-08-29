package com.hk.dao;

import java.util.List;
import java.sql.SQLException;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.hk.domain.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.Criteria;

/**
 * 
 * @author h.hassankhani@gmail.com
 * @version 1.1.20160827
 * @change 
 * @target
 * 
 */
 
 
@Repository
public class UserDaoImpl implements UserDao {

	Logger logger = Logger.getLogger(UserDaoImpl.class);
	
	Transaction tx = null;  
	Session session ;
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public Long saveOrUpdate(UserModel user) {
		session=  sessionFactory.openSession();
		tx = session.beginTransaction(); 
		try {
			    	
			session.saveOrUpdate(user);
			        
		} catch (Exception ex) {
			      
			logger.fatal("Failed to save the entity ["+user.toString()+"] due to an exception ["+ex.getMessage()+"]", ex);
			        
			if (tx!=null && tx.isActive()){
				tx.rollback();
			    tx = null;
			}
			
		} finally {
			        
	        if (tx!=null && tx.isActive()) {
	          tx.commit();
	        }
	        session.close();
	        return user.getId();
	      }

	}


	@Override
	public UserModel getEntityById(long id) throws Exception {
		session = sessionFactory.openSession();
		UserModel user = (UserModel) session.get(UserModel.class, id);
		try {
			tx = session.beginTransaction();
			tx.commit();
		
		} catch (Exception ex){
			  logger.fatal("Failed to fetch a record User due to an exception ["+ex.getMessage()+"]", ex);
			  if (tx!=null && tx.isActive())
		        tx.rollback();
		      throw new SQLException ("Getting a record failed due an exception ["+ ex.getMessage() +"]");
		} finally {
			session.close();
		}
		return user;
	}


	@Override
	public List<UserModel> getEntityList(int page, int size) throws Exception {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(UserModel.class);
		List<UserModel> users=null;
		criteria.setFirstResult((page - 1) * size);
		criteria.setMaxResults(size);
				
		try {
			users = (List<UserModel>) criteria.list();
			tx.commit();
		} catch (Exception ex){
			  logger.fatal("Failed to fetch list User due to an exception ["+ex.getMessage()+"]", ex);
			  if (tx!=null && tx.isActive())
		        tx.rollback();
		      throw new SQLException ("Getting the list failed due an exception ["+ ex.getMessage() +"]");
		} finally {
			session.close();
		}
		return users;
	}

    @Override
	public List<UserModel> getEntityList() throws Exception {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		List<UserModel> users=null;
		
		try {
			users = session.createCriteria(UserModel.class).list();
			tx.commit();
		} catch (Exception ex){
			  logger.fatal("Failed to fetch list User due to an exception ["+ex.getMessage()+"]", ex);
			  if (tx!=null && tx.isActive())
		        tx.rollback();
		      throw new SQLException ("Getting the list failed due an exception ["+ ex.getMessage() +"]");
		} finally {
			session.close();
		}
		return users;
	}

	@Override
	public boolean deleteEntity(long id) throws Exception {
		Boolean retFlag= false;
		session = sessionFactory.openSession();
		
		try {
			UserModel user = (UserModel) session.load(UserModel.class, id);
			tx = session.beginTransaction();
			session.delete(user);
			retFlag = true;
		
		} catch (Exception ex) {
		      logger.fatal("Failed to delete all entities of User due to an exception ["+ex.getMessage()+"]", ex);;
		      
		      if (tx!=null && tx.isActive())
		        tx.rollback();
		      throw new SQLException ("deleteAll failed due an exception ["+ ex.getMessage() +"]");
		      
		} finally {
		      if (tx!=null && tx.isActive())
		        tx.commit();
		      session.close();
		}
		return retFlag;
	}	

}
