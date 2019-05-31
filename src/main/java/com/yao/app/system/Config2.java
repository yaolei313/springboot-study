package com.yao.app.system;

import com.yao.app.biz.HelloInterface;
import com.yao.app.biz.ServiceDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config2 {

    @Autowired
    private HelloInterface helloInterface;

    @Bean
    public ServiceDelegate createService2(){
        return new ServiceDelegate(helloInterface);
    }
}
