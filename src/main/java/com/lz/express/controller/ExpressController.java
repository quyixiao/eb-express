package com.lz.express.controller;


import com.alibaba.fastjson.JSON;
import com.lz.express.entity.UserExpress;
import com.lz.express.service.UserExpressService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ExpressController {


    @Autowired
    private UserExpressService userExpressService;

    @RequestMapping("/test")
    public String test() {
        UserExpress userExpress = userExpressService.selectUserExpressById(1l);
        log.info("===========" + JSON.toJSONString(userExpress));
        return "tesxt";
    }

}
