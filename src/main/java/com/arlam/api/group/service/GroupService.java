package com.arlam.api.group.service;

import com.arlam.api.group.dto.GroupDTO;
import com.arlam.app.result.Response;
import org.springframework.data.domain.Pageable;

public interface GroupService {

    /**
     * Group 방 목록 조회
     * @param pageable
     * @return
     */
    Response findGroups(Pageable pageable);

    /**
     * Group 방 이름으로 검색
     * @param keyword 검색 키워드
     * @return
     */
    Response searchGroupName(String keyword, Pageable pageable);

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
