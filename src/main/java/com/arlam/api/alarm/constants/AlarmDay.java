package com.arlam.api.alarm.constants;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@Getter
@RequiredArgsConstructor
public enum AlarmDay {

    SUNDAY(1)
    , MONDAY(2)
    , TUESDAY(3)
    , WEDESDAY(4)
    , THURSDAY(5)
    , FRIDAY(6)
    , SATURDAY(7)
    ;

    private final Integer code;

    public boolean isEquals(Integer code){
        return this.code.equals(code);
    }

    public static AlarmDay lookup(Integer code){
        return Arrays.stream(values())
                    .filter(alarmDay -> alarmDay.isEquals(code))
                    .findFirst()
                    .orElseThrow(()-> new IllegalArgumentException("not defined AlarmDay. " + code));
    }
}
