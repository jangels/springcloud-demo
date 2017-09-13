package com.lzh;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
@EnableHystrix
public class EukeraClient3Application {

    public static void main(String[] args) {
        SpringApplication.run(EukeraClient3Application.class, args);
    }

    @Value("${server.port}")
    String port;

    @RequestMapping("/1/hi")
    @HystrixCommand(defaultFallback = "fallback")
    public String home(@RequestParam String name) {
        return "你好," + name + ",这是 eureka 客户端[3]:" + port;
    }

    public String fallback(String name) {
        return "hi,错误了哥." + name;
    }
}
