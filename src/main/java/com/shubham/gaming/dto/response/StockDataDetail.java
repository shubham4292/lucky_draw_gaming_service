package com.shubham.gaming.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Map;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class StockDataDetail {

    @JsonProperty("token_data")
    private Map<String, IndexDetails> tokenData;
}
