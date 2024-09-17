package com.letsfly.rest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.letsfly.dto.UserDto;
import com.letsfly.model.User;
import com.letsfly.utils.restUtils.BaseRest;

@RestController
@RequestMapping("user")
public class UserRest extends BaseRest<User,Integer,UserDto>{

    public UserRest(JpaRepository<User, Integer> rep) {
        super(rep);
        //TODO Auto-generated constructor stub
    }


}