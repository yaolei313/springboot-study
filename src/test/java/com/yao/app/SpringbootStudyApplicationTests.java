package com.yao.app;

import com.yao.app.biz.ServiceDelegate;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class SpringbootStudyApplicationTests {

    @Autowired
    private ServiceDelegate serviceDelegate;

    @Test
    public void contextLoads() {
    }

    @Test
    public void test1(){
        serviceDelegate.hello();
    }
}
