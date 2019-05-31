package com.yao.app.protocol.http;

import com.yao.app.biz.ServiceDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private ServiceDelegate serviceDelegate;

    @RequestMapping("/")
    public String home() {
        serviceDelegate.hello();
        return "Hello World!";
    }
}