public class WarGame {
    private Player player1;
    private Player player2;
    private Deck deck1;
    private Deck deck2;

    public WarGame(String playerName1, String playerName2) {
        if (playerName1.compareTo(playerName2) < 0) {
            this.player1 = new Player(playerName1);
            this.player2 = new Player(playerName2);
        } else {
            this.player1 = new Player(playerName2);
            this.player2 = new Player(playerName1);
        }
        this.deck1 = new Deck(false);
        this.deck2 = new Deck(false);
    }

    private void initializeGame() {
        /** initializes the decks for the game. */
        System.out.println("Initializing the game...");
        Deck deck = new Deck(true);
        deck.shuffle();
        for (int i = 0; i < 52; i += 2) {
            player1.addToGameDeck(deck.removeTopCard());
            player2.addToGameDeck(deck.removeTopCard());
        }
    }

    private String checkForWinner() {
        /**
         * check for a winner, returns that player's name if he exists, null if
         * he doesn't.
         */
        if (player1.outOfCards()) {
            return player2.getName();
        }
        if (player2.outOfCards()) {
            return player1.getName();
        }
        return null;
    }

    public String start() {
        /** starts a match, returns the name of the winner at the end. */
        int roundCount = 0;
        boolean haveFought;
        initializeGame();
        while (true) {
            if (checkForWinner() != null) {
                return checkForWinner();
            }
            haveFought = false;
            roundCount++;
            System.out.println("------------------------- Round number " +
                    roundCount + " -------------------------");
            deck1.addCard(player1.drawCard());
            System.out.println(player1.getName() + " drew " +
                    deck1.watchTopCard());
            deck2.addCard(player2.drawCard());
            System.out.println(player2.getName() + " drew " +
                    deck2.watchTopCard());
            //war loop
            while (deck1.watchTopCard().compare(deck2.watchTopCard()) == 0) {
                haveFought = true;
                System.out.println("Starting a war...");
                for (int i = 0; i < 2; i++) {
                    if (checkForWinner() != null) {
                        return checkForWinner();
                    }
                    deck1.addCard(player1.drawCard());
                    System.out.println(player1.getName() + " drew a war card");
                    deck2.addCard(player2.drawCard());
                    System.out.println(player2.getName() + " drew a war card");
                }
                if (checkForWinner() != null) {
                    return checkForWinner();
                }
                deck1.addCard(player1.drawCard());
                System.out.println(player1.getName() + " drew " +
                        deck1.watchTopCard());
                deck2.addCard(player2.drawCard());
                System.out.println(player2.getName() + " drew " +
                        deck2.watchTopCard());
            }
            //check for round winner
            if (deck1.watchTopCard().compare(deck2.watchTopCard()) > 0) {
                executeRoundWinner(haveFought, player1);
            } else if (deck1.watchTopCard().compare(deck2.watchTopCard()) < 0) {
                executeRoundWinner(haveFought, player2);
            }
        }
    }

    private void executeRoundWinner(boolean haveFought, Player player) {
        /** executes the actions needed when a round is won. */
        if (haveFought) {
            System.out.println(player.getName() + " won the war");
        } else System.out.println(player.getName() + " won");
        while (!deck2.isEmpty()) {
            player.addToWinningDeck(deck2.removeTopCard());
            player.addToWinningDeck(deck1.removeTopCard());
        }
    }
}
