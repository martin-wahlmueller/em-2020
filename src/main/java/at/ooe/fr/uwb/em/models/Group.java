package at.ooe.fr.uwb.em.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "em_group")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private char groupName;
    @OneToMany(targetEntity = Team.class)
    private List<Team> teams;

    public Group() {

    }

    public Group(int id, char groupName, List<Team> teams) {
        this.id = id;
        this.groupName = groupName;
        this.teams = teams;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public char getGroupName() {
        return groupName;
    }

    public void setGroupName(char groupName) {
        this.groupName = groupName;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }
}
