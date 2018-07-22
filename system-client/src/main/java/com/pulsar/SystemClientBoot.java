package com.pulsar;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


/**
 * 系统管理微服务
 */
@EnableDiscoveryClient
@SpringBootApplication
@MapperScan("com.pulsar.user.mapper")
public class SystemClientBoot {

	public static void main(String[] args) {
		new SpringApplicationBuilder(SystemClientBoot.class).web(true).run(args);
	}

}
