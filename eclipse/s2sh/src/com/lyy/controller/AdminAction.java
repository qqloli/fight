package com.lyy.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.lyy.pojo.User;
import com.lyy.pojo.Wangui;
import com.lyy.service.AdminService;

public class AdminAction {
	@Autowired
    private AdminService adminService;
	
	public List<User> users;
	
	public List<Wangui> wanguis;
	

	public Wangui wangui;






	public String findAllStudent() throws Exception{
        
		users = adminService.findAllUser();
       	return "success"; 
   }
	
   public String addWangui() throws Exception{
         wangui.setLateDate(new Date());
		 adminService.addWangui(wangui);
       	return "success"; 
   }
   
   public String findWangui() throws Exception{
        
		wanguis = adminService.findWangui();
      	return "success"; 
  }
	
	

	
    public List<User> getUsers() {
		return users;
	}



	public void setUsers(List<User> users) {
		this.users = users;
	}
	

	public Wangui getWangui() {
		return wangui;
	}




	public void setWangui(Wangui wangui) {
		this.wangui = wangui;
	}
	
	public List<Wangui> getWanguis() {
		return wanguis;
	}

	public void setWanguis(List<Wangui> wanguis) {
		this.wanguis = wanguis;
	}


}
