package org.javaboy.vhr.aop.controller;

import org.javaboy.vhr.aop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("/getUserById")
    public String getUserById(Integer id){
        return  userService.getUserById(id);
    }
    @GetMapping("/deleteUserById")
    public void deleteUserId(Integer id){
        userService.deleteUserById(id);
    }


}
