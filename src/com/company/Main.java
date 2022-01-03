package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println("Welcome to Blackjack game");

        //create and start the game
        Game blackjack = new Game();

        // test deck and hand
        Deck testDeck = new Deck();
        testDeck.addCard(new Card(Suit.HEART, Rank.ACE));
        testDeck.addCard(new Card(Suit.HEART, Rank.ACE));
        testDeck.addCard(new Card(Suit.HEART, Rank.ACE));
        testDeck.addCard(new Card(Suit.HEART, Rank.ACE));
        Hand testHand = new Hand();
        testHand.takeCardFromDeck(testDeck);
        testHand.takeCardFromDeck(testDeck);
        testHand.takeCardFromDeck(testDeck);
        testHand.takeCardFromDeck(testDeck);
    }
}
