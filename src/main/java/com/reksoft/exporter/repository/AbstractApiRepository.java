package com.reksoft.exporter.repository;

import com.reksoft.exporter.properties.ApiProperties;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.springframework.http.HttpMethod.GET;


public abstract class AbstractApiRepository {

    protected final RestTemplate restTemplate;
    protected final ApiProperties apiProperties;

    protected AbstractApiRepository(RestTemplate restTemplate, ApiProperties apiProperties) {
        this.restTemplate = restTemplate;
        this.apiProperties = apiProperties;
    }

    protected <T> List<T> fetchList(String path, ParameterizedTypeReference<List<T>> typeRef) {
        ResponseEntity<List<T>> response = restTemplate.exchange(
                apiProperties.getBaseUrl() + path,
                GET,
                null,
                typeRef
        );
        return response.getBody();
    }
}
