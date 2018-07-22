package com.pulsar.user.controller;

import com.pulsar.commons.BaseController;
import com.pulsar.domain.AccountDto;
import com.pulsar.domain.ResponseDto;
import com.pulsar.user.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountController extends BaseController {
    @Autowired
    private AccountService accountService;

    @GetMapping("/getAccountList")
    public ResponseDto getAccountList(){
        ResponseDto responseDto = new ResponseDto();
        try{
            List<AccountDto> areas = accountService.getAccountList();
            responseDto =  responseUtils.getReturnMessage(0,"获取国家列表成功",areas);
        }catch(Exception e){
            responseDto = responseUtils.getReturnMessage(-1,"E020001","获取国家列表失败",e);
        }
        return responseDto;
    }

}
