package com.company;

/**
 * Contains the Ranks of Cards, Names, and Values
 */
public enum Rank {
    TWO("Two", 2),
    THREE("Three", 3),
    FOUR("Four", 4),
    FIVE("Five", 5),
    SIX("Six", 6),
    SEVEN("Seven", 7),
    EIGHT("Eight", 8),
    NINE("Nine", 9),
    TEN("Ten", 10),
    JACK("Jack", 10),
    QUEEN("Queen", 10),
    KING("King", 10),
    ACE("Ace", 11);

    String rankName;
    int rankValue; // holds value of each rank

    // gives each rank a name and add an int to store value
    Rank(String rankName, int rankValue){
        this.rankName = rankName;
        this.rankValue = rankValue;
    }

    // string method which returns the name
    public String toString(){
        return rankName;
    }
}
