package com.arlam.api.alarm.domain;

import com.arlam.api.alarm.constants.AlarmDay;
import com.arlam.api.alarm.constants.AlarmStatus;
import com.arlam.api.alarm.constants.converters.AlarmDayConverter;
import com.arlam.api.alarm.constants.converters.AlarmStatusConverter;
import com.arlam.api.group.domain.Group;
import com.arlam.api.member.domain.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Table(name = "ALARM", uniqueConstraints = @UniqueConstraint(name = "PK_ALARM_01", columnNames = {"GRP_ID", "MEM_ID"}))
@Entity
public class Alarm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ALM_SEQ", nullable = false)
    private Long id;

    @Column(name = "ALM_ID" , nullable = false)
    private String alarmId;

    @ManyToOne
    @JoinColumn(name = "MEM_NO", nullable = false)
    private Member member;

    @Column(name = "ALM_REG_DT")
    private LocalDateTime regDt;

    @Column(name = "ALM_SND_DT")
    private LocalDateTime sendDt;

    @Convert(converter = AlarmStatusConverter.class)
    @Column(name = "ALM_STAT")
    private AlarmStatus status;

    @Column(name = "ALM_TIT")
    private String title;

    @Column(name = "ALM_TXT")
    private String text;

    @OneToOne
    @JoinColumn(name = "GRP_ID", nullable = false)
    private Group group;

    @Convert(converter = AlarmDayConverter.class)
    @Column(name = "DAY", nullable = false)
    private AlarmDay day;

    @Builder
    public Alarm(String alarmId, Member member, LocalDateTime regDt, LocalDateTime sendDt
            , AlarmStatus status, String title, String text, Group group, AlarmDay day) {
        this.alarmId = alarmId;
        this.member = member;
        this.regDt = regDt;
        this.sendDt = sendDt;
        this.status = status;
        this.title = title;
        this.text = text;
        this.group = group;
        this.day = day;
    }
}
