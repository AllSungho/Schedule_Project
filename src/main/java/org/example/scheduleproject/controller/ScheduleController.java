package org.example.scheduleproject.controller;

import lombok.RequiredArgsConstructor;
import org.example.scheduleproject.repository.ScheduleRepository;
import org.example.scheduleproject.service.ScheduleService;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;


}
