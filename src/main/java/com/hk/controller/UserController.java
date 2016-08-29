package com.hk.controller;

import java.util.List;

import com.hk.domain.UserModel;
import com.hk.service.UserService;
import com.hk.domain.StatusModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author h.hassankhani@gmail.com
 * @version 1.1.20160827
 * @change 
 * @target
 * 
 */
 

@RestController
@RequestMapping("/api/user")
public class UserController {
 
	@Autowired
	UserService userService;

	 /* Submit form in Spring Restful Services */  	
	 @RequestMapping(value = "/create", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE) 
	 public @ResponseBody StatusModel addUser(@RequestBody UserModel user){
		try {
     		userService.saveOrUpdate(user);
     		   return new StatusModel(1L, "User added Successfully !");
 		  } catch (Exception e) {
 		   // e.printStackTrace();
 		   return new StatusModel(0L, e.toString());
 		  }
	 }
	 
	  /* Get a single User in Json form in Spring Rest Services */ 
	 @RequestMapping(value = "/{id}", method = RequestMethod.GET)
	 public @ResponseBody UserModel getUser(@PathVariable("id") long id) {
		 UserModel user = null;
		 try {
			 user= userService.getEntityById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		 return user;
	 }
	
	  /* Getting List of Users in Json format in Spring Restful Services */ 
	 @RequestMapping(value = "/list")
	 public @ResponseBody List<UserModel> getUserList() {
		List<UserModel> users = null ;
				
		try{
			users = userService.getEntityList();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return users;
	 }
	 
	  /* Getting List of Users in Json format in Spring Restful Services */ 
	 @RequestMapping(value = "/list/page/", method = RequestMethod.GET, params = { "page", "size" })
	 public @ResponseBody List<UserModel> getUserList(@RequestParam int page,@RequestParam int size) {
		List<UserModel> users = null ;
				
		try{
			users = userService.getEntityList(page,size);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return users;
	 }
	 
	  /* Delete an User from DB in Spring Restful Services */
	 @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	 public @ResponseBody StatusModel deleteUser(@PathVariable("id") long id) {
		 try{
			 userService.deleteEntity(id);
			 return new StatusModel(1L, "User deleted Successfully !");
		 }
		 catch(Exception e){
			 return new StatusModel(0L, e.toString());
		 }
		 
	 }
	 
}

