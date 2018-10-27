package com.huju.test01.repository;

import com.huju.test01.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * UserJPA继承了
 * JpaRepository接口 SpringDataJPA提供的简单数据操作接口）、
 * JpaSpecificationExecutor（SpringDataJPA提供的复杂查询接口）、
 * Serializable（序列化接口）
 *
 *, JpaSpecificationExecutor<User>, Serializable
 * 泛型里传入对象和主键类型
 * Created by huju on 2018/10/27.
 */
public interface UserRepository extends JpaRepository<User, Integer> {
}
