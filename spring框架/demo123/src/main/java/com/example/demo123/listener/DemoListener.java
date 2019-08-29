package com.example.demo123.listener;

import com.example.demo123.web.rest.util.DemoConstant;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.DelegateTask;
import org.camunda.bpm.engine.task.IdentityLink;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author
 * demo监听
 */
@Component
public class DemoListener {

    private final Logger logger = LoggerFactory.getLogger(DemoListener.class);

    /**
     * 设置审批人
     * @param execution
     */
    public void setAssignee(DelegateExecution execution){

        //获取当前登录人
        String currentUser = (String) execution.getVariable("currentUser");
        if (DemoConstant.CURRENT_USER.equals(currentUser)){
             execution.setVariable("assignee_1","李四");
        }else{
            execution.setVariable("assignee_2","王五");
        }

    }


    public void setAssignee1(DelegateExecution execution){
        List<String> usersList = new ArrayList<>();
        usersList.add("jack");
        usersList.add("tom");
        execution.setVariable("usersList",usersList);
    }



}
