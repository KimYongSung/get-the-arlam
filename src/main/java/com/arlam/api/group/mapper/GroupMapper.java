package com.arlam.api.group.mapper;

import com.arlam.api.group.domain.Group;
import com.arlam.api.group.dto.GroupDTO;
import com.arlam.app.mapper.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface GroupMapper extends EntityMapper<Group, GroupDTO> {
}
