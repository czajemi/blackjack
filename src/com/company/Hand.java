package com.company;

import java.util.ArrayList;

public class Hand {
    private ArrayList<Card> hand;

    public Hand(){
        hand = new ArrayList<Card>();
    }

    // method to add a card from a deck to this hand
    public void takeCardFromDeck(Deck deck){
        hand.add(deck.takeCard());
    }

    // to print the dealer or player current hand
    public String toString(){
        String output = "";
        for(Card card: hand){
            output += card + " - ";
        }
        return output;
    }

    //method returns an int value of the hand
    public int calculatedValue(){
        int value = 0;
        int aceCount = 0; //to count number of aces

        for(Card card: hand){
            //add card value to hand
            value += card.getValue();
            //count added aces
            if(card.getValue() == 11){
                aceCount ++;
            }
        }
        //if multiple aces have been added
        //go back and set each ace to 1 until get back under 21
        if (value > 21 && aceCount > 0){
            while(aceCount > 0 && value > 21){
                aceCount --;
                value -= 10;
            }
        }
    return value;
    }
}
