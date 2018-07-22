package com.pulsar.node.controller;

import com.pulsar.node.domain.AreaDto;
import com.pulsar.node.domain.ProvinceRelatedDto;
import com.pulsar.node.domain.ResponseDto;
import com.pulsar.node.service.AreaService;
import com.pulsar.node.service.ProvinceRelatedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AreaController extends  BaseController{
    @Autowired
    private AreaService areaService;

    @Autowired
    private ProvinceRelatedService provinceRelatedService;

    @GetMapping("/getCountryList")
    public ResponseDto getCountryList(){
        ResponseDto responseDto = new ResponseDto();
       try{
           List<AreaDto> areas = areaService.getCountryList();
           responseDto =  responseUtils.getReturnMessage(0,"获取国家列表成功",areas);
       }catch(Exception e){
           responseDto = responseUtils.getReturnMessage(-1,"E020001","获取国家列表失败",e);
       }
       return responseDto;
    }

    @GetMapping("/getProvinceList")
    public ResponseDto getProvinceList(@RequestParam("alpha2") String alpha2) {
        ResponseDto responseDto = new ResponseDto();
        try{
             List<ProvinceRelatedDto> provinces = provinceRelatedService.getProvinceList(alpha2);
            responseDto = responseUtils.getReturnMessage(0,"获取省列表成功",provinces);
        }catch(Exception e){
            responseDto = responseUtils.getReturnMessage(-1,"E020002","获取省列表失败",e);
        }
           return responseDto;
    }

}
