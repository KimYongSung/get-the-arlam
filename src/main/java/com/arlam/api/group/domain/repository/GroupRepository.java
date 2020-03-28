package com.arlam.api.group.domain.repository;

import com.arlam.api.group.domain.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group, Long> {
}
