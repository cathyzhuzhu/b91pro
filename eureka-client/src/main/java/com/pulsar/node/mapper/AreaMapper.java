package com.pulsar.node.mapper;

import com.pulsar.node.domain.AreaDto;

import java.util.List;

public interface AreaMapper {
    /**
     * 查询国家列表
     * @return 返回国家列表信息
     */
    List<AreaDto> getCountryList();


}
