package projetoPOO;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author franc
 */
public class SlotInformationTest {

    /**
     *
     */
    @Test
    public void testGetRole() {
        SlotInformation slot = new SlotInformation(SlotInformation.Role.FLOOR, 10, 5, true, false);
        SlotInformation.Role expectedRole = SlotInformation.Role.FLOOR;
        SlotInformation.Role actualRole = slot.getRole();
        assertEquals(expectedRole, actualRole);
    }

    /**
     *
     */
    @Test
    public void testGetHeight() {
        SlotInformation slot = new SlotInformation(SlotInformation.Role.PICKUP, 8, 6, false, true);
        int expectedHeight = 8;
        int actualHeight = slot.getHeight();
        assertEquals(expectedHeight, actualHeight);
    }

    /**
     *
     */
    @Test
    public void testGetWidth() {
        SlotInformation slot = new SlotInformation(SlotInformation.Role.STORAGE, 12, 7, true, true);
        int expectedWidth = 7;
        int actualWidth = slot.getWidth();
        assertEquals(expectedWidth, actualWidth);
    }

    /**
     *
     */
    @Test
    public void testSetHeight() {
        SlotInformation slot = new SlotInformation(SlotInformation.Role.DELIVER, 9, 5, false, false);
        int newHeight = 10;
        slot.setHeight(newHeight);
        int actualHeight = slot.getHeight();
        assertEquals(newHeight, actualHeight);
    }

    /**
     *
     */
    @Test
    public void testSetWidth() {
        SlotInformation slot = new SlotInformation(SlotInformation.Role.PICKUP, 8, 6, false, true);
        int newWidth = 7;
        slot.setWidth(newWidth);
        int actualWidth = slot.getWidth();
        assertEquals(newWidth, actualWidth);
    }

    /**
     *
     */
    @Test
    public void testIsOccupied() {
        SlotInformation slot = new SlotInformation(SlotInformation.Role.FLOOR, 10, 5, true, false);
        boolean expectedOccupied = true;
        boolean actualOccupied = slot.isOccupied();
        assertEquals(expectedOccupied, actualOccupied);
    }

    /**
     *
     */
    @Test
    public void testSetOccupied() {
        SlotInformation slot = new SlotInformation(SlotInformation.Role.STORAGE, 12, 7, true, true);
        boolean newOccupied = false;
        slot.setOccupied(newOccupied);
        boolean actualOccupied = slot.isOccupied();
        assertEquals(newOccupied, actualOccupied);
    }

    /**
     *
     */
    @Test
    public void testIsEmpty() {
        SlotInformation slot = new SlotInformation(SlotInformation.Role.DELIVER, 9, 5, false, false);
        boolean expectedEmpty = false;
        boolean actualEmpty = slot.isEmpty();
        assertEquals(expectedEmpty, actualEmpty);
    }

    /**
     *
     */
    @Test
    public void testSetEmpty() {
        SlotInformation slot = new SlotInformation(SlotInformation.Role.PICKUP, 8, 6, false, true);
        boolean newEmpty = false;
        slot.setEmpty(newEmpty);
        boolean actualEmpty = slot.isEmpty();
        assertEquals(newEmpty, actualEmpty);
    }

    /**
     *
     */
    @Test
    public void testToString() {
        SlotInformation slot = new SlotInformation(SlotInformation.Role.STORAGE, 12, 7, true, true);
        String expectedString = "Role: Storage\nDimensions: 12, 7\nIs Occupied: true\nIs Empty: true\n";
        String actualString = slot.toString();
        assertEquals(expectedString, actualString);
    }
}
