package com.shubham.gaming.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class IndexDetails {

    private Double lastPrice;
    private Double closePrice;
    private Object lastTradeTime;
}
