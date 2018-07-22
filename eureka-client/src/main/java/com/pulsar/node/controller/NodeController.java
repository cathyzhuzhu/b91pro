package com.pulsar.node.controller;

import com.pulsar.node.domain.NodeDto;
import com.pulsar.node.domain.ResponseDto;
import com.pulsar.node.service.NodeService;
import com.pulsar.redis.RedisClient;
import com.pulsar.utils.VerifyCodeUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.*;

import javax.mail.internet.MimeMessage;
import java.util.Arrays;
import java.util.List;

/**
 * @author huangjuan
 * @create 2018/7/16
 */
@RestController
public class NodeController extends BaseController{
    @Autowired
    private NodeService nodeService;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private RedisClient redisClient;

    @Autowired
    private VerifyCodeUtils verifyCode;


    @Autowired
    private JavaMailSender sender;

    @Value("${mail.from}")
    private String from;

    @Value("${mail.subject}")
    private String subject;


    @PostMapping("/addApplyNode")
    public ResponseDto addApplyNode(@RequestBody NodeDto nodeDto){
        ResponseDto responseDto = new ResponseDto();
        try{
            List fileds = Arrays.asList(nodeDto.getFiledList());
            nodeDto.setFileds(fileds);
            String nodeName = nodeDto.getNodeName();
            String email = nodeDto.getEmail().trim();
            String validateCode = nodeDto.getValidateCode();
            if(!StringUtils.isEmpty(nodeName)){//判断节点名称不为空
                return responseUtils.getReturnMessage(-1,"B010001","节点名称不为空");
            }
            if(nodeService.getNodeExists(nodeDto)>0){//判断节点名称不能重复
                return responseUtils.getReturnMessage(-1,"B010002","节点名称已存在");
            }
            if(!redisClient.getKeyExists(email)){
                return responseUtils.getReturnMessage(-1,"B010003","邮件发送验证码不存在或过期");
            }
            //邮件验证码验证失败
            if(validateCode.equals(redisClient.getKeyValue(email))){
                return responseUtils.getReturnMessage(-1,"B010004","输入验证码错误");
            }
            nodeService.addApplyNode(nodeDto);
            responseDto = responseUtils.getReturnMessage(0,"节点申请成功");
        }catch (Exception e){
            e.printStackTrace();;
            responseDto = responseUtils.getReturnMessage(-1,"E010001","节点申请失败",e);
        }
             return responseDto;
    }

    @PostMapping("/addNode")
    public ResponseDto addNode(@RequestBody NodeDto nodeDto){
        ResponseDto responseDto = new ResponseDto();
        try{
            nodeService.addNode(nodeDto);
            responseDto = responseUtils.getReturnMessage(0,"节点新增成功");
        }catch (Exception e){
            responseDto = responseUtils.getReturnMessage(-1,"E010002","节点新增失败",e);
        }
        return responseDto;
    }

    @PostMapping("/updateNode")
    public ResponseDto updateNode(@RequestBody NodeDto nodeDto){
        ResponseDto responseDto = new ResponseDto();
        try{
            nodeService.updateNode(nodeDto);
            responseDto = responseUtils.getReturnMessage(0,"节点更新成功");
        }catch (Exception e){
            responseDto = responseUtils.getReturnMessage(-1,"E010003","节点更新失败",e);
        }
        return responseDto;
    }

    @GetMapping("/getNodeList")
    public ResponseDto getNodeList(NodeDto nodeDto){
        ResponseDto responseDto = new ResponseDto();
        try{
            List<NodeDto> nodes =  nodeService.getNodeList(nodeDto);
            responseUtils.getReturnMessage(0,"获取节点列表成功",nodes);
        }catch(Exception e){
            responseDto = responseUtils.getReturnMessage(-1,"E010004","获取节点列表失败",e);
        }
        return responseDto;
    }

    @PostMapping("/sendValidateCode")
    public ResponseDto sendValidateCode(@RequestParam("email") String email){
        ResponseDto responseDto = new ResponseDto();
        String validateCode = verifyCode.generateVerifyCode(6);
        try{
            redisClient.setKeyValue(email,validateCode,120);
            MimeMessage mimeMsg = sender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMsg, true, "UTF-8");
            helper.setTo(email);
            helper.setFrom(from);
            helper.setSubject(subject);
            helper.setText(validateCode);
            sender.send(mimeMsg);
            responseDto = responseUtils.getReturnMessage(0,"发送验证码成功",validateCode);

        }catch(Exception e){
            responseDto = responseUtils.getReturnMessage(-1,"E010005","发送验证码失败",e);
        }
        return responseDto;
    }

    public static void  main(String []args){
        System.out.println("1111");
    }

}
