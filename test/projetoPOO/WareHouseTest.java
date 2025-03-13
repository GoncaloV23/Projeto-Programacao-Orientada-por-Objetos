package projetoPOO;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

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
public class WareHouseTest {

    /**
     *
     */
    @Test
    public void testCreateWareHouse() {
        WareHouse wareHouse = new WareHouse(50, 50);
        SlotInformation[][] slots = wareHouse.getSlotInformation();

        // Verificar se a matriz de slots foi criada corretamente
        assertNotNull(slots);
        assertEquals(50, slots.length);
        assertEquals(50, slots[0].length);

        // Verificar se os slots foram configurados corretamente
        for (int i = 0; i < slots.length; i++) {
            for (int j = 0; j < slots[0].length; j++) {
                SlotInformation slot = slots[i][j];

                if (i >= 11 && i < 37) {
                    if (j == 0) {
                        assertEquals(SlotInformation.Role.PICKUP, slot.getRole());
                        assertEquals(i + 1, slot.getHeight());
                        assertEquals(1, slot.getWidth());
                    } else if (j == 49) {
                        assertEquals(SlotInformation.Role.DELIVER, slot.getRole());
                        assertEquals(i + 1, slot.getHeight());
                        assertEquals(50, slot.getWidth());
                    } else {
                        assertEquals(SlotInformation.Role.FLOOR, slot.getRole());
                        assertEquals(i + 1, slot.getHeight());
                        assertEquals(j + 1, slot.getWidth());
                    }
                } else if (i == 0) {
                    assertEquals(SlotInformation.Role.STORAGE, slot.getRole());
                    assertEquals(1, slot.getHeight());
                    assertEquals(j + 1, slot.getWidth());
                } else if (i == 49) {
                    assertTrue(slot.isOccupied());
                } else {
                    assertEquals(SlotInformation.Role.FLOOR, slot.getRole());
                    assertEquals(i + 1, slot.getHeight());
                    assertEquals(j + 1, slot.getWidth());
                }
            }
        }
    }

    /**
     *
     */
    @Test
    public void testGetSlot() {
        WareHouse wareHouse = new WareHouse(50, 50);
        SlotInformation[][] slots = wareHouse.getSlotInformation();

        SlotInformation slot = wareHouse.getSlot(0, 0);
        assertEquals(slots[0][0], slot);

        slot = wareHouse.getSlot(24, 35);
        assertEquals(slots[24][35], slot);

        slot = wareHouse.getSlot(49, 49);
        assertEquals(slots[49][49], slot);
    }
}
