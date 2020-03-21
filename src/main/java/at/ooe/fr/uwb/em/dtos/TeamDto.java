package at.ooe.fr.uwb.em.dtos;

public class TeamDto {
    private int id;
    private String teamName;
    private String countryCode;

    public TeamDto() {

    }

    public TeamDto(int id, String teamName, String countryCode) {
        this.id = id;
        this.teamName = teamName;
        this.countryCode = countryCode;
    }

    public int getId() {
        return id;
    }

    public String getTeamName() {
        return teamName;
    }

    public String getCountryCode() {
        return countryCode;
    }
}
