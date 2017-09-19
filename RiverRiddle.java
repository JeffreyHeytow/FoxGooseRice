import game.GameManager;

/**
 * Created by heyto on 9/15/2017.
 */
public class RiverRiddle {
    public static void main(String[] args) {
        // create a new player object to play game:
        GameManager riverRiddle;
        // print the story onto the screen:
        printSetup();
        // create a game loop to keep playing util game over
        do {    // do this
            riverRiddle = GameManager.getInstance();
            riverRiddle.playGame();
        }
        while (riverRiddle.isPlayAgain());  // while this condition is true
        System.out.println("Thanks for playing the River Riddle game!");    // when isPlayAgain is false
    }

    /* print the setup for the game */
    public static void printSetup() {
        System.out.println("You are a farmer with three resources, a fox, a goose, and a bag of rice. ");
        System.out.println("You find yourself standing on the West bank of a wide river. ");
        System.out.println("You must get all of your resources across the river safely. ");
        System.out.println("You see a raft that only has enough room for yourself and one of your resources.");
        System.out.println("This means that you have to take each resource across one at a time.\n\n");
        System.out.println("THE PROBLEM:");
        System.out.println("If you leave the fox alone with the goose, ");
        System.out.println("the fox will eat the goose!");
        System.out.println("If you leave the goose alone with the rice, ");
        System.out.println("the goose will eat the rice!\n\n");
        System.out.println("HOW WILL YOU CROSS THE RIVER?\n\n");
    }
}

