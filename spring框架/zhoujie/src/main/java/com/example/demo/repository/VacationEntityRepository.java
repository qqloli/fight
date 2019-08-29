package com.example.demo.repository;

import com.example.demo.domain.UserEntity;
import com.example.demo.domain.VacationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * vacation 数据库接口
 * @author
 */
@Repository
public interface VacationEntityRepository extends JpaRepository<VacationEntity,Long> {

    /**
     * 修改请假状态
     * @param id
     * @return
     */
    @Transactional
    @Modifying
    @Query("update VacationEntity v set v.dataState=1 where v.id = ?1")
    Integer updateDataState(Long id);
}
