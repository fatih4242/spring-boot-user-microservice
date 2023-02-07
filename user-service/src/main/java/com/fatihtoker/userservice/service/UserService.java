package com.fatihtoker.userservice.service;

import com.fatihtoker.userservice.VO.Department;
import com.fatihtoker.userservice.VO.ResponseTemplateVO;
import com.fatihtoker.userservice.entity.User;
import com.fatihtoker.userservice.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {



    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;


    public User saveUser(User user) {
        log.info("inside saveUser method of UserService");
        return userRepository.save(user);
    }

    public ResponseTemplateVO getUserWithDepartment(Long userId) {
        log.info("inside getUserWithDepartment method of UserService");
        ResponseTemplateVO vo = new ResponseTemplateVO();
        User user = userRepository.findByUserId(userId);
        System.out.println("department id : " + user.getUserId());
        //changed localhost:8080 => DEPARTMENT-SERVICE
        Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" + user.getDepartmentId()
               , Department.class);


        vo.setUser(user);
        vo.setDepartment(department);
        return vo;
    }
}
