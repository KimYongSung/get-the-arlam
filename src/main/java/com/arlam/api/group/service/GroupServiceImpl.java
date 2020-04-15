package com.arlam.api.group.service;

import com.arlam.api.group.domain.Group;
import com.arlam.api.group.domain.repository.GroupRepository;
import com.arlam.api.group.domain.repository.GroupRepositorySupport;
import com.arlam.api.group.dto.GroupDTO;
import com.arlam.api.group.mapper.GroupMapper;
import com.arlam.app.result.Response;
import com.querydsl.core.QueryResults;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService{

    private final GroupRepository repository;

    private final GroupRepositorySupport repositorySupport;

    private final GroupMapper mapper;

    @Override
    public Response findGroups(Pageable pageable) {

        Page<Group> groups = repository.findAll(pageable);

        if(groups.isEmpty()){
            return Response.emptyPage(pageable);
        }

        Page<GroupDTO> dtos = groups.map((entity) -> {
            return mapper.toDto(entity);
        });

        return Response.success(dtos, pageable);
    }

    @Override
    public Response searchGroupName(String keyword, Pageable pageable) {

        QueryResults<Group> results = repositorySupport.findByGrpNmLike(keyword, pageable);

        return Response.success(results, pageable);
    }

    @Override
    public Response isJoin(Long memberNo, GroupDTO dto) {

        Optional<Group> optional = repositorySupport.findByIdAndMemberNo(dto.getGroupId(), memberNo);

        return Response.success(optional.isPresent());
    }

    @Override
    public Response joinGroup(Long memberNo, GroupDTO dto) {

        Optional<Group> optional = repositorySupport.findByIdAndMemberNo(dto.getGroupId(), memberNo);

        if(optional.isPresent()){
            // 예외처리
        }



        return null;
    }

    @Override
    public Response outGroup(Long memberNo, GroupDTO dto) {
        return null;
    }
}
