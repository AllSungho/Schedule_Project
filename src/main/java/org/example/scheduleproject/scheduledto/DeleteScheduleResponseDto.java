package org.example.scheduleproject.scheduledto;

import lombok.Getter;
import org.example.scheduleproject.entity.Schedule;

@Getter
public class DeleteScheduleResponseDto {

    private final String password;

    public DeleteScheduleResponseDto(String password) {
        this.password = password;
    }
}
