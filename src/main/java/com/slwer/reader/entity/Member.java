package com.slwer.reader.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.util.Date;

public class Member {
    @TableId(type = IdType.AUTO)
    private Long memberId;
    private String username;
    private String password;
    private Integer salt;
    private Date createTime;
    private String nickname;

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getSalt() {
        return salt;
    }

    public void setSalt(Integer salt) {
        this.salt = salt;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberId=" + memberId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", salt=" + salt +
                ", createTime=" + createTime +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
