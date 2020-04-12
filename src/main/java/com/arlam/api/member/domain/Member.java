package com.arlam.api.member.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Table(name = "MEMBER")
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MEM_NO", unique = true)
    private Long memNO;

    @Column(name = "MEM_ID", nullable = false)
    private String memId;

    @Column(name = "MEM_PWD", nullable = false)
    private String memPwd;

    @Column(name = "MEM_REG_DT")
    private LocalDateTime memRegDt;

    @Column(name = "LOGIN_KEY")
    private String loginKey;

    @Column(name = "ANDROID_KEY")
    private String androidKey;

    @Column(name = "MEM_LVL")
    private String memLevel;

    @Column(name = "MEM_PNT")
    private Long memPoint;

    @Column(name = "MEM_LCK_DT")
    private LocalDateTime memLockDt;

    @Builder
    public Member(String memId, String memPwd, LocalDateTime memRegDt, String loginKey, String androidKey
            , String memLevel, Long memPoint, LocalDateTime memLockDt) {
        this.memId = memId;
        this.memPwd = memPwd;
        this.memRegDt = memRegDt;
        this.loginKey = loginKey;
        this.androidKey = androidKey;
        this.memLevel = memLevel;
        this.memPoint = memPoint;
        this.memLockDt = memLockDt;
    }
}
