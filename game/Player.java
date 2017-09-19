package game;

import resources.Fox;
import resources.Goose;
import resources.Resource;
import resources.Rice;

import java.util.Scanner;

/**
 * Created by heyto on 9/15/2017.
 */
public class Player {
    // A list of resources to be managed by the game
    private enum Resources {
        FOX, GOOSE, RICE, NONE;
    }

    protected Resource fox;             // resource
    protected Resource goose;           // resource
    protected Resource rice;            // resource

    private Resources resource;         // a tightly-bound resource

    protected boolean isOnWestBank;     // the starting position for the farmer
    protected boolean isOnEastBank;     // the ending position for the farmer

    private String answer;              // the input answer

    protected int move;                  // the move count

    protected Player() {
        this.fox = new Fox();
        this.goose = new Goose();
        this.rice = new Rice();

        this.isOnWestBank = true;
        this.isOnEastBank = false;

        this.move = 1;
    }

    protected void askQuestion() {
        boolean isValidAnswer = false;
        while (!isValidAnswer) {
            System.out.println("Which resource should I take on the raft?");
            // read in the answer from the console
            Scanner scanner = new Scanner(System.in);
            this.answer = scanner.nextLine().toLowerCase();

            // assign the value of the resouce, if it contains a valid respone
            // if the response is valid, check to see if the farmer and the resource
            // are on the same side of ther river.
            if (this.answer.toLowerCase().contains("fox")) {
                if (canMoveResource(fox)) {
                    this.resource = Resources.FOX;
                    isValidAnswer = true;
                } else {
                    System.out.println("The fox is on the other side of the river!  Try again...\n");
                }
            } else if (this.answer.toLowerCase().contains("goose")) {
                if (canMoveResource(goose)) {
                    this.resource = Resources.GOOSE;
                    isValidAnswer = true;
                } else {
                    System.out.println("The goose is on the other side of the river!  Try again...\n");
                }
            } else if (this.answer.toLowerCase().contains("rice")) {
                if (canMoveResource(rice)) {
                    this.resource = Resources.RICE;
                    isValidAnswer = true;
                } else {
                    System.out.println("The bag of rice is on the other side of the river!  Try again...\n");
                }
            } else if (this.answer.equals("") || this.answer.toLowerCase().contains("nothing")) {
                this.resource = Resources.NONE;
                isValidAnswer = true;
            } else { // no valid response was given
                // if there is a "the" in the answer, remove it
                if (this.answer.toLowerCase().contains("the")) {
                    String removeThe = this.answer.substring(4, this.answer.length());
                    this.answer = removeThe;
                }
                System.out.println("I'm sorry... I don't have the " + this.answer + " resource!\n");
            }
        }
    }

    protected void moveResource() {
        switch (resource) {
            case FOX:
                // move the fox and the farmer from west to east
                if (fox.isOnWestBank()) {
                    this.moveFarmerEast();
                    fox.putOnEastBank();
                } else { // move the fox and the farmer from east to west
                    this.moveFarmerWest();
                    fox.putOnWestBank();
                }
                break;
            case GOOSE:
                // move the goose and the farmer from west to east
                if (goose.isOnWestBank()) {
                    this.moveFarmerEast();
                    goose.putOnEastBank();
                } else { // move the goose and the farmer from east to west
                    this.moveFarmerWest();
                    goose.putOnWestBank();
                }
                break;
            case RICE:
                // move the rice and the farmer from west to east
                if (rice.isOnWestBank()) {
                    this.moveFarmerEast();
                    rice.putOnEastBank();
                } else { // move the rice and the farmer from east to west
                    this.moveFarmerWest();
                    rice.putOnWestBank();
                }
                break;
            default:
                // no resources are being moved - just move the farmer
                if (this.isOnWestBank) {
                    this.moveFarmerEast();
                } else {
                    this.moveFarmerWest();
                }
                break;
        }
    }

    /* move the farmer from west to east */
    private void moveFarmerEast() {
        this.isOnWestBank = false;
        this.isOnEastBank = true;
    }

    /* move the farmer from east to west */
    private void moveFarmerWest() {
        this.isOnEastBank = false;
        this.isOnWestBank = true;
    }

    /*
    * checks to see if the farmer and the
    * resource to be moved are on the same
    * side of the river.
    */
    private boolean canMoveResource(Resource resource) {
        boolean onSameSide = true;
        if (this.isOnWestBank && resource.isOnEastBank()) {
            onSameSide = false;
        }
        if (this.isOnEastBank && resource.isOnWestBank()) {
            onSameSide = false;
        }
        return onSameSide;
    }
}
