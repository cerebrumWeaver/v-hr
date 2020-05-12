package org.javaboy.vhr;

import org.javaboy.vhr.aop.service.UserService;
import org.javaboy.vhr.service.EmployeeService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VhrApplicationTests {
    @Autowired
    UserService userService;


    @Test   //service接口测试
    public void contextLoads() {

        boolean flag=true;
        String[] strings = new String[10];

        userService.getUserById(10);
        userService.deleteUserById(10);
    }

//    @Autowired
//    EmployeeService employeeService;
//    @Autowired
//    WebApplicationContext wac;
//    MockMvc mockMvc;
//    @Before
//    public void before(){
//        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
//    }
//    @Test
//    public void test1(){
//        MvcResult mvcResult = mockMvc.perform(
//                MockMvcRequestBuilders
//                        .get("/")
//                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
//                        .param()
//        );
//    }

}
