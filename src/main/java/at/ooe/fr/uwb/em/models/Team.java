package at.ooe.fr.uwb.em.models;

import javax.persistence.*;

@Entity
@Table(name = "em_team")
public class Team {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private String teamName;

    public Team() {

    }

    public Team(int id, String teamName) {
        this.id = id;
        this.teamName = teamName;
    }

    public Team(String teamName) {
        this.teamName = teamName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
}
