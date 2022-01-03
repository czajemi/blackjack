package com.company;

public class Game {
    // create variables used by Game class
    private Deck deck, discarded;
    private Dealer dealer;
    private Player player;
    private int wins, losses, pushes;

    // constructor for the Game class
    public Game(){
        // create a deck with 52 cards
        deck = new Deck(true);
        // create an empty deck
        discarded = new Deck();
        // create dealer and player
        dealer = new Dealer();
        player = new Player();

        // shuffle deck and start first round
        deck.shuffle();
        startRound();
    }

    // method to hold logic for each round
    private void startRound(){
        //give the dealer and player two cards
        dealer.getHand().takeCardFromDeck(deck);
        dealer.getHand().takeCardFromDeck(deck);
        player.getHand().takeCardFromDeck(deck);
        player.getHand().takeCardFromDeck(deck);

        //print dealer and player hands
        dealer.printFirstHand();
        player.printHand();

        // checking if dealer has blackjack to start
        if(dealer.hasBlackjack()){
            dealer.printHand();
            //chceck if player also has blackjack
            if(player.hasBlackjack()){
                System.out.println("You both have a Blackjack - push");
                // end round with push
                pushes ++;
                startRound();
            }
            else{
                System.out.println("Dealer has BlackJack - you lose");
                dealer.printHand();
                losses ++;
                startRound();
            }
        }

        // check if player has blackjack to start
        if(player.hasBlackjack()){
            System.out.println("You have Blackjack - you win!");
            wins ++;
            startRound();
        }

        player.makeDecision();
    }
}
