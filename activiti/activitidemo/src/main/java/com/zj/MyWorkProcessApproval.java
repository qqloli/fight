package com.zj;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.TaskService;
import org.junit.Test;

public class MyWorkProcessApproval {
    ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

    @Test
    public void startProcessApproval(){

        TaskService taskService = processEngine.getTaskService();
        //taskId 就是查询任务中的 ID
        String taskId = "10004";
        //完成请假申请任务
        taskService.complete(taskId);
    }


}
