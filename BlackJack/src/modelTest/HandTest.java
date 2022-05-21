package modelTest;

import model.Hand;
import model.Card;
import model.CardDeck;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// Tests for Hand class
public class HandTest {
    Hand hand;

    @BeforeEach
    void before() {
        hand = new Hand();
    }
    @Test
    void testConstructor() {
        assertEquals(0, hand.getCards().size());
        assertEquals(0, hand.getTotal());
        assertFalse(hand.getHasAce());
    }

    @Test
    void testAddCardNoAce() {
        Card c = new Card(5, "card");
        hand.addCard(c);
        assertEquals(1, hand.getCards().size());
        assertEquals(5, hand.getTotal());
        assertFalse(hand.getHasAce());
    }

    @Test
    void testAddCardAce() {
        Card c = new Card(1, "card");
        hand.addCard(c);
        assertEquals(1, hand.getCards().size());
        assertEquals(11, hand.getTotal());
        assertTrue(hand.getHasAce());
    }

    @Test
    void testAddCardMultiple() {
        Card c1 = new Card(5, "card1");
        Card c2 = new Card(1, "card2");
        hand.addCard(c1);
        hand.addCard(c2);
        assertEquals(2, hand.getCards().size());
        assertEquals(16, hand.getTotal());
        assertTrue(hand.getHasAce());
    }

    @Test
    void testHit() {
        CardDeck cd = new CardDeck();
        hand.hit(cd);
        assertNotEquals(0, hand.getTotal());
        assertEquals(1, hand.getCards().size());
    }

    // Difficult to comprehensively test hit and handleDealer due to the random elements of the functions
}
