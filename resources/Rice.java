package resources;

/**
 * Created by heyto on 9/15/2017.
 */
public class Rice extends Resource {

    private String location;

    public Rice() {
        super();
        this.location = "I don't know where the Rice is!";
    }

    public String getLocation() {
        if (this.isOnEastBank()) {
            this.location = "The Rice is on the East bank of the river.";
        }
        if (this.isOnWestBank()) {
            this.location = "The Rice is on the West bank of the river.";
        }
        return location;
    }

}
