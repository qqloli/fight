package com.example.demo123.web.rest;

import com.example.demo123.web.rest.util.DemoConstant;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * demo流程服务
 */
@RestController
@RequestMapping("/api")
public class DemoProcessController {
    private final Logger logger = LoggerFactory.getLogger(DemoProcessController.class);

    private final  static String PROCESS_DEFINITION_KEY = "demo";

    private final RuntimeService runtimeService;

    private final TaskService taskService;

    public DemoProcessController(RuntimeService runtimeService, TaskService taskService) {
        this.runtimeService = runtimeService;
        this.taskService = taskService;
    }

    @GetMapping("/process/start/one/{user}")
    public String startProcessInstance(@PathVariable String user){
        Map<String,Object> variables = new HashMap<>();
        variables.put("currentUser",user);
        if (DemoConstant.CURRENT_USER.equals(user)){
            variables.put("assignee_1","李四");
        }else{
            variables.put("assignee_2","王五");
        }

        ProcessInstance instance = runtimeService
                .startProcessInstanceByKey(PROCESS_DEFINITION_KEY, UUID.randomUUID().toString(),variables);

        if (null == instance){
            return "流程发起失败";
        }
        return "流程发起成功";
    }


    @GetMapping("/process/start/two/{user}")
    public String startProcessInstanceTwo(@PathVariable String user){
        Map<String,Object> variables = new HashMap<>();
        variables.put("currentUser",user);

        ProcessInstance instance = runtimeService
                .startProcessInstanceByKey(PROCESS_DEFINITION_KEY, UUID.randomUUID().toString(),variables);

        if (null == instance){
            return "流程发起失败";
        }
        return "流程发起成功";
    }

    /**
     * 审批任务
     * @param taskId
     * @return
     */
    @GetMapping("/process/complete/{taskId}")
    public String completeProcessInstance(@PathVariable String taskId){
        Map<String,Object> variables = new HashMap<>();
        variables.put("opinion","同意");
        try {
            taskService.complete(taskId,variables);
            return "审批成功";
        }catch (Exception e){
            logger.error("error task id :{}----error info : {}",taskId,e.getMessage());
            return "审批失败";
        }
    }
}
