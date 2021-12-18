import java.util.ArrayList;
import java.util.Random;

public class Deck {
    private ArrayList<Card> deck;

    public Deck(boolean init) {
        deck = new ArrayList<>();
        if (init) {
            for (Shape shape : Shape.values()) {
                for (int num = 1; num <= 13; num++) {
                    deck.add(new Card(num, shape));
                }
            }
        }
    }

    public void addCard(Card card) {
        this.deck.add(card);
    }

    public Card removeTopCard() {
        /** removes the top card from the deck, and return it.*/
        Card card = this.deck.get(deck.size() - 1);
        this.deck.remove(deck.size() - 1);
        return card;
    }

    public boolean isEmpty() {
        return this.deck.isEmpty();
    }

    public void shuffle() {
        /**
         *  shuffles the deck according to a specific algorithm, using
         *  user-input seed accepted in the main class.
         */
        int num1, num2;
        Card temp;
        Random rand = Main.rnd;
        for (int i = 0; i < 50; i++) {
            num1 = rand.nextInt(deck.size());
            num2 = rand.nextInt(deck.size());
            temp = deck.get(num1);
            deck.add(num1, deck.get(num2));
            deck.remove(num1 + 1);
            deck.add(num2, temp);
            deck.remove(num2 + 1);
        }
    }

    public Card watchTopCard() {
        /** see the top card of the deck without removing it */
        return deck.get(deck.size() - 1);
    }

    public void reverse() {
        /** reverses the order of the deck - top to bottom */
        ArrayList<Card> reversed = new ArrayList<>();
        while (!this.deck.isEmpty()) {
            reversed.add(this.deck.remove(deck.size() - 1));
        }
        this.deck = reversed;
    }
}
