package com.arlam.api.group.service;

import com.arlam.api.group.domain.Group;
import com.arlam.api.group.domain.GroupMember;
import com.arlam.api.group.domain.repository.GroupMemberRepository;
import com.arlam.api.group.domain.repository.GroupMemberRepositorySupport;
import com.arlam.api.group.dto.GroupDTO;
import com.arlam.app.exception.AlreadyJoinGroupException;
import com.arlam.app.result.Response;

import java.util.Optional;

public class GroupMemberServiceImpl implements GroupMemberService{

    private GroupMemberRepository repository;

    private GroupMemberRepositorySupport repositorySupport;

    @Override
    public Response isJoin(Long memberNo, GroupDTO dto) {

        long count = repositorySupport.selectGroupMemberCount(dto.getGroupId(), memberNo);

        return Response.success(count > 0l);
    }

    @Override
    public Response joinGroup(Long memberNo, GroupDTO dto) {

        Optional<GroupMember> optional = repositorySupport.selectGroupMember(dto.getGroupId(), memberNo);

        if(optional.isPresent()){
            throw new AlreadyJoinGroupException();
        }



        return null;
    }

    @Override
    public Response outGroup(Long memberNo, GroupDTO dto) {
        return null;
    }
}
