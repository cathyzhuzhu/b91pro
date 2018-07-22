package com.pulsar.node.service.impl;

import com.pulsar.node.domain.AreaDto;
import com.pulsar.node.mapper.AreaMapper;
import com.pulsar.node.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaServiceImpl implements AreaService {
    @Autowired
    private AreaMapper areaMapper;

    @Override
    public List<AreaDto> getCountryList() {
        return areaMapper.getCountryList();
    }

}
