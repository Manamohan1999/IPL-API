package com.practice.ipl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.ipl.model.Team;
import com.practice.ipl.service.TeamService;

@RestController
@RequestMapping("/team")
public class TeamController {
    
    @Autowired
    private TeamService teamService;

    @GetMapping("/")
    public List<Team> getTeams(){
        return teamService.getTeams();
    }

    @GetMapping("/{teamName}")
    public Team getTeam(@PathVariable String teamName){
        return teamService.getTeamWithLatestMatches(teamName, 4);
    }
    
}
