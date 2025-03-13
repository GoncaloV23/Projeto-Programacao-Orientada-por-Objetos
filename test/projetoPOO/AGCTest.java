package projetoPOO;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */



import Vehicles.AGC;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import projetoPOO.Product.Type;

/**
 *
 * @author Asus
 */
public class AGCTest {

    private AGC agc;
    private Box boxPackage;
    private Bag bagPackage;
    private Product prod1;
    private Product prod2;

    /**
     *
     */
    @BeforeEach
    public void setUp() {
        agc = new AGC(0, 0);
        prod1 = new Product("Book", 3, Type.BOOKS);
        prod1 = new Product("Little Toy", 2, Type.SMALL_TOYS);
        boxPackage = new Box(prod1);
        bagPackage = new Bag(prod2);
    }

    /**
     *
     */
    @Test
    public void testAddPackage() {
        agc.addPackage(boxPackage);
        assertEquals(1, agc.getPackages().size());
        assertEquals(boxPackage, agc.getPackages().get(0));
    }

    /**
     *
     */
    @Test
    public void testAddExceededWeightPackage() {
        agc.addPackage(boxPackage);
        agc.addPackage(bagPackage);
        assertEquals(1, agc.getPackages().size());
    }

    /**
     *
     */
    @Test
    public void testRemovePackage() {
        agc.addPackage(boxPackage);
        agc.removeOnePackage(boxPackage);
        assertEquals(0, agc.getPackages().size());
    }

    /**
     *
     */
    @Test
    public void testToString() {
        agc.addPackage(boxPackage);
        agc.addPackage(bagPackage);
        String expected = "AGC: [Package: Type=Box, Weight=10.0, Package: Type=Bag, Weight=20.0]";
        assertEquals(expected, agc.toString());
    }
}
