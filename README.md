# War Game
The classic War card game, implemented in Java.

## Game Setup
To start, a deck of cards is shuffled and then evenly distributed between two players. Cards are dealt one at a time to each player in alphabetical order of their names until the deck is depleted.

## Gameplay
The game is played in several rounds. Each round, both players draw the top card from their decks (also in alphabetical order of their names) and place it in a central pile. The player with the higher card wins the round and collects both cards, placing them in a separate winnings pile.

### Handling Ties: The "War"
If the cards are the same, a "war" begins. Each player draws two cards and then a third card. The player with the higher third card wins all the cards played in this round. If the third cards are also the same, the war repeats with additional sets of three cards until there is a winner.

### Recycling Cards
If a player needs to draw a card but their main deck is empty, they must shuffle their winnings deck and use it as their new main deck. The order of the cards after shuffling should remain unchanged. Won cards are always added to the separate winnings pile.

### Game End
The game ends when a player runs out of cards in both their main and winnings decks, resulting in their loss.
