package game;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by heyto on 9/15/2017.
 */
public class GameManager extends Player {

    private boolean playAgain;      // a flag to determine if player wants to play again.
    private String answer;          // for play again option

    private static GameManager instance = null;     // SIngleton design

    private GameManager() {
        super();
        this.playAgain = true;
        this.answer = "n";
    }

    /* get singleton instance */
    public static GameManager getInstance() {
        if(instance == null) {
            instance = new GameManager();
        }
        return instance;
    }

    /* play the game until the player wins or loses */
    public void playGame() {
        // get the input from the player on which resource to move
        askQuestion();
        // move the resource input by the player
        moveResource();
        // print a summary of the current game state
        summarizeMove();
        // make sure the player did not violate any rules
        checkRules();
    }

    public boolean isPlayAgain() {
        return playAgain;
    }

    /* check to see if any rules have been broken or if the player won */
    private void checkRules() {
        // winning condition
        if(fox.isOnEastBank() && goose.isOnEastBank() && rice.isOnEastBank() && this.isOnEastBank) {
            System.out.println("You did it! All of the resources made it across the river safely.\n");
            // end the game
            this.playAgain = false;
            // exit the method to return to main game loop
            return;
        }
        // fox and goose are alone on the East bank
        if(fox.isOnEastBank() && goose.isOnEastBank() && rice.isOnWestBank()) {
            if(isOnEastBank) {
                System.out.println("The farmer stopped the fox from eating the goose!\n");
            } else {
                System.out.println("You left the fox alone with the goose on the East side of the river!");
                System.out.println("The fox ate the goose, and you just lost the game.\n");
                playAgain();
                return;
            }
            // fox and goose are alone on the West bank
        } else if(fox.isOnWestBank() && goose.isOnWestBank() && rice.isOnEastBank()) {
            if(isOnWestBank) {
                System.out.println("The farmer stopped the fox from eating the goose!\n");
            } else {
                System.out.println("You left the fox alone with the goose on the West side of the river!");
                System.out.println("The fox ate the goose, and you just lost the game.\n");
                playAgain();
                return;
            }
        }
        // goose and rice are alone on the East bank
        if(goose.isOnEastBank() && rice.isOnEastBank() && fox.isOnWestBank()) {
            if(isOnEastBank) {
                System.out.println("The farmer stopped the goose from eating the bag of rice!\n");
            } else {
                System.out.println("You left the goose alone with the bag of rice on the East side of the river!");
                System.out.println("The goose ate the rice, and you just lost the game.\n");
                playAgain();
                return;
            }
            // goose and rice are alone on the West bank
        } else if(goose.isOnWestBank() && rice.isOnWestBank() && fox.isOnEastBank()) {
            if(isOnWestBank) {
                System.out.println("The farmer stopped the goose from eating the bag of rice!\n");
            } else {
                System.out.println("You left the goose alone with the bag of rice on the West side of the river!");
                System.out.println("The goose ate the rice, and you just lost the game.\n");
                playAgain();
                return;
            }
        }
    }

    private void playAgain() {
        boolean isValidAnswer = false;
        while (!isValidAnswer) {
            System.out.println("Would you like to try again? (Yes or No):");
            // read in the answer from the console
            Scanner scanner = new Scanner(System.in);
            this.answer = scanner.nextLine().toLowerCase();

            if(this.answer.toLowerCase().equals("n") || this.answer.toLowerCase().equals("no")) {
                this.playAgain =  false;
                isValidAnswer = true;
            } else if (this.answer.toLowerCase().equals("y") || this.answer.toLowerCase().equals("yes")) {
                this.playAgain = true;
                isValidAnswer = true;
                // create new singleton instance
                instance = null;
                System.out.println("The game has been reset!");
                System.out.println("The farmer and all of his resources are on the West bank of the river.\n");
            } else {
                System.out.println("I'm sorry... I didn't understand that...");
                System.out.println("Would you like to try again? (Yes or No):");
            }
        }
    }

    /* print a summary of the current state of the game */
    private void summarizeMove() {
        List<String> westBank = new ArrayList<>();
        List<String> eastBank = new ArrayList<>();

        if(this.isOnEastBank) {
            eastBank.add("The Farmer");
        } else {
            westBank.add("The Farmer");
        }
        if(fox.isOnEastBank()) {
            eastBank.add("The Fox");
        } else {
            westBank.add("The Fox");
        }

        if(goose.isOnEastBank()) {
            eastBank.add("The Goose");
        } else {
            westBank.add("The Goose");
        }
        if(rice.isOnEastBank()) {
            eastBank.add("The Bag Of Rice");
        } else {
            westBank.add("The Bag Of Rice");
        }
        System.out.println("\nMOVE " + move + " SUMMARY:");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        for(int i = 0; i < eastBank.size(); i++) {
            if(eastBank.size() == 1) {
                System.out.println(eastBank.get(i) + " is on the East side of the river.");
            } else if(eastBank.size() > 2) {
                if (i != (eastBank.size() - 1)) {
                    System.out.print(eastBank.get(i) + ", ");
                } else {
                    System.out.println("and " + eastBank.get(i) + " are on the East side of the river.");
                }
            } else {
                if (i != (eastBank.size() - 1)) {
                    System.out.print(eastBank.get(i) + " ");
                } else {
                    System.out.println("and " + eastBank.get(i) + " are on the East side of the river.");
                }
            }
        }
        for(int i = 0; i < westBank.size(); i++) {
            if(westBank.size() == 1) {
                System.out.println(westBank.get(i) + " is on the West side of the river.");
            } else if(westBank.size() > 2) {
                if (i != (westBank.size() - 1)) {
                    System.out.print(westBank.get(i) + ", ");
                } else {
                    System.out.println("and " + westBank.get(i) + " are on the West side of the river.");
                }
            } else {
                if (i != (westBank.size() - 1)) {
                    System.out.print(westBank.get(i) + " ");
                } else {
                    System.out.println("and " + westBank.get(i) + " are on the West side of the river.");
                }
            }
        }
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
        move++;
    }
}
