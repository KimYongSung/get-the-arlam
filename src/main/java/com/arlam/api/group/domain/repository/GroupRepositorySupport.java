package com.arlam.api.group.domain.repository;

import com.arlam.api.group.domain.Group;
import com.arlam.api.group.domain.QGroup;
import com.querydsl.core.QueryResults;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import static com.arlam.api.group.domain.QGroup.group;

/**
 * Group 레파지토리 지원
 */
@Repository
public class GroupRepositorySupport extends QuerydslRepositorySupport {

    private final JPAQueryFactory queryFactory;

    public GroupRepositorySupport(JPAQueryFactory queryFactory) {
        super(Group.class);
        this.queryFactory = queryFactory;
    }

    /**
     * 그룹 이름으로 like 조회
     * @param grpNm
     * @param pageable
     * @return
     */
    public QueryResults<Group> findByGrpNm(String grpNm, Pageable pageable){

        JPAQuery<Group> query = queryFactory.selectFrom(group)
                                            .where(group.groupNm.contains(grpNm))
                                            ;

        return getQuerydsl().applyPagination(pageable, query).fetchResults();
    }

    public Optional<Group> findByIdAndMemberNo(Long groupId, Long memberNo){

        Group group = queryFactory.selectFrom(QGroup.group)
                .where(QGroup.group.groupId.eq(groupId)
                .and(QGroup.group.member.memNo.eq(memberNo)))
                .fetchOne();

        return Optional.of(group);
    }
}
