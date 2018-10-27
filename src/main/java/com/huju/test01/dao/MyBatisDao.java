package com.huju.test01.dao;

import com.huju.test01.domain.Department;
import com.huju.test01.domain.Employee;
import org.apache.ibatis.annotations.*;

/**
 * Created by huju on 2018/10/27.
 */
// @Mapper
public interface MyBatisDao {

    //*********************** MyBatis注解版,注意编写 MyBatisConfig 配置类 ************************

    // @Options 可以返回自动生成的主键,useGeneratedKeys说明使用自动生成的主键,keyProperty指定哪个字段是主键
    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into department (department_name) values(#{departmentName})")
    public int insert(Department department);

    @Delete("delete from department where id = #{id}")
    public int delete(Integer id);

    @Update("update department set department_name = #{departmentName} where id = #{id}")
    public int update(Department department);

    @Select("select * from department where id = #{id}")
    public Department select(Integer id);


    //*********************** MyBatis配置版,注意现在yml文件里指定配置文件和mapper的位子 ************************

    public int insertEmp(Employee employee);

    public Employee getEmpById(Integer id);

}
