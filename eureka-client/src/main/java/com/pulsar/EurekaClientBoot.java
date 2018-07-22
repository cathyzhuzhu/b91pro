package com.pulsar;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
@MapperScan("com.pulsar.node.mapper")
public class EurekaClientBoot {

	public static void main(String[] args) {
		new SpringApplicationBuilder(EurekaClientBoot.class).web(true).run(args);
	}

}
