package com.yao.app.biz;

public class ServiceDelegate {

    private HelloInterface helloInterface;

    public ServiceDelegate(HelloInterface helloInterface) {
        this.helloInterface = helloInterface;
    }

    public void hello(){
        helloInterface.hello();
        System.out.println("hello XXX");
    }
}
