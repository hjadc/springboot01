package com.huju.crud.controller;

import com.huju.crud.dao.DepartmentDao;
import com.huju.crud.dao.EmployeeDao;
import com.huju.crud.entities.Department;
import com.huju.crud.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

/**
 * Created by huju on 2018/10/20.
 */
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
}
