package com.example.demo.listener;

import com.example.demo.domain.UserEntity;
import com.example.demo.repository.UserEntityRepository;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 审批人设置监听
 * @author
 */
@Component
public class AssigneeListener {

    private final Logger logger = LoggerFactory.getLogger(AssigneeListener.class);

    private final UserEntityRepository userEntityRepository;

    public AssigneeListener(UserEntityRepository userEntityRepository) {
        this.userEntityRepository = userEntityRepository;
    }

    /**
     * 设置主管名
     * @param execution
     */
    public void setManagerAssignee(DelegateExecution execution){
      List<UserEntity> userEntities = userEntityRepository.findByPosition("主管");
      execution.setVariable("assignee_1",userEntities.get(0).getUserName());
   }

    /**
     * 设置总监名
     * @param execution
     */
    public void setChiefAssignee(DelegateExecution execution){
        List<UserEntity> userEntities = userEntityRepository.findByPosition("总监");
        execution.setVariable("assignee_2",userEntities.get(0).getUserName());
    }
}
