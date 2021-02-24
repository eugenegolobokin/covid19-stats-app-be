package com.ibm.intern.covid19statsapp.service;

import com.ibm.intern.covid19statsapp.data.entity.EIndicator;
import com.ibm.intern.covid19statsapp.data.entity.WeeklyStatisticBlock;
import com.ibm.intern.covid19statsapp.data.repo.WeeklyStatisticBlockRepo;
import com.ibm.intern.covid19statsapp.payload.response.CountriesResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class WeeklyStatisticBlockService {
    private final WeeklyStatisticBlockRepo weeklyStatisticBlockRepo;

    public void saveStatisticsList(List<WeeklyStatisticBlock> statistics) {
        log.info("Saving all statistics to DB.");
        weeklyStatisticBlockRepo.saveAll(statistics);
    }

    public List<WeeklyStatisticBlock> getAllStatistics() {
        log.info("Retrieving all statistics data");
        return weeklyStatisticBlockRepo.findAll();
    }

    public List<CountriesResponse> getAllCountries() {
        log.info("Retrieving all countries from the list");
        return weeklyStatisticBlockRepo.findDistinctBy();
    }

    public List<WeeklyStatisticBlock> getAllStatsForCountry(String country) {
        log.info("Retrieving statistical data for {}", country);
        return weeklyStatisticBlockRepo.findByCountry(country);
    }

    public List<WeeklyStatisticBlock> getStatsDeathsForCountry(String country) {
        log.info("Retrieving statistical data of deaths for {}", country);
        return weeklyStatisticBlockRepo.findByCountryAndIndicator(country, EIndicator.DEATHS);
    }

    public List<WeeklyStatisticBlock> getStatsCasesForCountry(String country) {
        log.info("Retrieving statistical data of cases for {}", country);
        return weeklyStatisticBlockRepo.findByCountryAndIndicator(country, EIndicator.CASES);
    }

}
