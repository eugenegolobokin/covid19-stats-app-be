package com.ibm.intern.covid19statsapp;

import com.ibm.intern.covid19statsapp.data.entity.WeeklyStatisticBlock;
import com.ibm.intern.covid19statsapp.service.WeeklyStatisticBlockService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Slf4j
@SpringBootApplication
public class Covid19StatsAppApplication {

    @Value("${app.data-source-endpoint}")
    private String COVID_STATS_URL;

    public static void main(String[] args) {
        SpringApplication.run(Covid19StatsAppApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(WeeklyStatisticBlockService weeklyStatisticBlockService) {
        return args -> {
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<List<WeeklyStatisticBlock>> responseEntity =
                    restTemplate.exchange(
                            COVID_STATS_URL,
                            HttpMethod.GET,
                            null,
                            new ParameterizedTypeReference<>() {
                            }
                    );
            List<WeeklyStatisticBlock> stats = responseEntity.getBody();
            weeklyStatisticBlockService.saveStatisticsList(stats);
            log.info("Statistics loaded from source and saved to DB");

        };
    }

}
