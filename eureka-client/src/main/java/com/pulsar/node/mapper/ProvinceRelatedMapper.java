package com.pulsar.node.mapper;

import com.pulsar.node.domain.ProvinceRelatedDto;

import java.util.List;

public interface ProvinceRelatedMapper {
    /**
     * 根据国家编号查询省列表信息
     * @param alpha2 国家简称
     * @return 返回省列表信息
     */
    List<ProvinceRelatedDto> getProvinceList(String alpha2);
}
