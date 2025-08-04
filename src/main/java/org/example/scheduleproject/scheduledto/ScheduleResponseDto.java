package org.example.scheduleproject.scheduledto;

import lombok.Getter;
import org.example.scheduleproject.entity.Schedule;

import java.time.LocalDateTime;

// 일정 응답 Dto
@Getter
public class ScheduleResponseDto {

    private final Long id;
    private final String title;
    private final String content;
    private final String userName;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;

    public ScheduleResponseDto(Schedule schedule) {

        this.id = schedule.getId();
        this.title = schedule.getTitle();
        this.content = schedule.getContent();
        this.userName = schedule.getUserName();
        this.createdAt = schedule.getCreatedAt();
        this.updatedAt = schedule.getModifiedAt();
    }
}
