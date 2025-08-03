package org.example.scheduleproject.service;

import lombok.RequiredArgsConstructor;
import org.example.scheduleproject.entity.Schedule;
import org.example.scheduleproject.repository.ScheduleRepository;
import org.example.scheduleproject.scheduledto.CreateScheduleRequestDto;
import org.example.scheduleproject.scheduledto.ScheduleResponseDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Transactional(readOnly = true)
    public List<ScheduleResponseDto> findSchedules() {
        List<Schedule> schedules =  scheduleRepository.findAll();
        return schedules.stream().map(ScheduleResponseDto::new).toList();
    }
    @Transactional(readOnly = true)
    public List<ScheduleResponseDto> findSchedules(String name) {
        List<Schedule> schedules =  scheduleRepository.findByName(name);
        return schedules.stream().map(ScheduleResponseDto::new).toList();
    }
}
