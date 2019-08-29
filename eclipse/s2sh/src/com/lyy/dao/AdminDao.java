package com.lyy.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lyy.pojo.User;
import com.lyy.pojo.Wangui;

@Service
@Transactional
public class AdminDao {
	@Autowired
    private SessionFactory sessionFactory;
	
	
	public User findUser(User user){
    	boolean has = false;
    	Session session= sessionFactory.openSession();
    	List catlist = null;
    	catlist =session.createQuery("from User").list();
    	 User u = new User();
    	 if (catlist != null) {
    		 Iterator it= catlist.iterator();
    		 while (it.hasNext()) {
    			 u  =(User) it.next();
    			 if(u.getName().equals(user.getName()) &&u.getPwd().equals(user.getPwd())&&1==u.getType()) {
    				 has = true;
    		 break;
    			 };
    		 has= false;
    		 }}

    		 
    		session.close();

 
       return u;
    }
	
	
	public List findAllUser(){
    	 
    	Session session= sessionFactory.openSession();
    	List catlist = null;
    	catlist =session.createQuery("from User as u where u.type=0").list();
    	 

    	session.close();
 
       return catlist;
    }
	
	
	public List findWangui(){
   	 
    	Session session= sessionFactory.openSession();
    	List catlist = null;
    	catlist =session.createQuery("from Wangui").list();
    	 

    	session.close();
 
       return catlist;
    }
	
	
	public void addWangui(Wangui wangui){
   	 
    	Session session= sessionFactory.openSession();
    	 session.save(wangui);
    	 

    	session.close();
 

    }
}
