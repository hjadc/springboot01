package com.huju.crud.controller;

import com.huju.crud.dao.DepartmentDao;
import com.huju.crud.dao.EmployeeDao;
import com.huju.crud.entities.Department;
import com.huju.crud.entities.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * Created by huju on 2018/10/20.
 */
@Slf4j
@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;     // 获取员工
    @Autowired
    DepartmentDao departmentDao; // 获取部门

    /**
     * 查询全部的员工
     * @param model
     * @return
     */
    @GetMapping("/emps")
    public String list(Model model) {
        Collection<Employee> all = employeeDao.getAll();
        // 放在请求域中
        model.addAttribute("emps", all);

        return "emp/list";
    }

    /**
     * 去添加员工页面
     * @param model
     * @return
     */
    @GetMapping("/emp")
    public String toAddPage(Model model) {
        // 获取部门集合,放在请求域中,给页面做下拉框用
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);

        return "emp/add";
    }

    /**
     * 保存
     * @param employee
     * @return
     */
    @PostMapping("/emp")
    public String addEmp(Employee employee) {

        log.info("**************** 添加员工信息: {}",employee.toString());
        employeeDao.save(employee);

        // redirect: 表示重定向  forward: 表示转发到一个地址
        return "redirect:/emps";
    }

    /**
     * 去修改员工页面
     * @param id
     * @return
     */
    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id,Model model) {

        Employee employee = employeeDao.get(id);
        model.addAttribute("emp",employee);

        // 获取部门集合,放在请求域中,给页面做下拉框用
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);

        // 去添加页面(页面合二为一了)
        return "emp/add";
    }

    /**
     * 修改員工
     * @param employee
     * @return
     */
    @PutMapping("/emp")
    public String updateEmployee(Employee employee){
        log.info("**************** 更新员工信息: {}",employee.toString());
        employeeDao.save(employee);

        return "redirect:/emps";
    }

    @DeleteMapping("/emp/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id){
        log.info("**************** 删除员工: {} ****************",id);
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}
