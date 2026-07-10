package com.reksoft.exporter.service;

import com.reksoft.exporter.model.Team;
import com.reksoft.exporter.repository.TeamApiRepository;
import com.reksoft.exporter.repository.dto.TeamViewDto;
import com.reksoft.exporter.service.mapper.TeamMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class TeamService extends AbstractApiService<Team, TeamViewDto> {

    private final TeamApiRepository teamApiRepository;
    private final PlayerService playerService;

    @Override
    protected List<TeamViewDto> fetchDtos() {
        return teamApiRepository.getTeams();
    }

    @Override
    protected Team convert(TeamViewDto dto) {
        return TeamMapper.toEntity(dto);
    }
}