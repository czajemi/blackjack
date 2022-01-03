package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println("Welcome to Blackjack game");

        //create and start the game
        Game blackjack = new Game();

        // test: making cards and deck
        Deck testDeck = new Deck();
        Card firstCard = new Card(Suit.DIAMOND, Rank.JACK);
        Card secondCard = new Card(Suit.HEART, Rank.FIVE);

        testDeck.addCard(firstCard);
        testDeck.addCard(secondCard);

        System.out.println(testDeck);

        //Make a standard deck of 52 cards
        Deck testDeck1 = new Deck(true);
        testDeck1.shuffle();

        System.out.println(testDeck1);
    }
}
