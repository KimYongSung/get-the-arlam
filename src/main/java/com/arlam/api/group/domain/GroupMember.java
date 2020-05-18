package com.arlam.api.group.domain;

import lombok.AllArgsConstructor;
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

@Getter
@NoArgsConstructor
@Table(name = "GROUP_MEMBER", uniqueConstraints = {@UniqueConstraint(name = "PK_GROUP_MEMBER_01",columnNames = {"GRP_ID", "MEM_NO"})})
@Entity
public class GroupMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "GROUP_MEMBER_ID")
    private Long id;

    @Column(name = "GRP_ID")
    private Long groupId;

    @Column(name = "MEM_NO")
    private Long memNo;

    @Builder
    private GroupMember(Long groupId, Long memNo) {
        this.groupId = groupId;
        this.memNo = memNo;
    }
}
