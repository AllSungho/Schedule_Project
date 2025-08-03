package org.example.scheduleproject.controller;

import lombok.RequiredArgsConstructor;
import org.example.scheduleproject.repository.ScheduleRepository;
import org.example.scheduleproject.scheduledto.CreateScheduleRequestDto;
import org.example.scheduleproject.scheduledto.ScheduleResponseDto;
import org.example.scheduleproject.service.ScheduleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping("/schedule")
    public ScheduleResponseDto createSchedule(
            @RequestBody CreateScheduleRequestDto createScheduleRequestDto
    ) {
        return scheduleService.createSchedule(createScheduleRequestDto);
    }

    @GetMapping("/schedule")
    public List<ScheduleResponseDto> findSchedules(
            @RequestParam(name = "name", required = true) String name
    ) {
        if( name == null ) {
            return this.scheduleService.findSchedules();
        }
        else {
            return this.scheduleService.findSchedules(name);
        }
    }
}
