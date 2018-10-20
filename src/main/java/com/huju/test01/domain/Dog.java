package com.huju.test01.domain;

/**
 * Created by huju on 2018/9/22.
 */
public class Dog {
    private String name; // 小狗的名称
    private Integer age; // 小狗的年龄

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
