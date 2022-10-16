package com.practice.ipl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.ipl.model.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long>{

    Team findByTeamName(String teamName);
}
