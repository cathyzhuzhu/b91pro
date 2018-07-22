package com.pulsar.node.mapper;

import com.pulsar.node.domain.NodeDto;

import java.util.List;

public interface NodeMapper {
    int  addApplyNode(NodeDto nodeDto);
    int getNodeExists(NodeDto nodeDto);
    int addNode(NodeDto nodeDto);
    int updateNode(NodeDto nodeDto);
    List<NodeDto> getNodeList(NodeDto nodeDto);
}
