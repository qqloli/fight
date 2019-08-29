package com.example.demo.domain;


import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * vacation实体
 * @author
 */
@Entity
@Table(name = "vacation_t")
public class VacationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name",length = 20)
    private String userName;

    @Column(name = "leave_day")
    private Integer leaveDay;

    @Column(name = "data_state",length = 2)
    private String dataState;

    @Column(name = "created_time")
    private LocalDateTime createdTime;

    @Column(name = "created_by",length = 20)
    private String createdBy;

    @Column(name = "last_modified_date")
    private LocalDateTime lastModifiedDate;

    @Column(name = "last_modified_by",length = 20)
    private String lastModifiedBy;

    public VacationEntity() {
    }

    public VacationEntity(String userName, Integer leaveDay) {
        this.userName = userName;
        this.leaveDay = leaveDay;
        this.dataState = "0";
        this.createdBy = "admin";
        this.createdTime = LocalDateTime.now();
        this.lastModifiedBy = "admin";
        this.lastModifiedDate = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getLeaveDay() {
        return leaveDay;
    }

    public void setLeaveDay(Integer leaveDay) {
        this.leaveDay = leaveDay;
    }

    public String getDataState() {
        return dataState;
    }

    public void setDataState(String dataState) {
        this.dataState = dataState;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    @Override
    public String toString() {
        return "VacationEntity{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", leaveDay=" + leaveDay +
                ", dateState='" + dataState + '\'' +
                ", createdTime=" + createdTime +
                ", createdBy='" + createdBy + '\'' +
                ", lastModifiedDate=" + lastModifiedDate +
                ", lastModifiedBy='" + lastModifiedBy + '\'' +
                '}';
    }
}
