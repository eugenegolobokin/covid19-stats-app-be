package com.ibm.intern.covid19statsapp.data.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum EIndicator {
    @JsonProperty("cases")
    CASES,
    @JsonProperty("deaths")
    DEATHS
}
