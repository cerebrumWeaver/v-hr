package org.javaboy.vhr.controller.emp;

import org.apache.ibatis.annotations.Delete;
import org.javaboy.vhr.model.*;
import org.javaboy.vhr.service.*;
import org.javaboy.vhr.utils.POIUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/employee/basic")
public class EmpBasicController {
    @Autowired
    EmployeeService employeeService;    //员工基本信息表
    @Autowired
    NationService nationService;    //民族表
    @Autowired
    PoliticsstatusService politicsstatusService;    //政治面貌表
    @Autowired
    JobLevelService jobLevelService;    //职称表
    @Autowired
    PositionService positionService;    //职位表
    @Autowired
    DepartmentService departmentService;    //部门表

    @GetMapping("/")    //get类型 页码 查询员工信息
    public RespPageBean getEmployeeByPage(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size
            , Employee employee, Date[] beginDateScope/*,@RequestParam("name") String name*/) {
//        System.out.println(employee.getName());
//        System.out.println(employee.toString());
        return employeeService.getEmployeeByPage(page, size, employee,beginDateScope/*,name*/);
    }

    @PostMapping("/")   //post类型 添加员工信息
    public RespBean addEmp(@RequestBody Employee employee) {
        if (employeeService.addEmp(employee) == 1) {
            return RespBean.ok("添加成功!");
        }
        return RespBean.error("添加失败!");
    }

    @DeleteMapping("/{id}") //delete类型 id 删除员工信息
    public RespBean deleteEmpByEid(@PathVariable Integer id) {
        if (employeeService.deleteEmpByEid(id) == 1) {
            return RespBean.ok("删除成功!");
        }
        return RespBean.error("删除失败!");
    }

    @PutMapping("/")    //put类型 更新员工信息
    public RespBean updateEmp(@RequestBody Employee employee) {
        if (employeeService.updateEmp(employee) == 1) {
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }

    @GetMapping("/nations") //get类型 查询名族表
    public List<Nation> getAllNations() {
        return nationService.getAllNations();
    }

    @GetMapping("/politicsstatus")  //get类型 查询政治面貌表
    public List<Politicsstatus> getAllPoliticsstatus() {
        return politicsstatusService.getAllPoliticsstatus();
    }

    @GetMapping("/joblevels")   //get类型 查询职称表
    public List<JobLevel> getAllJobLevels() {
        return jobLevelService.getAllJobLevels();
    }

    @GetMapping("/positions")   //get类型 查询职位表
    public List<Position> getAllPositions() {
        return positionService.getAllPositions();
    }

    @GetMapping("/maxWorkID")   //get类型 查询员工表maxWorkID
    public RespBean maxWorkID() {
        RespBean respBean = RespBean.build().setStatus(200)
                .setObj(String.format("%08d", employeeService.maxWorkID() + 1));
        return respBean;
    }

    @GetMapping("/deps")    //get类型 查询部门表
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @GetMapping("/export")  //get下载类型 员工信息表 导出 为Excel表
    public ResponseEntity<byte[]> exportData(@RequestParam(defaultValue = "1") Integer page,
                                             @RequestParam(defaultValue = "10") Integer size, Employee employee, Date[] beginDateScope/*,
                                             @RequestParam("name") String name*/) {
        List<Employee> list = (List<Employee>) employeeService.getEmployeeByPage(page, size, employee,beginDateScope/*,name*/).getData();
        return POIUtils.employee2Excel(list);
    }

    @PostMapping("/import") //post上传类型 Excel数据 导入 为员工信息表
    public RespBean importData(MultipartFile file) throws IOException {
        List<Employee> list = POIUtils.excel2Employee(file, nationService.getAllNations(), politicsstatusService.getAllPoliticsstatus(), departmentService.getAllDepartmentsWithOutChildren(), positionService.getAllPositions(), jobLevelService.getAllJobLevels());
        if (employeeService.addEmps(list) == list.size()) {
            return RespBean.ok("上传成功");
        }
        return RespBean.error("上传失败");
    }
}
