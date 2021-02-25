package com.ibm.intern.covid19statsapp.controller;

import com.ibm.intern.covid19statsapp.data.entity.WeeklyStatisticBlock;
import com.ibm.intern.covid19statsapp.payload.response.CountriesResponse;
import com.ibm.intern.covid19statsapp.service.WeeklyStatisticBlockService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class WeeklyStatisticBlockController {
    private final WeeklyStatisticBlockService weeklyStatisticBlockService;

    @GetMapping("/countries")
    public ResponseEntity<List<CountriesResponse>> getAllCountries() {
        return ResponseEntity.ok(weeklyStatisticBlockService.getAllCountries());
    }

    @GetMapping("/stats/{country}")
    public ResponseEntity<List<WeeklyStatisticBlock>> getAllStatsForCountry(@PathVariable("country") String country) {
        return ResponseEntity.ok(weeklyStatisticBlockService.getAllStatsForCountry(country));
    }

    @GetMapping("/stats/deaths/{country}")
    public ResponseEntity<List<WeeklyStatisticBlock>> getAllStatsDeathsForCountry(@PathVariable("country") String country) {
        return ResponseEntity.ok(weeklyStatisticBlockService.getStatsDeathsForCountry(country));
    }

    @GetMapping("/stats/cases/{country}")
    public ResponseEntity<List<WeeklyStatisticBlock>> getAllStatsCasesForCountry(@PathVariable("country") String country) {
        return ResponseEntity.ok(weeklyStatisticBlockService.getStatsCasesForCountry(country));
    }

}
