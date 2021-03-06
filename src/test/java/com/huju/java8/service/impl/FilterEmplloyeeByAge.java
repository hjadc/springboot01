package com.huju.java8.service.impl;

import com.huju.java8.entity.Employee;
import com.huju.java8.service.MyPredicate;

public class FilterEmplloyeeByAge implements MyPredicate<Employee> {


    /**
     * 根据年龄来过滤的具体实现策略
     *
     * @param employee
     * @return
     */
    @Override
    public boolean filter(Employee employee) {
        return employee.getAge() > 35;
    }
}
