package modelTest;

import model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// Tests for BlackJackTable tests
public class BlackJackTableTest {
    BlackJackTable table;
    @BeforeEach
    public void before() {
        table = new BlackJackTable();
    }

    @Test
    void testConstructor() {
        assertFalse(table.isOver());
        assertEquals(0, table.getBet());
        assertEquals(100, table.getFunds()); //might need to change in the future
    }

    @Test
    void testDealerStartHand() {
        table.dealerStartHand();
        assertEquals(1, table.getDealerHand().getCards().size());
        assertEquals(0, table.getPlayerHand().getCards().size());
    }

    @Test
    void testHit() {
        table.hit();
        table.hit();
        assertEquals(2, table.getPlayerHand().getCards().size());
        assertEquals(0, table.getDealerHand().getCards().size());
        assertFalse(table.isOver()); // Impossible to bust with 2 cards
    }

    @Test
    void testStand() {
        table.stand();
        assertNotEquals(0, table.getDealerHand().getTotal());
        assertTrue(table.isOver());
    }

    // Difficult to test with random cards being dealt
}
