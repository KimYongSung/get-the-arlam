package com.arlam.api.group.domain;

import com.arlam.api.member.domain.Member;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.time.LocalDateTime;

@Table(name = "GROUP", uniqueConstraints = @UniqueConstraint(name = "PK_GROUP_01", columnNames = {""}))
@Entity
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "REG_SEQ")
    private Long regSeq;

    @Column(name = "GRP_ID")
    private String groupId;

    @Column(name = "GRP_NM")
    private String groupNm;

    @JoinColumn(name = "MEM_ID")
    private Member member;

    @Column(name = "GRP_CR_DT")
    private LocalDateTime grpCreateDt;
}
