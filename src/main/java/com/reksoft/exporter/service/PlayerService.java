package com.reksoft.exporter.service;

import com.reksoft.exporter.model.Player;
import com.reksoft.exporter.repository.PlayerApiRepository;
import com.reksoft.exporter.repository.dto.PlayerViewDto;
import com.reksoft.exporter.service.mapper.PlayerMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PlayerService extends AbstractApiService<Player, PlayerViewDto> {

    private final PlayerApiRepository playerApiRepository;

    @Override
    protected List<PlayerViewDto> fetchDtos() {
        return playerApiRepository.getPlayers();
    }

    @Override
    protected Player convert(PlayerViewDto dto) {
        return PlayerMapper.toEntity(dto);
    }
}
