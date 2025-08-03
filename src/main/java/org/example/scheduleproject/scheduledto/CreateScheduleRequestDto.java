package org.example.scheduleproject.scheduledto;

import lombok.Getter;
import org.example.scheduleproject.entity.Schedule;

@Getter
public class CreateScheduleRequestDto {

    private String title;
    private String content;
    private String userName;
    private String password;
}
