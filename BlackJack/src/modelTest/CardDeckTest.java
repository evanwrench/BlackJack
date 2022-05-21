package modelTest;

import model.Card;
import model.CardDeck;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// Tests for the CardDeck class
public class CardDeckTest {
    @Test
    public void testConstructor() {
        CardDeck testDeck = new CardDeck();
        assertEquals(52, testDeck.size());
    }

    @Test
    public void testRemove() {
        CardDeck testDeck = new CardDeck();
        testDeck.remove(51);
        testDeck.remove(0);
        testDeck.remove(13);
        assertEquals(49, testDeck.size());
    }
}
