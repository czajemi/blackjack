package com.company;
/**
 * Handles all operations specific to dealer
 */
public class Dealer extends Person{
    // create a new dealer
    public Dealer(){
        super.setName("Dealer");
    }

    // print dealer's first hand
    public void printFirstHand(){
        System.out.println("The dealer's hand: ");
        System.out.println(super.getHand().getCard(0));
        System.out.println("The second card is face down");
    }
}
