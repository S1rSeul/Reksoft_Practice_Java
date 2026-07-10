package com.reksoft.exporter.repository;

import com.reksoft.exporter.properties.ApiProperties;
import com.reksoft.exporter.repository.dto.TeamViewDto;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Repository
public class TeamApiRepository extends AbstractApiRepository {

    public TeamApiRepository(RestTemplate restTemplate, ApiProperties apiProperties) {
        super(restTemplate, apiProperties);
    }

    public List<TeamViewDto> getTeams() {
        return fetchList("/api/Teams", new ParameterizedTypeReference<>() {
        });
    }
}
