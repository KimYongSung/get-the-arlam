package com.arlam.api.group.service;

import com.arlam.api.group.domain.Group;
import com.arlam.api.group.domain.repository.GroupMemberRepositorySupport;
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

        Page<GroupDTO> dtos = groups.map(mapper::toDto);

        return Response.success(dtos, pageable);
    }

    @Override
    public Response searchGroupName(String keyword, Pageable pageable) {

        QueryResults<Group> results = repositorySupport.findByGrpNm(keyword, pageable);

        return Response.success(results, pageable);
    }

}
