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

    // 일정 생성
    @PostMapping("/schedules")
    public ScheduleResponseDto createSchedule(
            @RequestBody CreateScheduleRequestDto createScheduleRequestDto
    ) {
        return scheduleService.createSchedule(createScheduleRequestDto);
    }

    // 일정 전체 조회 또는 단일 조회
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

    // 제목 수정
    @PatchMapping("/schedules/{scheduleId}/titles")
    public ScheduleResponseDto updateTitle(
            @PathVariable Long scheduleId,
            @RequestBody UpdateTitleRequestDto updateTitleRequestDto
    ) {
        return this.scheduleService.updateTitle(scheduleId, updateTitleRequestDto);
    }
    // 이름 수정
    @PatchMapping("/schedules/{scheduleId}/names")
    public ScheduleResponseDto updateName(
            @PathVariable Long scheduleId,
            @RequestBody UpdateNameRequestDto updateNameRequestDto
    ) {
        return this.scheduleService.updateName(scheduleId, updateNameRequestDto);
    }

    // 일정 삭제
    @DeleteMapping("/schedules/{scheduleId}")
    public DeleteScheduleResponseDto deleteSchedule(
            @PathVariable Long scheduleId
    ) {
        return this.scheduleService.deleteSchedule(scheduleId);
    }
}
