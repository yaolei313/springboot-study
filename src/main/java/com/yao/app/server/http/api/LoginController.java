package com.yao.app.server.http.api;

import com.yao.app.server.http.vo.LoginByPasswordReq;
import com.yao.app.server.http.vo.LoginRsp;
import com.yao.app.server.http.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yaolei313@gmail.com
 * @data 2022/9/29
 */
@RestController
@Slf4j
public class LoginController {

    @RequestMapping("/user/login_by_password")
    public ResponseVo<LoginRsp> loginByPassword(LoginByPasswordReq request) {
        LoginRsp rsp = new LoginRsp();
        rsp.setUserId(123L);
        return ResponseVo.create(200, rsp);
    }
}
