package com.arlam.api.alarm.domain.repository;

import com.arlam.api.alarm.domain.Alarm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlarmRepository extends JpaRepository<Long, Alarm> {
}
