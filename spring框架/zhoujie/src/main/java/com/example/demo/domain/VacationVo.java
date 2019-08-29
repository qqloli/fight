package com.example.demo.domain;

import java.time.LocalDateTime;

public class VacationVo {

    private Long id;

    private Integer leaveDay;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getLeaveDay() {
        return leaveDay;
    }

    public void setLeaveDay(Integer leaveDay) {
        this.leaveDay = leaveDay;
    }
}
