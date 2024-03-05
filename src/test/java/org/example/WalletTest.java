package org.example;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class WalletTest {

    private static Wallet wallet;

    @BeforeAll
    static void initClass() {
        wallet = new Wallet("john", 15000, new ArrayList<>());
    }

    @BeforeEach
    void initMethod() {
        wallet.cash = 15000;
    }

    @Test
    void withdrawSufficient() {
        wallet.withdraw(2000);
        assertNotEquals(15000, wallet.cash);
        assertEquals(13000, wallet.cash);
    }

    @Test
    void withdrawInsufficient() {
        wallet.withdraw(20000);
        assertNotEquals(-5000, wallet.cash);
        assertEquals(15000, wallet.cash);
    }

    @Test
    void deposit() {
        wallet.deposit(10000);
        assertEquals(25000, wallet.cash);
        assertNotEquals(15000, wallet.cash);
    }

    @Test
    void addCard() {
        wallet.addCard("card1");
        wallet.addCard("card2");
        assertEquals(2, wallet.listCard.size());
        assertTrue(wallet.listCard.contains("card2"));
        assertFalse(wallet.listCard.contains("card0"));
    }

    @Test
    void removeCardSuccess() {
        wallet.addCard("card1");
        wallet.removeCard("card1");
        assertFalse(wallet.listCard.contains("card1"));
    }

    @Test
    void removeCardError() {
        wallet.addCard("card1");
        assertThrows(Error.class, () -> wallet.removeCard("card0"));
    }

    @AfterEach
    void cleanMethod() {
        wallet.listCard.clear();
    }
}