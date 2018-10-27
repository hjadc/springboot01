package com.huju;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

// 指定扫描哪个包下的mapper文件,后面dao接口就可以不用打@Mapper注解了
@MapperScan(value = "com.huju.*.dao")
@SpringBootApplication
@EnableSwagger2
public class Springboot001Application {

	public static void main(String[] args) {
		SpringApplication.run(Springboot001Application.class, args);
	}
}
