package com.arlam.api.group.service;

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

}
