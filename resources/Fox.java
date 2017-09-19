package resources;

/**
 * Created by heyto on 9/15/2017.
 */
public class Fox extends Resource {

    private String location;

    public Fox() {
        super();
        this.location = "I don't know where the Fox is!";
    }

    public String getLocation() {
        if(this.isOnEastBank()) {
            this.location = "The Fox is on the East bank of the river.";
        }
        if (this.isOnWestBank()) {
            this.location = "The Fox is on the West bank of the river.";
        }
        return location;
    }

    
}
