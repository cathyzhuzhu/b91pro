package com.pulsar.node.client;

import com.pulsar.domain.NodeDto;
import com.pulsar.domain.ResponseDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author huangjuan
 * @create 2018/7/20.
 */
@FeignClient("eureka-client")
public interface EurekaClient {

    @PostMapping("/addApplyNode")
    ResponseDto addApplyNode(NodeDto nodeDto);

    @GetMapping("/getCountryList")
    ResponseDto getCountryList();

    @GetMapping("/getProvinceList")
    ResponseDto getProvinceList(@RequestParam("alpha2")String alpha2);

    @PostMapping("/sendValidateCode")
    ResponseDto sendValidateCode(@RequestParam("email")String email);


}
