package com.pulsar.domain;

import lombok.Data;

import java.util.List;

@Data
public class NodeDto {
    private String id;
    private String nodeName;//节点名称
    private String alpha2;//国家简称
    private String provinceCode;//省代码
    private Integer userType;//类型 1-个人 2-团体 3-企业
    private String[] filedList;//领域
    private List<String> fileds;
    private String enterprise;//企业
    private String linkman;//联系人
    private String countryCode;//地区代码
    private String contactPhone;//联系电话
    private String email;//邮箱
    private String validateCode;//验证码
    private String nodeLeader;//节点负责人
    private String remark;//备注
    private String approveRemark;//审核备注
}
