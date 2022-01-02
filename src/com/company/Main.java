package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println("Welcome to Blackjack game");

        //create and start the game
        Game blackjack = new Game();

        // tests
        System.out.println(Suit.DIAMOND);
        System.out.println(Rank.ACE + " has a value of " + Rank.ACE.rankValue);
        // card test
        Card testCard = new Card(Suit.CLUB, Rank.ACE);
        System.out.println(testCard);
    }
}
