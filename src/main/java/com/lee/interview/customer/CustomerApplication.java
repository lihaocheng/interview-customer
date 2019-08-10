package com.lee.interview.customer;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
@ComponentScan(basePackages = {"com.lee.interview"})
@MapperScan("com.lee.interview.customer.mapper")
public class CustomerApplication extends SpringBootServletInitializer{
	
	@Value("${spring.application.name}")
	private String applicationName;
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(CustomerApplication.class, args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(this.getClass());
	}
	
	@RequestMapping("/")
	public String home() {
		return "hello aniu application name : " + applicationName;
	}
	
//	@RequestMapping("/userinfo/")
//	public UserInfo userInfo() {
//		UserInfo userInfo = new UserInfo();
//		userInfo.setUserId(1);
//		userInfo.setUserName("zhangsan");
//		return userInfo;
//	}
}
