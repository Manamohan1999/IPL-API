package com.practice.ipl.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.practice.ipl.model.Team;
import com.practice.ipl.repository.MatchRepository;
import com.practice.ipl.repository.TeamRepository;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;
    @Autowired
    private MatchRepository matchRepository;

    public List<Team> getTeams() {
        List<Team> teams = teamRepository.findAll();
        return teams.stream()
                .map(team -> {
                    team.setMatches(matchRepository.getByTeam1OrTeam2OrderByDateDesc(team.getTeamName(),
                            team.getTeamName(), null));
                    return team;
                })
                .collect(Collectors.toList());
    }

    public Team getTeamWithLatestMatches(String teamName, int count) {
        Team team = teamRepository.findByTeamName(teamName);
        team.setMatches(matchRepository.getByTeam1OrTeam2OrderByDateDesc(teamName, teamName, PageRequest.of(0, count)));
        return team;
    }
}
