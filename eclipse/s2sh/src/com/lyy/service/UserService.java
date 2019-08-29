package com.lyy.service;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lyy.dao.UserDao;
import com.lyy.pojo.Leave;
import com.lyy.pojo.User;

@Service
public class UserService {

	@Autowired
    private UserDao userDao;
	
	public User login(User user){
	 User u =	userDao.findUser(user);
		return u;
	}
	
	
	public void register(User user){
		  	userDao.addUser(user);
			 
	}
	
	
	public void change(User user){
	  	userDao.changePwd(user);
		 
    }
	
	
	public void leave(Leave leave){
	  	userDao. addLeave(leave);
		 
    }
	
	public List findLeave(int number){
	  	List list=userDao.findLeave(number);
		return list; 
    }
	
	public void delLeave(Leave leave){
	  	 userDao.delLeave(leave);
		 
    }
	
	
	
	
}
