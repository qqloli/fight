package com.lyy.controller;

 
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.lyy.dao.UserDao;
import com.lyy.pojo.Leave;
import com.lyy.pojo.Pwd;
import com.lyy.pojo.User;
import com.lyy.service.AdminService;
import com.lyy.service.UserService;
import com.opensymphony.xwork2.ActionContext;

public class UserAction {
    private User user;
    private Integer type;
    private Pwd pwd;
    private Leave leave;
    private List<Leave> list;
    
   
	


	@Autowired
    private UserService userService;
	
	@Autowired
    private AdminService adminService;
    
    public String login() throws Exception{
    	
    	
        if(type==1){
        	 
        	if(adminService.login(user)==null){
            	return "fail";
            }else{
            	Map session = ActionContext.getContext().getSession();  
            	session.put("admin", adminService.login(user));  
            	return "adminsuccess";
            }
        } else{
        	 
        	if(userService.login(user)==null){
        		return "fail";
            }else{
            	Map session = ActionContext.getContext().getSession();  
            	session.put("user", userService.login(user));  
            	return "success";
            }
        }
        
        
    }
    
    public String register() throws Exception{
        
         userService.register(user);
        	return "success"; 
    }
    
    public String leave() throws Exception{
    	Map session = ActionContext.getContext().getSession();  
    	User u =(User) session.get("user");
    	leave.setName(u.getName());
    	leave.setNumber(u.getNumber());
        leave.setLeaveDate(new Date());
        userService.leave(leave);
       	return "success"; 
   }
    
    
    public String findLeave() throws Exception{
    	Map session = ActionContext.getContext().getSession();  
    	User u =(User) session.get("user");
    	 
        list= userService.findLeave(u.getNumber());
        System.out.println(list.size());
       	return "success"; 
   }
    
    public String delLeave() throws Exception{
   	    System.out.println("del"+leave.getId());
   	 
        userService.delLeave(leave);
        
      	return "success"; 
  }
    
    public String change() throws Exception{
    	Map session = ActionContext.getContext().getSession();  
    	User u =(User) session.get("user");
    	
    	if(this.pwd.getPassword().equals(u.getPwd())){
    		if(this.pwd.getPassword1().equals(this.pwd.getPassword2())){
    			User u1 =new User();
    	    	u1.setName(u.getName());
    	        u1.setPwd(this.pwd.getPassword1());
    	        userService.change(u1);
    	        u.setPwd(this.pwd.getPassword1());
    	        session.put("user", u);
    	       	return "success";
    		}else{
    			session.put("changeErr", "ȷ�����벻һ��");
    			return "fail";
    		}
    	}else{
    		session.put("changeErr", "���������");
    		return "fail";
    	}
    	
       
       
   }

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	 public Integer getType() {
			return type;
		}

		public void setType(Integer type) {
			this.type = type;
		}

		public Pwd getPwd() {
			return pwd;
		}

		public void setPwd(Pwd pwd) {
			this.pwd = pwd;
		}

 
		public Leave getLeave() {
			return leave;
		}

		public void setLeave(Leave leave) {
			this.leave = leave;
		}


		
		public List<Leave> getList() {
			return list;
		}

		public void setList(List<Leave> list) {
			this.list = list;
		}
}
