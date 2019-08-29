package com.lyy.dao;

import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lyy.pojo.Leave;
import com.lyy.pojo.User;

@Service
@Transactional
public class UserDao {
	@Autowired
    private SessionFactory sessionFactory;
    /**
     * 增加用户
     */
    
    public void addUser(User user) {
        // TODO Auto-generated method stub
        Session session=sessionFactory.openSession();
         
        user.setType(0);
        session.save(user);
        
		session.close();
        
    }
    
    public void addLeave(Leave leave) {
        // TODO Auto-generated method stub
        Session session=sessionFactory.openSession();
         
        
        session.save(leave);
        
		session.close();
        
    }
    
    
    public void changePwd(User user) {
        // TODO Auto-generated method stub
        Session session=sessionFactory.openSession();
        System.out.println(user.getName()+" "+user.pwd);
         
        session.createQuery(
				"update User as u set u.pwd=:newpassword where u.name=:name")
		.setString("newpassword", user.getPwd()).setString(
				"name", user.getName()).executeUpdate();

        
		session.close();
        
    }
    
    public List findLeave(int number) {
        // TODO Auto-generated method stub
        Session session=sessionFactory.openSession();
         
         
        List list=session.createQuery(
				"from Leave as l where l.number=:number")
		.setInteger("number", number).list();

        
		session.close();
        return list;
    }
    
 
    public void delLeave(Leave leave){
    	Session session=sessionFactory.openSession();
        
    	Transaction tx1 = session.beginTransaction();
    	 Leave l =(Leave) session.get(Leave.class, leave.getId());
         session.delete(l);

         tx1.commit();
		session.close();
    }
    
    public User findUser(User user){
    	boolean has = false;
    	Session session= sessionFactory.openSession();
    	List catlist = null;
    	catlist =session.createQuery("from User").list();
    	User u =new User();
    	 if (catlist != null) {
    		 Iterator it= catlist.iterator();
    		 while (it.hasNext()) {
    			   u=(User) it.next();
    			 if(u.getName().equals(user.getName()) &&u.getPwd().equals(user.getPwd())&&0==u.getType()) {
    				 has = true;
    		 break;
    			 };
    		 u=null;
    		 }}

    		 
    		session.close();

 
       return u;
    }
    
    
   
    

}
