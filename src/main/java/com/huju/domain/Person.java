package com.huju.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by huju on 2018/9/22.
 *
 *  测试将配置文件中配置的每一个属性的值,映射到这个组件中
 *  1.批量获取:
 *      @ConfigurationProperties: 告诉springboot将本类的所有属性和配置文件中相关的配置进行绑定
 *           prefix = "person": 获取配置文件中哪个下面的所有属性进行一一映射
 *      @Component 意思是将该文件类加入容器中;因为只有这个组件是容器中的组件才能使用容器提供的 @ConfigurationProperties 功能
 *      测试在单元测试里,只要引入该类,就能拿到所有值了
 *      这个支持松散语法绑定(大写用-或者-表示,比如能拿到yml的last-name的值)
 *      这个还支持参数校验,比如在该类上打上 @Validated 注解,再在字段上打上 @Email,就能校验拿到的值是不是email格式的
 *
 *  2.也可以用这个注解获取单个内容 @Value("${person.testa}")
 *
 *  3.@PropertySource
 *      @ConfigurationProperties(prefix = "person") 默认读的是全局的那个配置文件,但是把东西都卸载全局的配置文件里不太合适,
 *     那么就可以用到 @PropertySource(value = {"classpath:person.properties"}) 注解,该注解用于指定去读取哪个配置文件,value里
 *     可以传入多个文件路径
 */

@Component  // 将该组件加入容器
@ConfigurationProperties(prefix = "person") // 指定获取哪个属性下面的
@Validated  // 参数校验使用
@PropertySource(value = {"classpath:person.properties"})
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

    // 测试参数校验
    @Email(message = "请提供一个正确的邮箱")
    private String email;

    // 测试@value("${}")获取配置之文件内容,这个用的也挺多的
    @Value("${person.testa}")
    private String test01;
    // 测试@value("#{}")表达式赋值内容;这个是spel语法
    @Value("#{5*6}")
    private String test02;

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

    public String getTest01() {
        return test01;
    }

    public void setTest01(String test01) {
        this.test01 = test01;
    }

    public String getTest02() {
        return test02;
    }

    public void setTest02(String test02) {
        this.test02 = test02;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
                ", email='" + email + '\'' +
                ", test01='" + test01 + '\'' +
                ", test02='" + test02 + '\'' +
                '}';
    }
}
