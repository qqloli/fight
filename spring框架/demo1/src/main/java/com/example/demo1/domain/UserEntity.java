package com.example.demo1.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * user 实体
 * @author
 */

@Entity
@Table(name = "user_t")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name",length = 20)
    private String name;

    @Column(name = "age")
    private Integer age;

    @Column(name = "sex",length = 1)
    private String sex;

    @Column(name = "data_state",length = 2)
    private String dateState;

    @Column(name = "create_time")
    private LocalDateTime createTime;

    @Column(name = "created_by",length = 20)
    private String createdBy;

    @Column(name = "last_modified_date")
    private LocalDateTime lastModifiedDate;

    @Column(name = "last_modified_by",length = 20)
    private String lastModifiedBy;

    public UserEntity() {
    }

    public UserEntity( String name, Integer age, String sex, String dateState, String createdBy, String lastModifiedBy) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.dateState = dateState;
        this.createTime = LocalDateTime.now();
        this.createdBy = createdBy;
        this.lastModifiedDate = LocalDateTime.now();
        this.lastModifiedBy = lastModifiedBy;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDateState() {
        return dateState;
    }

    public void setDateState(String dateState) {
        this.dateState = dateState;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
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
        return "UserEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", dateState='" + dateState + '\'' +
                ", createTime=" + createTime +
                ", createdBy='" + createdBy + '\'' +
                ", lastModifiedDate=" + lastModifiedDate +
                ", lastModifiedBy='" + lastModifiedBy + '\'' +
                '}';
    }
}
