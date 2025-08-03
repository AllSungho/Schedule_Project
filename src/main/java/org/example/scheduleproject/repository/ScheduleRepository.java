package org.example.scheduleproject.repository;

import org.example.scheduleproject.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    List<Schedule> findScheduleByUserNameOrderByModifiedAtDesc(String userName);

    List<Schedule> findAllByOrderByModifiedAtDesc();
}
