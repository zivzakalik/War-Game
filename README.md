# War-Game
The classis War-Game card game, written in java.

## Preparations for the game
First, a new deck of cards is shuffled randomly, and the cards are evenly divided between the two players by
giving one card to each player (in alphabetical order of their names) until there are no cards left in the deck.

## the progress of the game
The game consists of several rounds. In each round the two participants draw the top card from their deck (in alphabetical order
Of their names), and put it in a central pile. The participant who pulled out the card with the highest number takes both cards, and puts them in a separate pile of his own (different from the pile of cards he is playing with).
In case both players pulled the same card, they will start a "war" between them: a draw of two cards followed by a third card. The winner of the war is the one
who draws the third highest card, and he takes all the cards of the round. If The participants draw the same card again, they will wage another war between them (and so on).
Each time a participant has to draw a card but the deck of cards that is in his hand is over, he must shuffle his second deck
(The deck of cards he has won), and turn this stack into his game deck, without changing the order of the cards after shuffling.
When he wins more cards, he puts them back in a separate pile.
If the participant also runs out of cards in his second deck, he leaves the game and loses.
