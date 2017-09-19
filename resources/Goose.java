package resources;

/**
 * Created by heyto on 9/15/2017.
 */
public class Goose extends Resource {

    private String location;

    public Goose() {
        super();
        this.location = "I don't know where the Goose is!";
    }

    public String getLocation() {
        if (this.isOnEastBank()) {
            this.location = "The Goose is on the East bank of the river.";
        }
        if (this.isOnWestBank()) {
            this.location = "The Goose is on the West bank of the river.";
        }
        return location;
    }

}
