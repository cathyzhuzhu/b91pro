package com.pulsar.node.service;

import com.pulsar.node.domain.ProvinceRelatedDto;

import java.util.List;

public interface ProvinceRelatedService {
     List<ProvinceRelatedDto> getProvinceList(String alpha2);
}
