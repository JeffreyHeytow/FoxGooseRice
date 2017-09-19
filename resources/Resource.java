package resources;

/**
 * Created by heyto on 9/15/2017.
 */
public class Resource {
    private boolean isOnWestBank;
    private boolean isOnEastBank;


    public Resource() {
        this.isOnWestBank = true;   // we start on the west side of the river
        this.isOnEastBank = false;
    }

    /*
    * this method will put the resource on
    * the East bank of the river
    */
    public void putOnEastBank() {
        this.isOnWestBank = false;
        this.isOnEastBank = true;
    }

    /*
    * this method will put the resource on
    * the West bank of the river
    */
    public void putOnWestBank() {
        this.isOnWestBank = true;
        this.isOnEastBank = false;
    }

    /* get the location of the resource */
    public boolean isOnWestBank() {
        return isOnWestBank;
    }

    public boolean isOnEastBank() {
        return isOnEastBank;
    }
}
