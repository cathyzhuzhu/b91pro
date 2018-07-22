package com.pulsar.user.service;

import com.pulsar.domain.AccountDto;

import java.util.List;

    /**
     *  账户管理服务层接口
     */
    public interface AccountService {
        /**
         * 查询账户列表
         * @return 返回账户列表信息
         */
        List<AccountDto> getAccountList();


}
