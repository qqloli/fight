package com.lyy.service;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lyy.dao.AdminDao;
import com.lyy.dao.UserDao;
import com.lyy.pojo.User;
import com.lyy.pojo.Wangui;

@Service
public class AdminService {

	@Autowired
    private AdminDao adminDao;
	
	public User login(User user){
	 User u =	adminDao.findUser(user);
		return u;
	}
	
	public List findAllUser(){
 
       return  adminDao.findAllUser();
    }
	
	
	public List findWangui(){
		 
	       return  adminDao.findWangui();
	}
	
	
	public void addWangui(Wangui wangui){
		 
	       adminDao.addWangui(wangui);
	    }
}
