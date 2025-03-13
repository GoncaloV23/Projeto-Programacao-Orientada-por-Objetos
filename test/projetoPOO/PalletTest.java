package projetoPOO;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author franc
 */
public class PalletTest {

    /**
     *
     */
    @Test
    public void testConstructorAndGetters() {
        Pallet pallet = new Pallet();

        // Verifica se o conjunto de caixas inicial está vazio
        assertTrue(pallet.getProduct().isEmpty());

        // Verifica se o tipo do pacote retornado é "Pallet"
        assertEquals("Pallet", pallet.getType());

        // Verifica se o peso inicial do pallet é 0
        assertEquals(0.0, pallet.getWeight(), 0.0001);
    }

    /**
     *
     */
    @Test
    public void testAddProduct() {
        Product.Type type = Product.Type.SMALL_ELECTRONICS;
        Product product1 = new Product("Product 6", 6.0, type);
        Product product2 = new Product("Product 7", 7.0, type);
        CardBoardBox box1 = new CardBoardBox(product1);
        CardBoardBox box2 = new CardBoardBox(product2);

        Pallet pallet = new Pallet();

        // Verifica se uma caixa de papelão pode ser adicionada ao pallet
        pallet.addProduct(box1);
        assertEquals(1, pallet.getProduct().size());
        assertTrue(pallet.getProduct().contains(box1));
        assertEquals(box1.getWeight(), pallet.getWeight(), 0.0001);

        // Verifica se uma segunda caixa de papelão pode ser adicionada ao pallet
        pallet.addProduct(box2);
        assertEquals(2, pallet.getProduct().size());
        assertTrue(pallet.getProduct().contains(box1));
        assertTrue(pallet.getProduct().contains(box2));
        assertEquals(box1.getWeight() + box2.getWeight(), pallet.getWeight(), 0.0001);
    }

    /**
     *
     */
    @Test
    public void testToString() {
        Product.Type type = Product.Type.SMALL_ELECTRONICS;
        Product product1 = new Product("Product 6", 6.0, type);
        Product product2 = new Product("Product 7", 7.0, type);
        CardBoardBox box1 = new CardBoardBox(product1);
        CardBoardBox box2 = new CardBoardBox(product2);

        Pallet pallet = new Pallet();
        pallet.addProduct(box1);
        pallet.addProduct(box2);

        // Verifica se a representação em string do pallet está correta
        String expectedString = "Package Code = Pa[" +
                "Package Code = C[Product ID = " + product1.getId() + ", Name = Product 6, Weight = 6.0 Kg, Type = SMALL_ELECTRONICS]," +
                " Package Code = C[Product ID = " + product2.getId() + ", Name = Product 7, Weight = 7.0 Kg, Type = SMALL_ELECTRONICS]" +
                "]";
        assertEquals(expectedString, pallet.toString());
    }
}
