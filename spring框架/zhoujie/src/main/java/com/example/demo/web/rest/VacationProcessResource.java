package com.example.demo.web.rest;

import com.example.demo.domain.UserEntity;
import com.example.demo.domain.VacationEntity;
import com.example.demo.domain.VacationVo;
import com.example.demo.repository.UserEntityRepository;
import com.example.demo.repository.VacationEntityRepository;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

/**
 * 请假流程
 * @author
 */
@RestController
@RequestMapping("/api")
public class VacationProcessResource {

    private final Logger logger = LoggerFactory.getLogger(VacationProcessResource.class);

    private final  static String PROCESS_DEFINITION_KEY = "demo";

    private final RuntimeService runtimeService;

    private final TaskService taskService;

    private final VacationEntityRepository vacationEntityRepository;

    private final UserEntityRepository userEntityRepository;


    public VacationProcessResource(RuntimeService runtimeService, TaskService taskService, VacationEntityRepository vacationEntityRepository, UserEntityRepository userEntityRepository) {
        this.runtimeService = runtimeService;
        this.taskService = taskService;
        this.vacationEntityRepository = vacationEntityRepository;
        this.userEntityRepository = userEntityRepository;
    }


    /**
     * 发起请假流程
     * @param vacationVo
     * @return
     */
    @GetMapping("/process/start")
    @Transactional
    public String startProcessInstance(@RequestBody VacationVo vacationVo){

        UserEntity userEntity = null ;

        Optional<UserEntity> user = userEntityRepository.findById(vacationVo.getId());

        if (user.isPresent()){
          userEntity = user.get();
        }else{
           return "用户不存在无法发起流程";
        }

        VacationEntity vacationEntity = new VacationEntity(userEntity.getUserName(),vacationVo.getLeaveDay());

        VacationEntity vacation = null;
        try{
            vacation = vacationEntityRepository.save(vacationEntity);
        }catch (Exception e){
            logger.error("error message :{}",e.getMessage());
            return "创建请假单失败";
        }


        Map<String,Object> variables = new HashMap<>();
        variables.put("sex",userEntity.getSex());
        variables.put("leaveDay",vacationVo.getLeaveDay());
        variables.put("vacation_id",vacation.getId());

        ProcessInstance instance = runtimeService
                .startProcessInstanceByKey(PROCESS_DEFINITION_KEY, UUID.randomUUID().toString(),variables);

        if (null == instance){
            return "流程发起失败";
        }
        return "流程发起成功";
    }


    /**
     * 主管审批任务
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
