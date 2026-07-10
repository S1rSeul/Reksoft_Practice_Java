package com.reksoft.exporter.service;

import com.reksoft.exporter.model.Player;
import com.reksoft.exporter.model.Team;
import com.reksoft.exporter.repository.TeamApiRepository;
import com.reksoft.exporter.repository.dto.TeamViewDto;
import com.reksoft.exporter.service.mapper.TeamMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
        throw new UnsupportedOperationException("Используйте getAll()");
    }

    @Override
    public List<Team> getAll() {
        List<TeamViewDto> teamViewDtos = fetchDtos();

        List<Player> players = playerService.getAll();
        Map<String, List<Player>> playersByTeam = players.stream()
                .collect(Collectors.groupingBy(Player::getTeamName));

        return teamViewDtos.stream()
                .map(dto -> TeamMapper.toEntity(dto, playersByTeam))
                .toList();
    }
}