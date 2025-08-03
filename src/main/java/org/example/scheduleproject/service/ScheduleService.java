package org.example.scheduleproject.service;

import lombok.RequiredArgsConstructor;
import org.example.scheduleproject.repository.ScheduleRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;


}
