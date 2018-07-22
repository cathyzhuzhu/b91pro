package com.pulsar.commons.controller;

import com.pulsar.commons.client.EurekaCommonsClient;
import com.pulsar.domain.ResponseDto;
import com.pulsar.domain.SendMailDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huangjuan
 * @create 2018/7/17.
 */
@RestController
public class CommonsConsumerFeignController {
    @Autowired
    EurekaCommonsClient eurekaCommonsClient;

    @PostMapping("/sendMail")
    public ResponseDto sendMail(@RequestBody SendMailDto sendMailDto) {
        return eurekaCommonsClient.sendMail(sendMailDto);
    }
}
