package com.pulsar.user.mapper;

import com.pulsar.domain.AccountDto;

import java.util.List;

public interface AccountMapper {
    /**
     * 账户管理列表
     * @return 返回账户管理列表信息
     */
    List<AccountDto> getAccountList();


}
