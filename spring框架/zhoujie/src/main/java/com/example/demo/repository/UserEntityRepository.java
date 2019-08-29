package com.example.demo.repository;

import com.example.demo.domain.UserEntity;
import com.sun.deploy.panel.JavaPanel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * user 数据库接口
 * @author
 */
@Repository
public interface UserEntityRepository extends JpaRepository<UserEntity,Long> {
    /**
     * 按职位查找用户
     * @param position
     * @return
     */
    List<UserEntity> findByPosition(String position);

}
