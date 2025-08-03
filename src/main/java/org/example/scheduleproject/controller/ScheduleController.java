package org.example.scheduleproject.controller;

import lombok.RequiredArgsConstructor;
import org.example.scheduleproject.repository.ScheduleRepository;
import org.example.scheduleproject.scheduledto.CreateScheduleRequestDto;
import org.example.scheduleproject.scheduledto.ScheduleResponseDto;
import org.example.scheduleproject.service.ScheduleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    @GetMapping("/schedule")
    public ScheduleResponseDto createSchedule(
            @RequestBody CreateScheduleRequestDto createScheduleRequestDto
    ) {
        return scheduleService.createSchedule(createScheduleRequestDto);
    }
}
