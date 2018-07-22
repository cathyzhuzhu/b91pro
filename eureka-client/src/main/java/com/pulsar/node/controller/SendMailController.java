package com.pulsar.node.controller;


import com.pulsar.node.controller.BaseController;
import com.pulsar.node.domain.ResponseDto;
import com.pulsar.node.domain.SendMailDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.internet.MimeMessage;


@RestController
public class SendMailController extends BaseController {
    @Autowired
    private JavaMailSender sender;

    @Value("${mail.from}")
    private String from;

    @RequestMapping(value = "/sendMail" ,method = RequestMethod.POST)
    public ResponseDto sendMail(@RequestBody SendMailDto sendMailInDto) throws Exception {
        ResponseDto responseDto = new ResponseDto();
       try{

           MimeMessage mimeMsg = sender.createMimeMessage();
           MimeMessageHelper helper = new MimeMessageHelper(mimeMsg, true, "UTF-8");
//                   String from = sendMailInDto.setFrom(from);
                String to = sendMailInDto.getTo();
                String subject = sendMailInDto.getSubject();
                String text = sendMailInDto.getText();

           helper.setTo(to);
           helper.setFrom(from);
           helper.setSubject(subject);
           helper.setText(text);
           sender.send(mimeMsg);
          responseDto = responseUtils.getReturnMessage(0,"发送邮件成功");
       }catch(Exception e){
           e.printStackTrace();
          responseDto = responseUtils.getReturnMessage(-1,"E020001","发送邮件失败",e);
       }
        return responseDto;
    }
}
