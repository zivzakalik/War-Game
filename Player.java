public class Player {
    private String name;
    private Deck gameDeck;
    private Deck winningDeck;

    public Player(String name) {
        this.name = name;
        this.gameDeck = new Deck(false);
        this.winningDeck = new Deck(false);
    }

    public String getName() {
        return name;
    }

    public void addToWinningDeck(Card card) {
        this.winningDeck.addCard(card);
    }

    public void addToGameDeck(Card card) {
        this.gameDeck.addCard(card);
    }

    private void switchDeck() {
        /**
         * when the game deck is empty, the winning deck is shuffled and
         * becomes the new game deck.
         */
        if (this.gameDeck.isEmpty()) {
            winningDeck.shuffle();
            while (!this.winningDeck.isEmpty()) {
                addToGameDeck(this.winningDeck.removeTopCard());
            }
            gameDeck.reverse();
        }
    }

    public Card drawCard() {
        switchDeck();
        return this.gameDeck.removeTopCard();
    }

    public boolean outOfCards() {
        return this.gameDeck.isEmpty() && this.winningDeck.isEmpty();
    }

    @Override
    public String toString() {
        /** prints out the player's name. */
        return this.name;
    }
}
