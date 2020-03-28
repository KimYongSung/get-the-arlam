package com.arlam.api.group.domain;

import com.arlam.api.member.domain.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Table(name = "GROUP", uniqueConstraints = @UniqueConstraint(name = "PK_GROUP_01", columnNames = {"GRP_ID", "MEM_ID"}))
@Entity
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "REG_SEQ", nullable = false)
    private Long id;

    @Column(name = "GRP_ID", nullable = false)
    private String groupId;

    @Column(name = "GRP_NM", nullable = false)
    private String groupNm;

    @ManyToOne
    @JoinColumn(name = "MEM_ID", nullable = false)
    private Member member;

    @Column(name = "GRP_CR_DT")
    private LocalDateTime grpCreateDt;

    @Builder
    public Group(String groupId, String groupNm, Member member, LocalDateTime grpCreateDt) {
        this.groupId = groupId;
        this.groupNm = groupNm;
        this.member = member;
        this.grpCreateDt = grpCreateDt;
    }
}
