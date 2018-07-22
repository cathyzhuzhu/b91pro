package com.pulsar.node.service.impl;

import com.pulsar.node.domain.FieldRelatedDto;
import com.pulsar.node.domain.NodeDto;
import com.pulsar.node.mapper.FieldRelatedMapper;
import com.pulsar.node.mapper.NodeMapper;
import com.pulsar.node.service.NodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class NodeServiceImpl implements NodeService {

    @Autowired
    private NodeMapper nodeMapper;

    @Autowired
    private FieldRelatedMapper fieldRelatedMapper;

    @Transactional
    @Override
    public void addApplyNode(NodeDto nodeDto) {
            nodeMapper.addApplyNode(nodeDto);
            for (String filed:nodeDto.getFileds()){
                FieldRelatedDto frd = new FieldRelatedDto();
                frd.setFieldCode(filed);
                frd.setNodeCode(nodeDto.getId());
                fieldRelatedMapper.addFieldRelated(frd);
            }
    }

    @Override
    public int getNodeExists(NodeDto nodeDto) {
        return nodeMapper.getNodeExists(nodeDto);
    }

    @Override
    public int addNode(NodeDto nodeDto) {
        return nodeMapper.addNode(nodeDto);
    }

    @Override
    public int updateNode(NodeDto nodeDto) {
        return nodeMapper.updateNode(nodeDto);
    }

    @Override
    public List<NodeDto> getNodeList(NodeDto nodeDto) {
        return nodeMapper.getNodeList(nodeDto);
    }
}
