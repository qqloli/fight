package com.example.demo1.repository;

import com.example.demo1.domain.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * user 数据库接口
 * @author
 */
@Repository
public interface UserEntityRepository extends JpaRepository<UserEntity,Long> {
    List<UserEntity> findBySex(String sex);

    List<UserEntity> findBySexAndDateState(String sex,String dataState);

    /**
     * 自定义查询人名
     * @return
     */
    @Query("select u.name from UserEntity u ")
    List<String> findNameList();

    /**
     * 查询年龄清单
     * @param sex
     * @param dataState
     * @return
     */
    @Query("select u.age from UserEntity u where u.sex = ?1 and u.dateState= ?2")
    List<Integer> findAgeList(String sex,String dataState);

    /**
     * 修改年龄
     * @param age
     * @param name
     * @return
     */
    @Transactional
    @Modifying
    @Query("update UserEntity u set u.age=?1 where u.name = ?2")
    Integer updateAge(Integer age ,String name);


    /**
     * 软删除
     * @param id
     * @return
     */
    @Transactional
    @Modifying
    @Query("update UserEntity u set u.dateState = 0 where u.id = ?1")
    Integer deleteUser(Long id);

    /**
     * 查询年龄小于的用户
     * @param age
     * @return
     */
    List<UserEntity> findByAgeLessThan(Integer age);

    /**
     * 查询年龄大于的用户
     * @param age
     * @return
     */
    List<UserEntity> findByAgeGreaterThan(Integer age);


    /**
     * 查询年龄在之间的用户
     * @param age1
     * @param age2
     * @return
     */
    List<UserEntity> findByAgeBetween(Integer age1,Integer age2);
}
