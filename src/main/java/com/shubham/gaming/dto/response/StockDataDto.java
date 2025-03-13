package com.shubham.gaming.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class StockDataDto {

    private StockDataDetail data;
    private boolean success;
}
