package com.huju.test01.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by huju on 2018/10/27.
 */
@Entity // 告诉jpa这是一个实体类(和数据库表映射的类)
@Table(name = "tbl_user") // 指定和哪个数据表对应,如果省略默认表名就是user
public class User implements Serializable{

    @Id // 这是一个主键
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 自增主键
    private Integer id;
    @Column(name = "last_name",length = 50) // 这是和数据库表对应的一个列
    private String lastName;
    @Column // 省略默认列名就是属性名
    private String email;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
