package com.zj;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.DeploymentBuilder;
import org.junit.Test;

public class MyWorkDeploy {
    ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

    //部署流程
    @Test
    public void deployProcess(){
        RepositoryService repositoryService = processEngine.getRepositoryService();
        DeploymentBuilder builder = repositoryService.createDeployment();
        builder.addClasspathResource("WorkTestNew.bpmn");//bpmn文件的名称
        builder.deploy();
    }




}
