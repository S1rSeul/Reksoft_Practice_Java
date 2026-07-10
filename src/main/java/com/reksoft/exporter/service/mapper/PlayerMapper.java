package com.reksoft.exporter.service.mapper;

import com.reksoft.exporter.model.Player;
import com.reksoft.exporter.repository.dto.PlayerViewDto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class PlayerMapper {
    public static Player toEntity(PlayerViewDto dto) {
        Player player = new Player();
        player.setId(dto.getId());
        player.setCountry(dto.getCountry());
        player.setNickname(dto.getNickName());
        player.setCombinedName(dto.getCombinedName());
        player.setFullName(getFullName(dto));
        player.setTeamName(dto.getTeamName());
        return player;
    }

    private String getFullName(PlayerViewDto dto) {
        return String.format("%s \"%s\" %s", dto.getName(), dto.getNickName(), dto.getSurname());
    }
}
