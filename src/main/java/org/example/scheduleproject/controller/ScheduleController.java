package org.example.scheduleproject.controller;

import lombok.RequiredArgsConstructor;
import org.example.scheduleproject.scheduledto.*;
import org.example.scheduleproject.service.ScheduleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping("/schedules")
    public ScheduleResponseDto createSchedule(
            @RequestBody CreateScheduleRequestDto createScheduleRequestDto
    ) {
        return scheduleService.createSchedule(createScheduleRequestDto);
    }

    @GetMapping("/schedules")
    public List<ScheduleResponseDto> findSchedules(
            @RequestParam(name = "name", required = false) String name
    ) {
        if( name == null ) {
            return this.scheduleService.findSchedules();
        }
        else {
            return this.scheduleService.findSchedules(name);
        }
    }

    @PatchMapping("/schedules/{scheduleId}/titles")
    public ScheduleResponseDto updateTitle(
            @PathVariable Long scheduleId,
            @RequestBody UpdateTitleRequestDto updateTitleRequestDto
    ) {
        return this.scheduleService.updateTitle(scheduleId, updateTitleRequestDto);
    }
    @PatchMapping("/schedules/{scheduleId}/names")
    public ScheduleResponseDto updateName(
            @PathVariable Long scheduleId,
            @RequestBody UpdateNameRequestDto updateNameRequestDto
    ) {
        return this.scheduleService.updateName(scheduleId, updateNameRequestDto);
    }

    @DeleteMapping("/schedules/{scheduleId}")
    public DeleteScheduleResponseDto deleteSchedule(
            @PathVariable Long scheduleId
    ) {
        return this.scheduleService.deleteSchedule(scheduleId);
    }
}
