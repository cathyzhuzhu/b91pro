package com.pulsar.domain;

import lombok.Data;

@Data
public class AreaDto {
    private Integer countryCode;//区号
    private String countryName;//国家名称
//    private Integer provinceCode;//省编号
//    private String provinceName;//省名称
//    private String countryPictureUrl;//国家图片链接
    private String alpha2;//国家简写
}
