package com.slwer.reader.service;

import com.slwer.reader.entity.Member;

public interface MemberService {
    Member createMember(String username, String password, String nickname);
}
