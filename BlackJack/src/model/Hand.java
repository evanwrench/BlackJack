package model;

import java.util.ArrayList;
import java.util.Random;

public class Hand {
    private ArrayList<Card> cards;
    private int total;
    private boolean hasAce;
    private boolean busted;
    Random random;

    public Hand() {
        cards = new ArrayList<>();
        random = new Random();
        hasAce = false;
        total = 0;
    }

    public void addCard(Card card) {
        cards.add(card);
        total += card.getValue();
        if (card.getValue() == 1) {
            hasAce = true;
        }
    }

    // EFFECTS: adds card and checks if hand is busted
    public Card hit(CardDeck deck) {
        Card c = dealNextCard(deck);
        addCard(c);
        if (total > 21) {
            busted = true;
        }
        return c;
    }

    public void handleDealer(CardDeck deck) {
        while (getTotal() < 17) {
            hit(deck);
        }
    }

    public Card dealNextCard(CardDeck deck) {
        int i = random.nextInt(deck.size());
        return deck.remove(i);
    }

    public ArrayList<Card> getCards() {
        return this.cards;
    }

    public boolean isBusted() {
        return busted;
    }

    public int getTotal() {
        if (hasAce && total <= 11) {
            return total + 10;
        } else {
            return total;
        }
    }

    public boolean getHasAce() {
        return this.hasAce;
    }
}
