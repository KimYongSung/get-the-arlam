package com.arlam.api.group.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@ToString
@Getter
@Setter
public class GroupDTO {

    private Long groupId;

    private String groupNm;

    private LocalDateTime grpCreateDt;
}
