package com.ibm.intern.covid19statsapp.data.repo;

import com.ibm.intern.covid19statsapp.data.entity.EIndicator;
import com.ibm.intern.covid19statsapp.data.entity.WeeklyStatisticBlock;
import com.ibm.intern.covid19statsapp.payload.response.CountriesResponse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WeeklyStatisticBlockRepo extends JpaRepository<WeeklyStatisticBlock, Long> {
    List<CountriesResponse> findDistinctBy();

    List<WeeklyStatisticBlock> findByCountry(String country);

    List<WeeklyStatisticBlock> findByCountryAndIndicator(String country, EIndicator indicator);

}
