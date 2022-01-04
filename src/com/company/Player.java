package com.company;

import java.util.Scanner;

/**
 * Handles all operations specific to player
 */
public class Player extends Person{

    Scanner input = new Scanner(System.in);

    // create a new player
    public Player(){
        super.setName("Player");
    }

    // allows player to make decision
    public void makeDecision(Deck deck, Deck discard){
        int decision = 0;
        boolean getNum = true;

        while(getNum) {
            try {
                System.out.println("Would you like to: 1.Hit or 2.Stand?");
                decision = input.nextInt();
                getNum = false;
            } catch(Exception except){
                System.out.println("Invalid input");
                input.next();
            }
        }
        // user decide to hit
        if(decision == 1) {
            // hit deck using deck and discard deck
            this.hit(deck, discard);
            // if user has blackjack or busted -> exit method
            if(this.getHand().calculatedValue()>20){
                return;
            }
            else{
                // allow user to decide to hit or stand by going to this same method
                this.makeDecision(deck, discard);
            }
        }
        else{
            // if user type any number other than 1 -> user stands
            System.out.println("You stand");
        }
    }
}
