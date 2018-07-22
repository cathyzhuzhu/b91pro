package com.pulsar.commons.client;

import com.pulsar.domain.SendMailDto;
import com.pulsar.domain.ResponseDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient("eureka-client")
public interface EurekaCommonsClient {

    @PostMapping("/sendMail")
    ResponseDto sendMail(SendMailDto endMailDto);
}
