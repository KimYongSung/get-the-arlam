package com.arlam.api.alarm.constants.converters;

import com.arlam.api.alarm.constants.AlarmDay;

import javax.persistence.AttributeConverter;

public class AlarmDayConverter implements AttributeConverter<AlarmDay, Integer> {

    @Override
    public Integer convertToDatabaseColumn(AlarmDay attribute) {
        return attribute.getCode();
    }

    @Override
    public AlarmDay convertToEntityAttribute(Integer dbData) {
        return AlarmDay.lookup(dbData);
    }
}
