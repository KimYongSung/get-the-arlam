package com.arlam.api.alarm.domain.repository;

import com.arlam.api.alarm.constants.AlarmDay;
import com.arlam.api.alarm.constants.AlarmStatus;
import com.arlam.api.alarm.domain.Alarm;
import com.arlam.api.group.domain.Group;
import com.arlam.api.member.domain.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class AlarmRepositoryTest {

    @Autowired
    private AlarmRepository repository;

    @Test
    @DisplayName("id로 Alarm 조회 테스트")
    public void id_조회테스트(){

        // given
        Member member = givenTestMember();
        Group group = givenTestGroup(member);
        Alarm alarm = givenTestAlarm(member, group);

        repository.save(alarm);

        // when
        Optional<Alarm> optionalAlarm = repository.findById(alarm.getId());

        // then
        assertThat(optionalAlarm.isPresent()).isTrue();



    }

    private Alarm givenTestAlarm(Member member, Group group) {
        return Alarm.builder()
                          .alarmId("test_alarm")
                          .member(member)
                          .regDt(LocalDateTime.now())
                          .group(group)
                          .day(AlarmDay.SUNDAY)
                          .status(AlarmStatus.REG)
                          .title("alarm 타이틀")
                          .text("alarm 보내기 테스트")
                          .build();
    }

    private Group givenTestGroup(Member member) {
        return Group.builder()
                    .groupId("test_groupid")
                    .grpCreateDt(LocalDateTime.now())
                    .member(member)
                    .build();
    }

    private Member givenTestMember() {
        return Member.builder()
                     .memNo(1l)
                     .memId("test_mem")
                     .memPwd("test_pwd")
                     .memRegDt(LocalDateTime.now())
                     .build();
    }
}
