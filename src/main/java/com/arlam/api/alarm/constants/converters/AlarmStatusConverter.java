package com.arlam.api.alarm.constants.converters;

import com.arlam.api.alarm.constants.AlarmStatus;

import javax.persistence.AttributeConverter;
import java.util.Objects;

public class AlarmStatusConverter implements AttributeConverter<AlarmStatus, Integer> {

    @Override
    public Integer convertToDatabaseColumn(AlarmStatus attribute) {
        return Objects.isNull(attribute) ? null : attribute.getCode();
    }

    @Override
    public AlarmStatus convertToEntityAttribute(Integer dbData) {
        return AlarmStatus.lookup(dbData);
    }
}
