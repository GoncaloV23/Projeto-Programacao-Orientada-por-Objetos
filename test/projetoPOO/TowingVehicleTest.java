package projetoPOO;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */


import Vehicles.TowingVehicle;
import Vehicles.RollingCart;
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
public class TowingVehicleTest {

    /**
     *
     */
    @Test
    public void testConstructorWithCoordinates() {
        TowingVehicle towingVehicle = new TowingVehicle(5, 10);
        int expectedX = 5;
        int expectedY = 10;
        int actualX = towingVehicle.getX();
        int actualY = towingVehicle.getY();
        assertEquals(expectedX, actualX);
        assertEquals(expectedY, actualY);
    }

    /**
     *
     */
    @Test
    public void testConstructorWithRollingCart() {
        RollingCart rollingCart = new RollingCart(3,8);
        TowingVehicle towingVehicle = new TowingVehicle(rollingCart, 3, 8);
        int expectedX = 3;
        int expectedY = 8;
        int actualX = towingVehicle.getX();
        int actualY = towingVehicle.getY();
        assertEquals(expectedX, actualX);
        assertEquals(expectedY, actualY);
        assertEquals(rollingCart, towingVehicle.getRollingCart());
    }

    /**
     *
     */
    @Test
    public void testAddTransportCart() {
        TowingVehicle towingVehicle = new TowingVehicle(2, 4);
        RollingCart rollingCart = new RollingCart(2,4);
        towingVehicle.addTransportCart(rollingCart);
        assertEquals(rollingCart, towingVehicle.getRollingCart());
    }

    /**
     *
     */
    @Test
    public void testRemoveTransportCart() {
        TowingVehicle towingVehicle = new TowingVehicle(7, 9);
        RollingCart rollingCart = new RollingCart(7,9);
        towingVehicle.addTransportCart(rollingCart);
        towingVehicle.removeTransportCart();
        assertNull(towingVehicle.getRollingCart());
    }

    /**
     *
     */
    @Test
    public void testToString() {
        TowingVehicle towingVehicle = new TowingVehicle(1, 1);
        String expectedString = "Type: TWV\nCoordinates: (1, 1)\nRollingCart: null";
        String actualString = towingVehicle.toString();
        assertEquals(expectedString, actualString);
    }
}