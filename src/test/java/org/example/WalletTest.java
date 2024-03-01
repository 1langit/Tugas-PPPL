package org.example;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class WalletTest {

    /**
     *  Method untuk melakukan test pada wthdraw() jika cash masih cukup
     *  Membuat objek wallet dan menarik cash menggunakan method withdraw
     *  Expected result untuk method ini yaitu jumlah cash akan berkurang
     *  Menggunakan assertEqual dan assertNotEqual untuk mengecek apakah cash dalam wallet akan berkurang atau tidak
     */
    @Test
    void withdrawSufficient() {
        Wallet wallet = new Wallet("john", 15000, new ArrayList<>());
        wallet.withdraw(2000);
        assertNotEquals(15000, wallet.cash);
        assertEquals(13000, wallet.cash);
    }

    /**
     *  Method untuk melakukan test pada wthdraw() jika cash tidak cukup
     *  Membuat objek wallet dan menarik cash menggunakan method withdraw
     *  Expected result untuk method ini yaitu jumlah cash tidak akan berkurang
     *  Menggunakan assertEqual dan assertNotEqual untuk mengecek apakah cash dalam wallet akan berkurang atau tidak
     */
    @Test
    void withdrawInsufficient() {
        Wallet wallet = new Wallet("john", 15000, new ArrayList<>());
        wallet.withdraw(20000);
        assertNotEquals(-5000, wallet.cash);
        assertEquals(15000, wallet.cash);
    }

    /**
     *  Method untuk melakukan test pada deposit()
     *  Membuat objek wallet dan menambah cash menggunakan method deposit
     *  Expected result untuk method ini yaitu jumlah cash akan bertambah
     *  Menggunakan assertEqual dan assertNotEqual untuk mengecek apakah jumlah cash dalam wallet telah bertambah atau tidak
     */
    @Test
    void deposit() {
        Wallet wallet = new Wallet("john", 15000, new ArrayList<>());
        wallet.deposit(10000);
        assertEquals(25000, wallet.cash);
        assertNotEquals(15000, wallet.cash);
    }

    /**
     *  Method untuk melakukan test pada addCard()
     *  Membuat objek wallet dan menambah card menggunakan method addCard
     *  Expected result untuk method ini yaitu card dalam listCard akan bertambah dengan card yang ditambahkan
     *  Menggunakan assertEquals untuk mengecek apakah banyaknya card dalam listCard telah bertambah
     *  Menggunakan assertTrue untuk mengecek apakah kartu yang telah ditambah ada dalam list
     *  Menggunakan assertFalse untuk mengecek apakah kartu yang tidak ditambah ada dalam list
     */
    @Test
    void addCard() {
        Wallet wallet = new Wallet("john", 15000, new ArrayList<>());
        wallet.addCard("card1");
        wallet.addCard("card2");
        assertEquals(2, wallet.listCard.size());
        assertTrue(wallet.listCard.contains("card2"));
        assertFalse(wallet.listCard.contains("card0"));
    }

    /**
     *  Method untuk melakukan test pada removeCard() jika card tersebut ada
     *  Membuat objek wallet dan menghapus card yang telah ditambah menggunakan method removeCard
     *  Expected result untuk method ini yaitu card akan berhasil dihapus
     *  Menggunakan assertFalse untuk mengecek apakah kartu yang telah dihapus tidak ada dalam listCard
     */
    @Test
    void removeCardSuccess() {
        Wallet wallet = new Wallet("john", 15000, new ArrayList<>());
        wallet.addCard("card1");
        wallet.removeCard("card1");
        assertFalse(wallet.listCard.contains("card1"));
    }

    /**
     *  Method untuk melakukan test pada removeCard() jika card tersebut tidak ada
     *  Membuat objek wallet dan menghapus card yang belum ada menggunakan method removeCard
     *  Expected result untuk method ini yaitu mengeluarkan error karena card tidak ada
     *  Menggunakan assertThrows untuk mengecek apakah menambahkan kartu akan gagal dan mengeluarkan error
     */
    @Test
    void removeCardError() {
        Wallet wallet = new Wallet("john", 15000, new ArrayList<>());
        wallet.addCard("card1");
        assertThrows(Error.class, () -> wallet.removeCard("card0"));
    }
}