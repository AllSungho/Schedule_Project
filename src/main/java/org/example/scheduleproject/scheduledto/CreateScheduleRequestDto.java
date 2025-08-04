package org.example.scheduleproject.scheduledto;

import lombok.Getter;

// 일정 생성 요청 Dto
@Getter
public class CreateScheduleRequestDto {

    private String title;
    private String content;
    private String userName;
    private String password;
}
