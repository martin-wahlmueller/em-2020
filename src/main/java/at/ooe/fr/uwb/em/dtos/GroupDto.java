package at.ooe.fr.uwb.em.dtos;

import java.util.List;

public class GroupDto {
    private int id;
    private char groupName;
    private List<TeamDto> teams;

    public GroupDto() {

    }

    public GroupDto(int id, char groupName, List<TeamDto> teams) {
        this.id = id;
        this.groupName = groupName;
        this.teams = teams;
    }

    public int getId() {
        return id;
    }

    public char getGroupName() {
        return groupName;
    }

    public List<TeamDto> getTeams() {
        return teams;
    }
}
