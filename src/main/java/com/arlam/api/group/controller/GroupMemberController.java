package com.arlam.api.group.controller;

import com.arlam.api.group.dto.GroupDTO;
import com.arlam.api.group.service.GroupMemberService;
import com.arlam.app.result.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class GroupMemberController {

    private final GroupMemberService service;

    /**
     * Group 방 참여 여부 확인
     * @param memberNo
     * @param dto 요청 파라미터
     * @return
     */
    @GetMapping(value = "/group/isJoin/{memberNo}")
    public ResponseEntity<Response> isJoin(@PathVariable Long memberNo, GroupDTO dto){

        Response response = service.isJoin(memberNo, dto);

        return ResponseEntity.ok(response);
    }

    /**
     * Group 참여
     * @param memberNo 고객번호
     * @param dto 요청 파라미터
     * @return
     */
    @PostMapping(value = "/group/join/{memberNo}")
    public ResponseEntity<Response> joinGroup(@PathVariable Long memberNo, GroupDTO dto){

        Response response = service.joinGroup(memberNo, dto);

        return ResponseEntity.ok(response);
    }

    /**
     * Group 나가기
     * @param memberNo 고객번호
     * @param dto 요청 파라미터
     * @return
     */
    @PostMapping(value = "/group/out/{memberNo}")
    public ResponseEntity<Response> outGroup(@PathVariable Long memberNo, GroupDTO dto){

        Response response = service.outGroup(memberNo, dto);

        return ResponseEntity.ok(response);
    }
}
