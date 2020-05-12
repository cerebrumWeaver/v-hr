package org.javaboy.vhr.service;

import org.javaboy.vhr.mapper.EmployeeecMapper;
import org.javaboy.vhr.model.Employeeec;
import org.javaboy.vhr.model.RespBean;
import org.javaboy.vhr.model.RespPageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @作者 cerebrumWeaver
 * @日期 2020/3/17 10:52
 */
@Service
public class EmployeeecService {
    @Autowired
    EmployeeecMapper employeeecMapper;
    public RespPageBean getEmployeecByPage(Integer page, Integer size, Employeeec empec){
        if(page != null && size !=null){
            page = (page-1)*size;
        }
        List<Employeeec> empecs = employeeecMapper.getEmployeecByPage(page, size, empec);
//        System.out.println("empecs[0]：" + empecs.get(0).toString());
        Long number = employeeecMapper.getTotal(empec);
        RespPageBean respPageBean = new RespPageBean();
        respPageBean.setData(empecs);
        respPageBean.setTotal(number);
        return respPageBean;
    }

    public Integer updateEmployeec(Employeeec employeeec){
        return employeeecMapper.updateByPrimaryKeySelective(employeeec);
    }

    public Integer deleteEmpecById(Integer id){
        return employeeecMapper.deleteByPrimaryKey(id);
    }
}
