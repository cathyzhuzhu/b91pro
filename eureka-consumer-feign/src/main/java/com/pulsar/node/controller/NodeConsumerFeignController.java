package com.pulsar.node.controller;

import com.pulsar.node.client.EurekaClient;
import com.pulsar.domain.NodeDto;
import com.pulsar.domain.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author huangjuan
 * @create 2018/7/17
 */
@RestController
public class NodeConsumerFeignController {

    @Autowired
    EurekaClient eurekaClient;

    @PostMapping("/addApplyNode")
    public ResponseDto addApplyNode(@RequestBody NodeDto nodeDto) {
        return eurekaClient.addApplyNode(nodeDto);
    }

    @GetMapping("/getCountryList")
    public ResponseDto getCountryList(){
        return  eurekaClient.getCountryList();
    }

    @GetMapping("/getProvinceList")
    public ResponseDto getProvinceList(@RequestParam("alpha2")String alpha2){
        return  eurekaClient.getProvinceList(alpha2);
    }

    @PostMapping("/sendValidateCode")
    public ResponseDto sendValidateCode(@RequestParam("email")String email){
        return  eurekaClient.sendValidateCode(email);
    }

}
