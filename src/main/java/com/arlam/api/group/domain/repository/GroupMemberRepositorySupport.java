package com.arlam.api.group.domain.repository;

import com.arlam.api.group.domain.GroupMember;
import com.arlam.api.group.domain.QGroupMember;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.Optional;

import static com.arlam.api.group.domain.QGroupMember.groupMember;

public class GroupMemberRepositorySupport extends QuerydslRepositorySupport {

    private final JPAQueryFactory queryFactory;

    public GroupMemberRepositorySupport(JPAQueryFactory queryFactory) {
        super(GroupMember.class);
        this.queryFactory = queryFactory;
    }

    public long selectGroupMemberCount(Long groupId, Long memberNo){
        return queryFactory.selectFrom(groupMember)
                           .where(groupMember.groupId.eq(groupId)
                           .and(groupMember.memNo.eq(memberNo)))
                           .fetchCount();
    }

    public Optional<GroupMember> selectGroupMember(Long groupId, Long memberNo){
        GroupMember groupMember = queryFactory.selectFrom(QGroupMember.groupMember)
                .where(QGroupMember.groupMember.groupId.eq(groupId)
                .and(QGroupMember.groupMember.memNo.eq(memberNo)))
                .fetchOne();

        return Optional.of(groupMember);
    }
}
