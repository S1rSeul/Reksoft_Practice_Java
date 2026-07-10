package com.reksoft.exporter.service;

import com.reksoft.exporter.model.Player;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlayerCsvReportService extends AbstractCsvReportService<Player> {

    private final PlayerService playerService;

    @Override
    protected List<Player> getData() {
        return playerService.getAll();
    }

    @Override
    protected String[] getHeaders() {
        return new String[]{"ID", "Combined Name", "Nickname", "Country", "Team Name", "Full Name"};
    }

    @Override
    protected String[] mapToRow(Player player) {
        return new String[]{
                String.valueOf(player.getId()),
                player.getCombinedName(),
                player.getNickname(),
                player.getCountry() != null ? String.valueOf(player.getCountry()) : "",
                player.getTeamName(),
                player.getFullName()
        };
    }
}
