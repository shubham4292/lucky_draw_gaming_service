package com.shubham.gaming.service;

import com.shubham.gaming.dto.response.StockDataDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.net.URI;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ThirdPartyApiService {

    @Autowired
    private GoogleSheetService googleSheetService;

    @Autowired
    private RestTemplate restTemplate;

    public void fetchAndUpdateSheet() throws IOException, GeneralSecurityException {


        URI uri = UriComponentsBuilder.fromHttpUrl("https://service.upstox.com/market-data-api/v2/open/quote")
                .queryParam("i", "NSE_INDEX|Nifty Bank,NSE_INDEX|Nifty 50") // Let UriComponentsBuilder handle encoding
                .build()
                .toUri();

        HttpHeaders headers = new HttpHeaders();
        headers.set("x-request-id", "1");
        headers.set("Content-Type", "application/x-www-form-urlencoded");
        headers.set("user-agent", "PostmanRuntime/7.29.2");

        HttpEntity<String> entity = new HttpEntity<>(headers);

        // Make API call
        try{
            ResponseEntity<StockDataDto> response = restTemplate.exchange(uri, HttpMethod.GET, entity, StockDataDto.class);

            if(Objects.nonNull(response.getBody()) && response.getBody().isSuccess()) {
                List<List<Object>> sheetData = response.getBody().getData().getTokenData().entrySet().stream()
                        .map(entry -> Arrays.asList(entry.getKey(), (Object) entry.getValue().getLastPrice()))
                        .collect(Collectors.toList());

                googleSheetService.updateGoogleSheet(sheetData, "A2");
            }
        }catch(Exception ex){
            System.out.println("exception occurred");
            System.out.println(ex);
        }
        return;
    }
}