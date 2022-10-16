package com.practice.ipl.data;

import java.time.LocalDate;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.lang.NonNull;

import com.practice.ipl.model.Match;

public class MatchProcessor implements ItemProcessor<MatchInput, Match> {

    @Override
    public Match process(@NonNull final MatchInput matchInput) throws Exception {
        Match match = Match.builder()
                .id(Long.parseLong(matchInput.getId()))
                .city(matchInput.getCity())
                .date(LocalDate.parse(matchInput.getDate()))
                .season(matchInput.getSeason())
                .matchNumber(matchInput.getMatchNumber())
                .venue(matchInput.getVenue())
                .tossWinner(matchInput.getTossWinner())
                .tossDecision(matchInput.getTossDecision())
                .superOver(matchInput.getSuperOver())
                .winningTeam(matchInput.getWinningTeam())
                .wonBy(matchInput.getWonBy())
                .margin(matchInput.getMargin())
                .playerOfMatch(matchInput.getPlayerOfMatch())
                .umpire1(matchInput.getUmpire1())
                .umpire2(matchInput.getUmpire2())
                .build();

        // setting firstbat team to team1
        String firstInnings, secondInnings;
        if ("bat".equalsIgnoreCase(matchInput.getTossDecision())) {
            firstInnings = matchInput.getTossWinner();
            secondInnings = matchInput.getTossWinner().equals(matchInput.getTeam1()) ? matchInput.getTeam2()
                    : matchInput.getTeam1();
        } else {
            secondInnings = matchInput.getTossWinner();
            firstInnings = matchInput.getTossWinner().equals(matchInput.getTeam1()) ? matchInput.getTeam2()
                    : matchInput.getTeam1();
        }

        match.setTeam1(firstInnings);
        match.setTeam2(secondInnings);

        return match;
    }

}