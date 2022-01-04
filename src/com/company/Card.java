package com.company;

/**
 * Contains the methods needed to get value of the card, print the card to the console
 * and allows to create cards with suit and rank
 */
public class Card {
    // private instance variables
    private Suit suit;
    private Rank rank;

    // create a card given a suit and rank
    public Card(Suit suit, Rank rank){
        this.suit = suit;
        this.rank = rank;
    }

    // copy constructor
    public Card(Card card){
        this.suit = card.getSuit();
        this.rank = card.getRank();
    }

    // getter methods for card value, suit and rank
    public int getValue(){
        return rank.rankValue;
    }

    public Suit getSuit(){
        return suit;
    }

    public Rank getRank(){
        return rank;
    }

    // toString method returns string representation of the card
    public String toString(){
        return ("["+rank+" of "+ suit + "] ("+this.getValue()+")");    }
}
