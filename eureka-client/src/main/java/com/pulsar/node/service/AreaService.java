package com.pulsar.node.service;

import com.pulsar.node.domain.AreaDto;

import java.util.List;

    /**
     * 地域信息服务层接口
     */
    public interface AreaService {
        /**
         * 查询国家列表
         * @return 返回国家列表信息
         */
        List<AreaDto> getCountryList();


}
