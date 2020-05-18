package com.arlam.api.group.service;

import com.arlam.api.group.domain.GroupMember;
import com.arlam.api.group.domain.repository.GroupMemberRepository;
import com.arlam.api.group.domain.repository.GroupMemberRepositorySupport;
import com.arlam.api.group.domain.repository.GroupRepository;
import com.arlam.api.group.dto.GroupDTO;
import com.arlam.app.exception.detail.AlreadyJoinGroupException;
import com.arlam.app.exception.detail.GroupNotFoundException;
import com.arlam.app.exception.detail.NotJoinGroupException;
import com.arlam.app.result.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class GroupMemberServiceImpl implements GroupMemberService{

    private final GroupRepository groupRepository;

    private final GroupMemberRepository repository;

    private final GroupMemberRepositorySupport repositorySupport;

    @Override
    public Response isJoin(Long memberNo, GroupDTO dto) {

        long count = repositorySupport.selectGroupMemberCount(dto.getGroupId(), memberNo);

        return Response.success(count > 0l);
    }

    @Transactional
    @Override
    public Response joinGroup(Long memberNo, GroupDTO dto) {

        Optional<GroupMember> optional = repositorySupport.selectGroupMember(dto.getGroupId(), memberNo);

        if(optional.isPresent()){
            throw new AlreadyJoinGroupException();
        }

        if(!groupRepository.existsById(dto.getGroupId())){
            throw new GroupNotFoundException();
        }

        GroupMember groupMember = GroupMember.builder()
                                             .groupId(dto.getGroupId())
                                             .memNo(memberNo)
                                             .build();

        repository.save(groupMember);

        return Response.success();
    }

    @Transactional
    @Override
    public Response outGroup(Long memberNo, GroupDTO dto) {

        GroupMember groupMember = repositorySupport.selectGroupMember(dto.getGroupId(), memberNo)
                                                   .orElseThrow(NotJoinGroupException::new);

        repository.delete(groupMember);

        return Response.success();
    }
}
