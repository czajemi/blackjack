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

    // create new card as a copy of card from deck.get(0)
    public Card takeCard(){
        Card cardToTake = new Card(deck.get(0));
        deck.remove(0);
        return cardToTake;
    }

    // check if deck has cards in it
    public boolean hasCards(){
        if (deck.size()>0){
            return true;
        }
        else{
            return false;
        }
    }

    //to empties the deck
    public void emptyDeck(){
        deck.clear();
    }

    //method that adds cards from a discard deck to this deck
    public void addCards(ArrayList<Card> cards){
        deck.addAll(cards);
    }

    // array list which contains all the cards in current deck
    public ArrayList<Card> getCards(){
        return deck;
    }

    // take all cards from discarded deck and place them in current deck
    // next shuffle, and clear old deck
    public void reloadDeckFromDiscard(Deck discard){
        this.addCards(discard.getCards());
        this.shuffle();
        discard.emptyDeck();
        System.out.println("Run out of cards. Creating a new deck from discard pile and shuffling deck");
    }

    // returns amount of card left in deck
    public int cardsLeft(){
        return deck.size();
    }
}
