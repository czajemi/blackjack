package com.company;

/**
 * Contains game logic
 */
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
        // if it isn't first round -> display users score and put their cards back to deck
        if(wins>0 || losses>0 || pushes >0){
            System.out.println();
            System.out.println("Starting next round");
            System.out.println("Wins: " + wins + " losses: " + losses + " pushes: " + pushes);
            dealer.getHand().discardHandToDeck(discarded);
            player.getHand().discardHandToDeck(discarded);
        }

        // check if the deck has at leadt 4 cards to left
        if(deck.cardsLeft() < 4){
            deck.reloadDeckFromDiscard(discarded);
        }
        // give the dealer and player two cards
        dealer.getHand().takeCardFromDeck(deck);
        dealer.getHand().takeCardFromDeck(deck);
        player.getHand().takeCardFromDeck(deck);
        player.getHand().takeCardFromDeck(deck);

        // print dealer and player hands
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

        player.makeDecision(deck, discarded);

        // check if player busted
        if(player.getHand().calculatedValue()>21){
            System.out.println("You are over 21");
            losses ++;
            startRound();
        }

        // dealer turn
        dealer.printHand();
        while (dealer.getHand().calculatedValue()<17){
            dealer.hit(deck, discarded);
        }

        // checking who wins
        if(dealer.getHand().calculatedValue()>21){
            System.out.println("Dealer busted");
            wins ++;
        }
        else if(dealer.getHand().calculatedValue() > player.getHand().calculatedValue()) {
            System.out.println("You lose");
            losses ++;
        }
        else if(dealer.getHand().calculatedValue() < player.getHand().calculatedValue()){
            System.out.println("You win");
            wins ++;
        }
        else{
            System.out.println("Push");
        }

        startRound();
    }

    // pause the game
    public static void pause(){
        try{
            Thread.sleep(8000);
        } catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
