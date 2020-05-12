package org.javaboy.vhr.aop.service;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    public String getUserById(Integer id){
        System.out.println("get...");
        return "袁健";
    }
    public void deleteUserById(Integer id){
        System.out.println("delete...");
    }
}
