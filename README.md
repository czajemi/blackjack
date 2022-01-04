# blackjack
A console version of blackjack written in Java. This is a basic version with only hit (draw another card) or stand (end their turn) functionality.
Simple rules of the game:
1. Standard deck of 52 cards.
2. Players start with two cards and have only to options: hit or stand.
3. Number cards are valued at their number. Face cards (jack queen and king) are valued at 10 and aces are valued at 1 or 11. It depends on the situation:
  - If the value of hand with an ace puts over 21, the ace value is 1. Otherwise has a value of 11.
4. If a player starts with cards value of 21, player get blackjack and win.
5. If a dealer starts with 21, the player loses, before make any decisions to hit or stand.
6. If the player and dealer start with 21, it is a push.
7. The player may stand at any time. When the player stands, it is the end of their turn, and the dealer begins drawing their third, fourth and so on.
8. The dealer will keep drawing cards until they reach a hand valued at 17 or higher.
9. If neither the player nor the dealer bust or get blackjack, the person with higher score wins the round.

