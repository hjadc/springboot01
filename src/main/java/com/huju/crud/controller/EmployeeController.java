package com.huju.crud.controller;

import com.huju.crud.dao.EmployeeDao;
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
    EmployeeDao employeeDao;

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
}
