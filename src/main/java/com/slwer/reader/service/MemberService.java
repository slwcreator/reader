package com.slwer.reader.service;

import com.slwer.reader.entity.Member;
import com.slwer.reader.entity.MemberReadState;

public interface MemberService {
    Member createMember(String username, String password, String nickname);

    Member checkLogin(String username, String password);

    Member selectById(Long memberId);

    MemberReadState selectMemberReadState(Long memberId, Long bookId);
}
