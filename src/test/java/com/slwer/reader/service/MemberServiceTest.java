package com.slwer.reader.service;

import com.slwer.reader.entity.Member;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class MemberServiceTest {
    @Resource
    MemberService memberService;

    @Test
    public void createMember1() {
        Member member = memberService.createMember("imooc_1000", "123456", "慕粉-1");
        System.out.println(member);
    }

    @Test
    public void createMember2() {
        Member member = memberService.createMember("slwer", "123456", "慕粉-slwer");
        System.out.println(member);
    }
}