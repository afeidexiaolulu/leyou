package com.leyou.item;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author
 * @version 1.00
 * @time 2019/12/18 0018  下午 10:26
 */

@EnableDiscoveryClient  //服务注册和发现
@SpringBootApplication
@MapperScan("com.leyou.item.mapper")
public class LeyouItemService {

    public static void main(String[] args) {
        SpringApplication.run(LeyouItemService.class, args);
    }
}
