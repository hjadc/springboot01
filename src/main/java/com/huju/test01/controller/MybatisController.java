package com.huju.test01.controller;

import com.huju.test01.dao.MyBatisDao;
import com.huju.test01.domain.Department;
import com.huju.test01.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by huju on 2018/10/27.
 */
@RestController
public class MybatisController {
    @Autowired
    MyBatisDao myBatisDao;

    // *********************** MyBatis注解版,注意编写 MyBatisConfig 配置类  ************************

    @GetMapping(value = "/insert")
    public Department insert(Department department) {
        myBatisDao.insert(department);
        return department;
    }

    @GetMapping(value = "/delete")
    public int delete(Integer id) {
        return myBatisDao.delete(id);
    }

    @GetMapping(value = "/update")
    public int update(Department department) {
        return myBatisDao.update(department);
    }

    @GetMapping(value = "/select")
    public Department select(Integer id) {
        return myBatisDao.select(id);
    }

    // *********************** MyBatis配置版,注意现在yml文件里指定配置文件和mapper的位子 ************************

    @GetMapping(value = "/insertEnp")
    public Employee insertEmp(Employee employee){
        myBatisDao.insertEmp(employee);
        return employee;
    }

    @GetMapping(value = "/getEmpById/{id}")
    public Employee getEmpById(@PathVariable("id") Integer id){
        return myBatisDao.getEmpById(id);
    }

}
