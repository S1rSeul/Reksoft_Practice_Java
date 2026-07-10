package com.reksoft.exporter.service;

import com.reksoft.exporter.model.Team;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
                String.join(", ", team.getPlayersCombinedNames())
        };
    }
}