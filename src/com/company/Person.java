package com.company;

/**
 * Class to share logic between dealer and player
 */
public abstract class Person {
    private Hand hand;
    private String name;

    // create a new person
    public Person(){
        this.hand = new Hand();
        this.name = "";
    }
    // setters and getters method for hand and name

    public Hand getHand() {
        return this.hand;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // check if person have blackjack (21)
    public boolean hasBlackjack(){
        if(this.getHand().calculatedValue() == 21){
            return true;
        }
        else {
            return false;
        }
    }

    // print person's hand
    public void printHand(){
        System.out.println(this.name + "'s hand: ");
        System.out.println((this.hand + "is valued at: " + this.hand.calculatedValue()));
    }

    // hit method
    public void hit(Deck deck, Deck discard){
        // check if there is no cards left in deck
        if(!deck.hasCards()){
            deck.reloadDeckFromDiscard(discard);
        }
        this.hand.takeCardFromDeck(deck);
        System.out.println(this.name + " gets a card");
        this.printHand();
    }
}
