package com.ibm.intern.covid19statsapp.data.repo;

import com.ibm.intern.covid19statsapp.data.entity.WeeklyStatisticBlock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeeklyStatisticBlockRepo extends JpaRepository<WeeklyStatisticBlock, Long> {
}
