package org.javaboy.vhr.controller.emp;

import org.javaboy.vhr.model.Employeeec;
import org.javaboy.vhr.model.RespBean;
import org.javaboy.vhr.model.RespPageBean;
import org.javaboy.vhr.service.EmployeeecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @作者 cerebrumWeaver
 * @日期 2020/3/17 11:49
 */
@RestController
@RequestMapping("/empec")
public class EmpecController {
    @Autowired
    EmployeeecService employeeecService;
    @GetMapping("/")
    public RespPageBean getEmployeecByPage(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size, Employeeec empec){
        return employeeecService.getEmployeecByPage(page, size, empec);
    }

    @PutMapping("/")
    public RespBean updateEmployeec(@RequestBody Employeeec empec){
        if(employeeecService.updateEmployeec(empec)==1){
           return RespBean.ok("更新成功");
        }
        return RespBean.error("更新失败");
    }

    @DeleteMapping("/{id}")
    public RespBean deleteEmpecById(@PathVariable Integer id){
        if(employeeecService.deleteEmpecById(id)==1){
            return RespBean.ok("更新成功");
        }
        return RespBean.error("更新失败");
    }
}
