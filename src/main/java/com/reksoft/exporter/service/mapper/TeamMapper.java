package com.reksoft.exporter.service.mapper;

import com.reksoft.exporter.model.Player;
import com.reksoft.exporter.model.Team;
import com.reksoft.exporter.repository.dto.TeamViewDto;
import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.Map;

@UtilityClass
public class TeamMapper {
    public static Team toEntity(TeamViewDto dto, Map<String, List<Player>> playersByTeam) {
        Team team = new Team();
        team.setId(dto.getId());
        team.setName(dto.getName());
        team.setPlayers(playersByTeam.get(dto.getName()));
        return team;
    }
}
