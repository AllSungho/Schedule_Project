package org.example.scheduleproject.service;

import lombok.RequiredArgsConstructor;
import org.example.scheduleproject.entity.Schedule;
import org.example.scheduleproject.repository.ScheduleRepository;
import org.example.scheduleproject.scheduledto.CreateScheduleRequestDto;
import org.example.scheduleproject.scheduledto.ScheduleResponseDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    @Transactional
    public ScheduleResponseDto createSchedule(CreateScheduleRequestDto createScheduleRequestDto) {
        Schedule schedule = scheduleRepository.save(new Schedule(
                        createScheduleRequestDto.getTitle(),
                        createScheduleRequestDto.getContent(),
                        createScheduleRequestDto.getUserName(),
                        createScheduleRequestDto.getPassword()
                )
        );

        return new ScheduleResponseDto(schedule);
    }
}
