package com.slwer.reader.controller;

import com.slwer.reader.utils.ResponseUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/member")
public class MemberController {
    @PostMapping("/registe")
    public ResponseUtils registe(String username, String password, String nickname, String vc, HttpServletRequest request) {
        String verifyCode = (String) request.getSession().getAttribute("kaptchaVerifyCode");
        ResponseUtils resp;
        if (verifyCode == null || !verifyCode.equalsIgnoreCase(vc)) {
            resp = new ResponseUtils("VerifyCodeError", "验证码错误");
        } else {
            resp = new ResponseUtils();
        }
        return resp;
    }
}
