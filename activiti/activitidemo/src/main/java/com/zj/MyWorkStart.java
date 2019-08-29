package com.zj;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RuntimeService;
import org.junit.Test;

public class MyWorkStart {
    ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

    //启动流程
    @Test
    public void startProcess(){
        RuntimeService runtimeService = processEngine.getRuntimeService();
        runtimeService.startProcessInstanceById("myProcess_1:3:7504");  //流程的名称，对应流程定义表的key字段，也可以使用ByID来启动流程
    }


}
