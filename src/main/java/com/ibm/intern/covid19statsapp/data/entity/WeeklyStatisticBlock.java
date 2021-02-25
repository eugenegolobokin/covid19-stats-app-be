package com.ibm.intern.covid19statsapp.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = "statistics")
public class WeeklyStatisticBlock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String country;

    @Enumerated(value = EnumType.STRING)
    private EIndicator indicator;

    @JsonProperty("weekly_count")
    private Long weeklyCount;

    @JsonProperty("year_week")
    private String yearWeek;

    @JsonProperty("cumulative_count")
    private Long cumulativeCount;

    public void setCountry(String country) {
        this.country = country.replaceAll("/", " ");
    }
}
