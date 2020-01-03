package com.leyou.gate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author
 * @version 1.00
 * @time 2019/12/18 0018  下午 10:17
 */

@EnableZuulProxy    //开启zuul网关
@SpringBootApplication  //
public class LeyouGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(LeyouGatewayApplication.class, args);
    }
}
