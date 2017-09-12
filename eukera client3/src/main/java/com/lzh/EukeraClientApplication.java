package com.lzh;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class EukeraClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(EukeraClientApplication.class, args);
	}
	@Value("${server.port}")
	String port;
	@RequestMapping("/1/hi")
	public String home(@RequestParam String name) {
		return "你好,"+name+",这是 eureka 客户端[3]:" +port;
	}
}
