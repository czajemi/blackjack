package com.company;

import java.util.ArrayList;

/**
 * Deck of cards
 */
public class Deck {

    //arraylist to hold deck of cards
    private ArrayList<Card> deck;

    //create empty deck of cards
    public Deck(){
        deck = new ArrayList<Card>();
    }

    //method to add a single card to the deck
    public void addCard(Card card){
        deck.add(card);
    }

    //toString method returns a String containing every single card in the deck
    public String toString(){
        //empty string to hold everything which is going to return
        String output = "";
        for(Card card: deck){
            //add the card to output
            output += card;
            output += "\n";
        }
        return output;
    }

    // create a standard deck of cards (if new Deck is true)
    public Deck(boolean makeDeck){
        deck = new ArrayList<Card>();
        if(makeDeck){
            for(Suit suit : Suit.values()){
                for(Rank rank : Rank.values()){
                    //add a new card containing each iterations suit and rank
                    deck.add(new Card(suit, rank));
                }
            }
        }
    }

    // method to shuffle the deck
    public void shuffle(){
        ArrayList<Card> shuffled = new ArrayList<Card>();
        while(deck.size() > 0){
            // choose random index to pull
            int cardToPull = (int)(Math.random()*(deck.size()-1));
            // add random card to new shuffled deck and remove from orginal
            shuffled.add(deck.get(cardToPull));
            deck.remove(cardToPull);

        }
       deck = shuffled;
    }
}
