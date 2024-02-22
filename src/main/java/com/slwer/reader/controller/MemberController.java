package com.slwer.reader.controller;

import com.slwer.reader.entity.Evaluation;
import com.slwer.reader.entity.Member;
import com.slwer.reader.entity.MemberReadState;
import com.slwer.reader.service.EvaluationService;
import com.slwer.reader.service.MemberService;
import com.slwer.reader.utils.ResponseUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/member")
public class MemberController {
    @Resource
    private MemberService memberService;
    @Resource
    private EvaluationService evaluationService;

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
                e.printStackTrace();
                resp = new ResponseUtils(e.getClass().getSimpleName(), e.getMessage());
            }
        }
        return resp;
    }

    @PostMapping("/check_login")
    public ResponseUtils checkLogin(String username, String password, String vc, HttpServletRequest request) {
        String verifyCode = (String) request.getSession().getAttribute("kaptchaVerifyCode");
        ResponseUtils resp;
        if (verifyCode == null || !verifyCode.equalsIgnoreCase(vc)) {
            resp = new ResponseUtils("VerifyCodeError", "验证码错误");
        } else {
            //验证码校验通过后进行用户登录查询
            try {
                Member member = memberService.checkLogin(username, password);
                member.setPassword(null);
                member.setSalt(null);
                resp = new ResponseUtils().put("member", member);
            } catch (Exception e) {
                e.printStackTrace();
                resp = new ResponseUtils(e.getClass().getSimpleName(), e.getMessage());
            }
        }
        return resp;
    }

    @GetMapping("/select_by_id")
    public ResponseUtils selectById(Long memberId) {
        ResponseUtils resp = null;
        try {
            Member member = memberService.selectById(memberId);
            member.setPassword(null);
            member.setSalt(null);
            resp = new ResponseUtils().put("member", member);
        } catch (Exception e) {
            e.printStackTrace();
            resp = new ResponseUtils(e.getClass().getSimpleName(), e.getMessage());
        }
        return resp;
    }

    @GetMapping("/select_read_state")
    public ResponseUtils selectMemberReadState(Long memberId, Long bookId) {
        ResponseUtils resp = null;
        try {
            MemberReadState memberReadState = memberService.selectMemberReadState(memberId, bookId);
            resp = new ResponseUtils().put("readState", memberReadState);
        } catch (Exception e) {
            e.printStackTrace();
            resp = new ResponseUtils(e.getClass().getSimpleName(), e.getMessage());
        }
        return resp;
    }

    @PostMapping("/update_read_state")
    public ResponseUtils updateMemberReadState(Long memberId, Long bookId, Integer readState) {
        ResponseUtils resp = null;
        try {
            MemberReadState memberReadState = memberService.updateMemberReadState(memberId, bookId, readState);
            resp = new ResponseUtils().put("readState", memberReadState);
        } catch (Exception e) {
            e.printStackTrace();
            resp = new ResponseUtils(e.getClass().getSimpleName(), e.getMessage());
        }
        return resp;
    }

    @PostMapping("/evaluate")
    public ResponseUtils evaluate(Long memberId, Long bookId, Integer score, String content) {
        ResponseUtils resp = null;
        try {
            Evaluation evaluation = evaluationService.evaluate(memberId, bookId, score, content);
            resp = new ResponseUtils().put("evaluation", evaluation);
        } catch (Exception e) {
            e.printStackTrace();
            resp = new ResponseUtils(e.getClass().getSimpleName(), e.getMessage());
        }
        return resp;
    }

    @PostMapping("/enjoy")
    public ResponseUtils enjoy(Long evaluationId) {
        ResponseUtils resp = null;
        try {
            Evaluation evaluation = evaluationService.enjoy(evaluationId);
            resp = new ResponseUtils().put("evaluation", evaluation);
        } catch (Exception e) {
            e.printStackTrace();
            resp = new ResponseUtils(e.getClass().getSimpleName(), e.getMessage());
        }
        return resp;
    }
}
