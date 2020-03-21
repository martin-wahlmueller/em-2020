package at.ooe.fr.uwb.em.models;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "em_game")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private LocalDateTime dateTime;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Team homeTeam;
    private int homeScore;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Team awayTeam;
    private int awayScore;
    private boolean finish;

    public Game() {

    }

    public Game(int id, LocalDateTime dateTime, Team homeTeam, int homeScore, Team awayTeam, int awayScore, boolean finish) {
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

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
    }

    public int getHomeScore() {
        return homeScore;
    }

    public void setHomeScore(int homeScore) {
        this.homeScore = homeScore;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(Team awayTeam) {
        this.awayTeam = awayTeam;
    }

    public int getAwayScore() {
        return awayScore;
    }

    public void setAwayScore(int awayScore) {
        this.awayScore = awayScore;
    }

    public boolean isFinish() {
        return finish;
    }

    public void setFinish(boolean finish) {
        this.finish = finish;
    }
}
