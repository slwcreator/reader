package com.slwer.reader.controller;

import com.slwer.reader.entity.Member;
import com.slwer.reader.service.MemberService;
import com.slwer.reader.utils.ResponseUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/member")
public class MemberController {
    @Resource
    MemberService memberService;

    @PostMapping("/registe")
    public ResponseUtils registe(String username, String password, String nickname, String vc, HttpServletRequest request) {
        String verifyCode = (String) request.getSession().getAttribute("kaptchaVerifyCode");
        ResponseUtils resp;
        if (verifyCode == null || !verifyCode.equalsIgnoreCase(vc)) {
            resp = new ResponseUtils("VerifyCodeError", "验证码错误");
        } else {
            //验证码校验通过后进行用户注册
            try {
                Member member = memberService.createMember(username, password, nickname);
                resp = new ResponseUtils();
            } catch (Exception e) {
                resp = new ResponseUtils(e.getClass().getSimpleName(), e.getMessage());
            }
        }
        return resp;
    }
}
