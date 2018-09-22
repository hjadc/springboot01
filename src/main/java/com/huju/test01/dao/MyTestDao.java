package com.huju.test01.dao;

import com.huju.test01.domain.KpiIndexDomain;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * Created by huju on 2018/9/16.
 */
@Mapper
public interface MyTestDao {


    @Select("select * from kpi_index where id = #{id}")
    KpiIndexDomain getIndexById(Long id);
}
