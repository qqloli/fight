package com.example.demo1.web.rest;


import com.example.demo1.domain.UserEntity;
import com.example.demo1.repository.UserEntityRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * user 服务类
 * @author
 */

@RestController
@RequestMapping("/api")
public class UserEntityResource {

    private static final Logger logger = LoggerFactory.getLogger(UserEntityResource.class);

    private final UserEntityRepository userEntityRepository;

    public UserEntityResource(UserEntityRepository userEntityRepository) {
        this.userEntityRepository = userEntityRepository;
    }

    /**
     * 保存单个user
     *
     * @return
     */
    @PostMapping("/save/user")
    public String saveUserEntity(HttpServletRequest req, HttpServletResponse resp, Object handler, Exception e){

        req.getSession();
        //初始化user
        UserEntity entity = new UserEntity("张三",16,"M","1","admin",
                "admin");

        //保存user
        UserEntity result = userEntityRepository.save(entity);
        return result.toString();
    }

    /**
     * 保存单个user
     *
     * @return
     */
    @PostMapping("/save/p/user")
    public String saveUserEntity(@RequestBody UserEntity userEntity,HttpServletRequest req,HttpServletResponse resp,@CookieValue(value = "JSESSIONID") String jsessionid){
        req.getSession();
        userEntity.setDateState("1");
        userEntity.setLastModifiedBy("admin");
        userEntity.setLastModifiedDate(LocalDateTime.now());
        userEntity.setCreatedBy("admin");
        userEntity.setCreateTime(LocalDateTime.now());
        UserEntity result = userEntityRepository.save(userEntity);
        System.out.println(jsessionid);

//        Cookie cookie = new Cookie("JSESSIONID",jsessionid);
//        resp.addCookie(cookie);

        return result.toString();
    }

    /**
     * 批量保存user
     * @param list
     * @return
     */
    @PostMapping("/save/list")
    public String saveUserList(@RequestBody List<UserEntity> list){
        for (UserEntity entity : list) {
            entity.setDateState("1");
            entity.setLastModifiedBy("admin");
            entity.setLastModifiedDate(LocalDateTime.now());
            entity.setCreatedBy("admin");
            entity.setCreateTime(LocalDateTime.now());
        }
       List<UserEntity> userEntityList = userEntityRepository.saveAll(list);
       StringBuffer sb = new StringBuffer();
        for (UserEntity userEntity : userEntityList) {
            sb.append(userEntity.toString());
        }


        return sb.toString();
    }

    /**
     * 查询一个user
     * @param id
     * @return
     */
    @GetMapping("/find/one/{id}")
    public String findOneUser(@PathVariable Long id){
       Optional<UserEntity> result = userEntityRepository.findById(id);
       if (!result.isPresent()){
           return "用户不存在";
       }
       return result.toString();
    }

    /**
     * 批量查询
     * @param sex
     * @return
     */
    @GetMapping("/find/list/{sex}")
    public String findUserList(@PathVariable String sex){
       List<UserEntity> userEntityList = userEntityRepository.findBySex(sex);

       if (null == userEntityList || 0 == userEntityList.size()){
           return "用户不存在";
       }
       StringBuffer sb = new StringBuffer();
        for (UserEntity userEntity : userEntityList) {
            sb.append(userEntity.toString());
        }
        return sb.toString();
    }

    /**
     * 查询人名清单
     * @return
     */
    @GetMapping("/find/name/list")
    public List<String> findNameList(){
       return userEntityRepository.findNameList();
    }

    /**
     * 查询年龄清单
     * @param sex
     * @param dataState
     * @return
     */
    @GetMapping("/find/age/list/{sex}/{dataState}")
    public List<Integer> findAgeList(@PathVariable String sex ,@PathVariable String dataState){
        return userEntityRepository.findAgeList(sex,dataState);
    }

    @GetMapping("/find/list/sex/sp")
    public String findUserListSp(@RequestParam(name = "s") String sex,@RequestParam(name = "n",required = false) String name){
        logger.info("param info : sex = {} ;name ={}",sex,name);
        List<UserEntity> result = userEntityRepository.findBySex(sex);

        if ( null == result || 0 == result.size()){
            return "用户不存在";
        }

        StringBuffer sb = new StringBuffer();
        for (UserEntity userEntity : result) {
            sb.append(userEntity.toString());
        }
        return sb.toString();
    }

    /**
     * 更新user
     * @param userEntity
     * @return
     */
    @PutMapping("/update/user")
    public String updateUser(@RequestBody UserEntity userEntity){
        //先查询user
        UserEntity user = userEntityRepository.getOne(userEntity.getId());
        //设置需要修改的值
        user.setSex("F");
        //更新
        UserEntity result = userEntityRepository.save(user);
        return result.toString();
    }

    /**
     * 修改年龄
     * @param userEntity
     * @return
     */
    @PutMapping("/update/age")
    public Integer updateAge(@RequestBody UserEntity userEntity){
        return userEntityRepository.updateAge(userEntity.getAge(),userEntity.getName());
    }

    /**
     * 软删除
     * @param id
     * @return
     */
    @PutMapping("/delete/s/user/{id}")
    public String deleteUserSoft(@PathVariable Long id){

        Optional<UserEntity> result = userEntityRepository.findById(id);
        if (result.isPresent()){
            userEntityRepository.deleteUser(id);
            return "删除成功";
        }else {
            return "用户不存在";
        }

    }

    /**
     * 硬删除
     * @param id
     * @return
     */
    @DeleteMapping("/delete/user/{id}")
    public String deleteUser(@PathVariable Long id){

        Optional<UserEntity> result = userEntityRepository.findById(id);

        if (result.isPresent()){
            userEntityRepository.deleteById(id);
            return "删除成功";
        }else {
            return "用户不存在";
        }
    }


    /**
     * 查询大于年龄
     * @param age
     * @return
     */
    @GetMapping("/find/user/ageLess/{age}")
    public String findAgeLessThan(@PathVariable Integer age){
      List<UserEntity> userEntityList = userEntityRepository.findByAgeLessThan(age);
      if(null == userEntityList || 0==userEntityList.size()){
            return "小于年龄用户不存在";
      }
      StringBuffer sb = new StringBuffer();

      for (UserEntity userEntity : userEntityList) {
            sb.append(userEntity.toString());
      }
      return sb.toString();
    }

    /**
     * 查询大于年龄
     * @param age
     * @return
     */
    @GetMapping("/find/user/ageGreater/{age}")
    public String findAgeGreaterThan(@PathVariable Integer age){
        List<UserEntity> userEntityList = userEntityRepository.findByAgeGreaterThan(age);
        if(null == userEntityList || 0==userEntityList.size()){
            return "大于年龄用户不存在";
        }
        StringBuffer sb = new StringBuffer();
        for (UserEntity userEntity : userEntityList) {
            sb.append(userEntity.toString());
        }
        return sb.toString();
    }

    /**
     * 查询区间年龄
     * @param age1
     * @param age2
     * @return
     */
    @GetMapping("/find/user/ageBetween/{age1}/{age2}")
    public String findByAgeBetween(@PathVariable Integer age1,@PathVariable Integer age2){

        List<UserEntity> userEntityList = userEntityRepository.findByAgeBetween(age1,age2);

        if(null == userEntityList || 0==userEntityList.size()){
            return "区间年龄用户不存在";
        }
        StringBuffer sb = new StringBuffer();
        for (UserEntity userEntity : userEntityList) {
            sb.append(userEntity.toString());
        }
        return sb.toString();
    }

}
