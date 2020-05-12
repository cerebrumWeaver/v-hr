package org.javaboy.vhr.controller;

import org.javaboy.vhr.model.Hr;
import org.javaboy.vhr.model.RespBean;
import org.javaboy.vhr.service.HrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @作者 cerebrumWeaver
 * @日期 2020/3/10 14:02
 */

@RestController
public class HrInfoController {
    @Autowired
    HrService hrService;

    @GetMapping("/hr/info")
    public Hr getCurrentHr(Authentication authentication){
        return (Hr) authentication.getPrincipal();
    }

    @PutMapping(value = "/hr/password") //修改密码
    public RespBean changePassword(@RequestBody Hr hr/*,@RequestBody String prePassword, String newPassword, String confirmPassword*/){
        String password = hr.getPassword();
        System.out.println(password);
        System.out.println("id："+hr.getId());
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodePassword = encoder.encode(password);
        hr.setPassword(encodePassword);
        if (hrService.updatePassword(hr) == 1){
            return RespBean.ok("完成密码修改");
        }
        return RespBean.error("更新失败");
    }
}
