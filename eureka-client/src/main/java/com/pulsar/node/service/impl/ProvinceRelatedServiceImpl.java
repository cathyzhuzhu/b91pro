package com.pulsar.node.service.impl;

import com.pulsar.node.domain.ProvinceRelatedDto;
import com.pulsar.node.mapper.ProvinceRelatedMapper;
import com.pulsar.node.service.ProvinceRelatedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProvinceRelatedServiceImpl implements ProvinceRelatedService {
    @Autowired
    private ProvinceRelatedMapper provinceRelatedMapper;
    @Override
    public List<ProvinceRelatedDto> getProvinceList(String alpha2) {
        return provinceRelatedMapper.getProvinceList(alpha2);
    }
}
