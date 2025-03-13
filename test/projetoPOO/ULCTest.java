package projetoPOO;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */


import Vehicles.ULC;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author franc
 */
public class ULCTest {

    /**
     *
     */
    @Test
    public void testConstructorWithoutPallet() {
        ULC ulc = new ULC(1, 2);

        assertEquals(1, ulc.getX());
        assertEquals(2, ulc.getY());
        assertNull(ulc.getProduct());
    }

    /**
     *
     */
    @Test
    public void testConstructorWithPallet() {
        Pallet pallet = new Pallet();
        ULC ulc = new ULC(pallet, 3, 4);

        assertEquals(3, ulc.getX());
        assertEquals(4, ulc.getY());
        assertEquals(pallet, ulc.getProduct());
    }

    /**
     *
     */
    @Test
    public void testSetProduct() {
        Pallet pallet1 = new Pallet();
        Pallet pallet2 = new Pallet();

        ULC ulc = new ULC(pallet1, 1, 2);
        assertEquals(pallet1, ulc.getProduct());

        ulc.addPackage(pallet2);
        assertEquals(pallet2, ulc.getProduct());
    }

    /**
     *
     */
    @Test
    public void testToString() {
        Pallet pallet = new Pallet();
        pallet.addProduct(new CardBoardBox());
        pallet.addProduct(new CardBoardBox());

        ULC ulc = new ULC(pallet, 3, 4);

        String expected = "Type: ULC\n"
                        + "Coordinates: (3, 4)\n"
                        + "Product: " + pallet.toString();

        assertEquals(expected, ulc.toString());
    }
}
