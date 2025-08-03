package org.example.scheduleproject.service;

import lombok.RequiredArgsConstructor;
import org.example.scheduleproject.entity.Schedule;
import org.example.scheduleproject.repository.ScheduleRepository;
import org.example.scheduleproject.scheduledto.*;
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
        List<Schedule> schedules =  scheduleRepository.findAllByOrderByModifiedAtDesc();
        return schedules.stream().map(ScheduleResponseDto::new).toList();
    }
    @Transactional(readOnly = true)
    public List<ScheduleResponseDto> findSchedules(String name) {
        List<Schedule> schedules =  scheduleRepository.findScheduleByUserNameOrderByModifiedAtDesc(name);
        return schedules.stream().map(ScheduleResponseDto::new).toList();
    }

    @Transactional
    public ScheduleResponseDto updateTitle(Long id, UpdateTitleRequestDto updateTitleRequestDto) {
        Schedule schedule = scheduleRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 id")
        );
        schedule.changeTitle(updateTitleRequestDto.getTitle());
        scheduleRepository.saveAndFlush(schedule);
        return new ScheduleResponseDto(schedule);
    }
    @Transactional
    public ScheduleResponseDto updateName(Long id, UpdateNameRequestDto updateNameRequestDto) {
        Schedule schedule = scheduleRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 id")
        );
        schedule.changeTitle(updateNameRequestDto.getName());
        scheduleRepository.saveAndFlush(schedule);
        return new ScheduleResponseDto(schedule);
    }

    @Transactional
    public DeleteScheduleResponseDto deleteSchedule(Long id) {
        Schedule schedule = scheduleRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 id")
        );
        String password = schedule.getPassword();
        scheduleRepository.delete(schedule);
        return new DeleteScheduleResponseDto(password);
    }
}
