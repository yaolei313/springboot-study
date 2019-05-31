package com.yao.app.system;

import com.yao.app.biz.HelloInterface;
import com.yao.app.biz.Service1;
import com.yao.app.biz.Service2;
import org.springframework.context.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.core.type.AnnotatedTypeMetadata;

@Configuration
public class Config1 {

    @Bean
    @Conditional({UseService1.class})
    public HelloInterface helloService1(){
        return new Service1();
    }

    @Bean
    @Conditional({UseService2.class})
    public HelloInterface helloService2(){
        return new Service2();
    }



    public static class UseService1 implements Condition{

        @Override
        public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
            String cfg = conditionContext.getEnvironment().getProperty("use1");
            return Boolean.getBoolean(cfg);
        }
    }

    public static class UseService2 implements Condition{

        @Override
        public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
            String cfg = conditionContext.getEnvironment().getProperty("use1");
            return !Boolean.getBoolean(cfg);
        }
    }
}
