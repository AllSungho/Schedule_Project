package org.example.scheduleproject.scheduledto;

import lombok.Getter;

// 일정 삭제 응답 Dto
@Getter
public class DeleteScheduleResponseDto {

    private final String password;

    public DeleteScheduleResponseDto(String password) {
        this.password = password;
    }
}
