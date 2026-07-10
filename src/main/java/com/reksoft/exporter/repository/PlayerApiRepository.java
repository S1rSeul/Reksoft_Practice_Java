package com.reksoft.exporter.repository;

import com.reksoft.exporter.properties.ApiProperties;
import com.reksoft.exporter.repository.dto.PlayerViewDto;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Repository
public class PlayerApiRepository extends AbstractApiRepository {

    public PlayerApiRepository(RestTemplate restTemplate, ApiProperties apiProperties) {
        super(restTemplate, apiProperties);
    }

    public List<PlayerViewDto> getPlayers() {
        return fetchList("/api/Players", new ParameterizedTypeReference<>() {
        });
    }
}
