package com.arlam.api.group.controller;

import com.arlam.api.group.dto.GroupDTO;
import com.arlam.api.group.service.GroupService;
import com.arlam.app.result.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 그룹 관련 처리
 */
@RestController
@RequiredArgsConstructor
public class GroupController {

    private final GroupService service;

    /**
     * Group 방 목록 조회
     * @param pageable 페이징 처리 용
     * @return
     */
    @GetMapping(value = "/groups")
    public ResponseEntity<Response> findGroups(Pageable pageable){

        Response response = service.findGroups(pageable);

        return ResponseEntity.ok(response);
    }

    /**
     * Group 방 제목 검색
     * @param keyword 방 검색 키워드
     * @return
     */
    @GetMapping(value = "/group/{keyword}")
    public ResponseEntity<Response> searchGroupName(@PathVariable String keyword, Pageable pageable){

        Response response = service.searchGroupName(keyword, pageable);

        return ResponseEntity.ok(response);
    }

}
