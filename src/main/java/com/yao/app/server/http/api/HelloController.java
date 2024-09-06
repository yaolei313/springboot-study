package com.yao.app.server.http.api;

import com.yao.app.biz.ServiceDelegate;
import com.yao.app.server.http.vo.LoginByPasswordReq;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HelloController {

    @Autowired
    private ServiceDelegate serviceDelegate;

    @RequestMapping("/")
    public String home() {
        serviceDelegate.hello();
        return "Hello World!";
    }

    @RequestMapping("/test1")
    public String test1(@RequestParam("userId") long userId) {
        log.info("input {}", userId);
        return "ok";
    }
}