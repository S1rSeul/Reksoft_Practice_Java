package com.reksoft.exporter.service.mapper;

import com.reksoft.exporter.model.Player;
import com.reksoft.exporter.model.Team;
import com.reksoft.exporter.repository.dto.TeamViewDto;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class TeamMapper {
    public static Team toEntity(TeamViewDto dto) {
        Team team = new Team();
        team.setId(dto.getId());
        team.setName(dto.getName());
        team.setPlayersCombinedNames(getPlayersCombinedNames(dto));
        return team;
    }

    private List<String> getPlayersCombinedNames(TeamViewDto dto) {
        List<Player> players = dto.getPlayers();

        return players.stream()
                .map(Player::getCombinedName)
                .toList();
    }
}
