package at.ooe.fr.uwb.em.dtos;

public class TeamDto {
    private int id;
    private String teamName;
    private GroupDto group;

    public TeamDto() {

    }

    public TeamDto(int id, String teamName) {
        this.id = id;
        this.teamName = teamName;
    }

    public int getId() {
        return id;
    }

    public String getTeamName() {
        return teamName;
    }

    public GroupDto getGroup() { return group; }
}
