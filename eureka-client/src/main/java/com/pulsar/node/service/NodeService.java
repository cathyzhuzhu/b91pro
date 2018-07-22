package com.pulsar.node.service;

import com.pulsar.node.domain.NodeDto;

import java.util.List;

/**
 * 节点服务层接口
 */
public interface NodeService {
    /**
     * 节点申请
     * @param nodeDto 输入对象
     */
    void  addApplyNode(NodeDto nodeDto);

    /**
     * 判断节点是否存在
     * @param nodeDto 判断信息
     * @return 返回结果
     */
    int getNodeExists(NodeDto nodeDto);

    /**
     * 添加节点
     * @param nodeDto 输入对象
     * @return 返回结果
     */
    int addNode(NodeDto nodeDto);

    /**
     * 修改节点
     * @param nodeDto 输入对象
     * @return 返回结果
     */
    int updateNode(NodeDto nodeDto);

    /**
     * 获取节点列表
     * @param nodeDto 输入对象
     * @return  返回节点列表
     */
    List<NodeDto> getNodeList(NodeDto nodeDto);


}
