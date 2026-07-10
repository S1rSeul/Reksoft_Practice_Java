package com.reksoft.exporter.service;

import com.reksoft.exporter.model.Player;
import com.reksoft.exporter.model.Team;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TeamCsvReportService extends AbstractCsvReportService<Team> {

    private final TeamService teamService;

    @Override
    protected List<Team> getData() {
        return teamService.getAll();
    }

    @Override
    protected String[] getHeaders() {
        return new String[]{"Id", "TeamName", "Players"};
    }

    @Override
    protected String[] mapToRow(Team team) {
        return new String[]{
                String.valueOf(team.getId()),
                team.getName(),
                formatPlayerNames(team.getPlayers())
        };
    }

    private String formatPlayerNames(List<Player> players) {
        return players.stream()
                .map(Player::getCombinedName)
                .collect(Collectors.joining(", "));
    }
}