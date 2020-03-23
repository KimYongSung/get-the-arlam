package com.arlam.api.alarm.constants;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@Getter
@RequiredArgsConstructor
public enum AlarmStatus {

    REG(0),
    SEND(1),
    RESERVATION(2)
    ;

    private final Integer code;

    public boolean isEquals(Integer code){
        return this.code.equals(code);
    }

    public static AlarmStatus lookup(Integer code){
        return Arrays.stream(values())
                .filter(status -> status.isEquals(code))
                .findFirst()
                .orElseThrow(()-> new IllegalArgumentException("not defined AlarmStatus. " + code));
    }
}
