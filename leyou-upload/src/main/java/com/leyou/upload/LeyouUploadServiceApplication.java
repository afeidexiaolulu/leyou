package com.leyou.upload;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author
 * @version 1.00
 * @time 2019/12/30 0030  上午 10:47
 */

@EnableDiscoveryClient
@SpringBootApplication
public class LeyouUploadServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(LeyouUploadServiceApplication.class, args);
    }
}
