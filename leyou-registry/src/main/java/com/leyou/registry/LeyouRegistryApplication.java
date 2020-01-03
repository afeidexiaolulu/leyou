package com.leyou.registry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author
 * @version 1.00
 * @time 2019/12/18 0018  下午 10:09
 */

@EnableEurekaServer //注册中心
@SpringBootApplication
public class LeyouRegistryApplication {

    public static void main(String[] args) {
        SpringApplication.run(LeyouRegistryApplication.class, args);
    }

}
