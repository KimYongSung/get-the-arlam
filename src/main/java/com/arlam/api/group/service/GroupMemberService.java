package com.arlam.api.group.service;

import com.arlam.api.group.dto.GroupDTO;
import com.arlam.app.result.Response;

public interface GroupMemberService {

    /**
     * Group 방 참여 여부 확인
     * @param memberNo
     * @param dto
     * @return
     */
    Response isJoin(Long memberNo, GroupDTO dto);

    /**
     * Group 방 참여
     * @param memberNo
     * @param dto
     * @return
     */
    Response joinGroup(Long memberNo, GroupDTO dto);

    /**
     * Group 방 나가기
     * @param memberNo
     * @param dto
     * @return
     */
    Response outGroup(Long memberNo, GroupDTO dto);
}
