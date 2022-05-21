package model;

import java.util.ArrayList;

public class CardDeck {
    private ArrayList<Card> deck;

    public CardDeck() {
        deck = new ArrayList<>();
        initializeHearts();
        initializeClubs();
        initializeDiamonds();
        initializeSpades();
    }

    public void initializeHearts() {
        deck.add(new Card(1, "Ace of Hearts"));
        deck.add(new Card(2, "Two of Hearts"));
        deck.add(new Card(3, "Three of Hearts"));
        deck.add(new Card(4, "Four of Hearts"));
        deck.add(new Card(5, "Five of Hearts"));
        deck.add(new Card(6, "Six of Hearts"));
        deck.add(new Card(7, "Seven of Hearts"));
        deck.add(new Card(8, "Eight of Hearts"));
        deck.add(new Card(9, "Nine of Hearts"));
        deck.add(new Card(10, "Ten of Hearts"));
        deck.add(new Card(10, "Jack of Hearts"));
        deck.add(new Card(10, "Queen of Hearts"));
        deck.add(new Card(10, "King of Hearts"));
    }

    public void initializeClubs() {
        deck.add(new Card(1, "Ace of Clubs"));
        deck.add(new Card(2, "Two of Clubs"));
        deck.add(new Card(3, "Three of Clubs"));
        deck.add(new Card(4, "Four of Clubs"));
        deck.add(new Card(5, "Five of Clubs"));
        deck.add(new Card(6, "Six of Clubs"));
        deck.add(new Card(7, "Seven of Clubs"));
        deck.add(new Card(8, "Eight of Clubs"));
        deck.add(new Card(9, "Nine of Clubs"));
        deck.add(new Card(10, "Ten of Clubs"));
        deck.add(new Card(10, "Jack of Clubs"));
        deck.add(new Card(10, "Queen of Clubs"));
        deck.add(new Card(10, "King of Clubs"));
    }

    public void initializeDiamonds() {
        deck.add(new Card(1, "Ace of Diamonds"));
        deck.add(new Card(2, "Two of Diamonds"));
        deck.add(new Card(3, "Three of Diamonds"));
        deck.add(new Card(4, "Four of Diamonds"));
        deck.add(new Card(5, "Five of Diamonds"));
        deck.add(new Card(6, "Six of Diamonds"));
        deck.add(new Card(7, "Seven of Diamonds"));
        deck.add(new Card(8, "Eight of Diamonds"));
        deck.add(new Card(9, "Nine of Diamonds"));
        deck.add(new Card(10, "Ten of Diamonds"));
        deck.add(new Card(10, "Jack of Diamonds"));
        deck.add(new Card(10, "Queen of Diamonds"));
        deck.add(new Card(10, "King of Diamonds"));
    }

    public void initializeSpades() {
        deck.add(new Card(1, "Ace of Spades"));
        deck.add(new Card(2, "Two of Spades"));
        deck.add(new Card(3, "Three of Spades"));
        deck.add(new Card(4, "Four of Spades"));
        deck.add(new Card(5, "Five of Spades"));
        deck.add(new Card(6, "Six of Spades"));
        deck.add(new Card(7, "Seven of Spades"));
        deck.add(new Card(8, "Eight of Spades"));
        deck.add(new Card(9, "Nine of Spades"));
        deck.add(new Card(10, "Ten of Spades"));
        deck.add(new Card(10, "Jack of Spades"));
        deck.add(new Card(10, "Queen of Spades"));
        deck.add(new Card(10, "King of Spades"));
    }

    public int size() {
        return deck.size();
    }

    public Card remove(int i) {
        return deck.remove(i);
    }
}
