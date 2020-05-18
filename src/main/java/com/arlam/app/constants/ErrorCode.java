package com.arlam.app.constants;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * 에러코드 관리
 */
@Getter
@ToString
@RequiredArgsConstructor
public enum ErrorCode {

    CD_0000("0000","성공")
    , CD_S001("S001", "요청 파라미터가 유효하지 않습니다")
    , CD_S002("S002", "인증 정보가 잘못되었습니다.")
    , CD_S999("S999", "system error")
    , CD_1001("1001","고객정보를 찾을 수 없습니다.")
    , CD_1002("1002","이미 가입한 회원정보 입니다.")
    , CD_2000("2000","그룹방을 찾을 수 없습니다.")
    , CD_3001("3001","이미 참여한 그룹방 입니다.")
    , CD_3002("3002","참여하지 않은 그룹방 입니다.")
    ;

    private final String code;

    private final String message;

}