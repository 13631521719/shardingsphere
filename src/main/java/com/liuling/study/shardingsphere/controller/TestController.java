package com.liuling.study.shardingsphere.controller;

import com.liuling.study.shardingsphere.entity.User;
import com.liuling.study.shardingsphere.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
public class TestController {



    @Autowired
    private UserService userService;

    @GetMapping("/select")
    public List<User> select() {
        return userService.getUserList();
    }

    @GetMapping("/insert")
    public @ResponseBody
    Map insert() {
        List<User> users=new ArrayList<>();
        Random random=new Random();
        for (int i=100;i<201;i++){
            User user=new User();
            user.setAge(random.nextInt(100));
            user.setId(i);
            user.setName("username_"+i);
            users.add(user);
        }
        userService.saveBatch(users);

        return new HashMap(){{
            put("code","200");
            put("message","success");
        }};
    }


    public static void main(String[] args) {
        Random random=new Random();
        for (int i=100;i<201;i++){
            System.out.println(random.nextInt(100));
        }
    }
}
