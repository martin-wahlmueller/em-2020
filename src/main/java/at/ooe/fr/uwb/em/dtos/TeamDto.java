package at.ooe.fr.uwb.em.dtos;

public class TeamDto {
    private int id;
    private String name;

    public TeamDto() {

    }

    public TeamDto(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
