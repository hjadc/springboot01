package com.huju.domain;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by huju on 2018/9/22.
 *  测试将配置文件中配置的每一个属性的值,映射到这个组件中
 *  @ConfigurationProperties: 告诉springboot将本类的所有属性和配置文件中相关的配置进行绑定
 *       prefix = "person": 获取配置文件中哪个下面的所有属性进行一一映射
 *  @Component 意思是将该文件类加入容器中;因为只有这个组件是容器中的组件才能使用容器提供的 @ConfigurationProperties 功能
 *  测试在单元测试里,只要引入该类,就能拿到所有值了
 */
@Component
@ConfigurationProperties(prefix = "person")
public class Person {
    // 对象的名称
    private String lastName;
    // 对象的年龄
    private Integer age;
    // 该对象是老板吗
    private Boolean boss;
    // 对象的生日
    private Date birth;
    // 对象里放map,第二个值不转意"",第三个值转意''
    private Map<String,Object> maps;
    // 对象里放集合,yml的第一种写法
    private List<Object> alists;
    // 对象里放集合,yml的第二种写法
    private List<Object> blists;
    // 对象里放对象
    private Dog dog;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getBoss() {
        return boss;
    }

    public void setBoss(Boolean boss) {
        this.boss = boss;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Map<String, Object> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, Object> maps) {
        this.maps = maps;
    }

    public List<Object> getAlists() {
        return alists;
    }

    public void setAlists(List<Object> alists) {
        this.alists = alists;
    }

    public List<Object> getBlists() {
        return blists;
    }

    public void setBlists(List<Object> blists) {
        this.blists = blists;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    @Override
    public String toString() {
        return "Person{" +
                "lastName='" + lastName + '\'' +
                ", age=" + age +
                ", boss=" + boss +
                ", birth=" + birth +
                ", maps=" + maps +
                ", alists=" + alists +
                ", blists=" + blists +
                ", dog=" + dog +
                '}';
    }
}
