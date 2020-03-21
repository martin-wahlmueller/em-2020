package at.ooe.fr.uwb.em.dtos;

import at.ooe.fr.uwb.em.models.Team;

import java.time.LocalDateTime;

public class GameDto {
    private int id;
    private LocalDateTime dateTime;
    private Team homeTeam;
    private int homeScore;
    private Team awayTeam;
    private int awayScore;
    private boolean finish;

    public GameDto() {

    }

    public GameDto(int id, LocalDateTime dateTime, Team homeTeam, int homeScore, Team awayTeam, int awayScore, boolean finish) {
        this.id = id;
        this.dateTime = dateTime;
        this.homeTeam = homeTeam;
        this.homeScore = homeScore;
        this.awayTeam = awayTeam;
        this.awayScore = awayScore;
        this.finish = finish;
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public int getHomeScore() {
        return homeScore;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    public int getAwayScore() {
        return awayScore;
    }

    public boolean isFinish() {
        return finish;
    }
}
