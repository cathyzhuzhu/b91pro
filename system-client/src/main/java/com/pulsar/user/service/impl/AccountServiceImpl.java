package com.pulsar.user.service.impl;

import com.pulsar.domain.AccountDto;
import com.pulsar.user.mapper.AccountMapper;
import com.pulsar.user.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 系统管理业务实现层
 */
@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountMapper accountMapper;

    @Override
    public List<AccountDto> getAccountList() {
        return accountMapper.getAccountList();
    }

}
