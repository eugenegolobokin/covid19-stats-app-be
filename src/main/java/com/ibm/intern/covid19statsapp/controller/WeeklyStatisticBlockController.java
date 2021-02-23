package com.ibm.intern.covid19statsapp.controller;

import com.ibm.intern.covid19statsapp.data.entity.WeeklyStatisticBlock;
import com.ibm.intern.covid19statsapp.service.WeeklyStatisticBlockService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class WeeklyStatisticBlockController {
    private final WeeklyStatisticBlockService weeklyStatisticBlockService;

    @GetMapping("/stats")
    public ResponseEntity<List<WeeklyStatisticBlock>> getAllStatistics() {
        return ResponseEntity.ok(weeklyStatisticBlockService.getAllStatistics());
    }
}
