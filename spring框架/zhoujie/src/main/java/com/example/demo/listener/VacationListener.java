package com.example.demo.listener;

import com.example.demo.repository.VacationEntityRepository;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 请假流程监听
 * @author
 */
@Component
public class VacationListener {

    private final Logger logger = LoggerFactory.getLogger(AssigneeListener.class);

    private final VacationEntityRepository vacationEntityRepository;

    public VacationListener(VacationEntityRepository vacationEntityRepository) {
        this.vacationEntityRepository = vacationEntityRepository;
    }


    /**
     * 流程结束监听 修改dataState为1
     * @param execution
     */
    public void processEnd(DelegateExecution execution){

       Long id = (Long) execution.getVariable("vacation_id");

       vacationEntityRepository.updateDataState(id);
    }
}
