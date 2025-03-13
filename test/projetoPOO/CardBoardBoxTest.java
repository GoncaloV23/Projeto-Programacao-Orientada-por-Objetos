package projetoPOO;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */


import CustomExceptions.NoSpaceAvailablePackageException;
import CustomExceptions.UnsupportedPackageException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author franc
 */
public class CardBoardBoxTest {

    /**
     *
     */
    @Test
    public void testConstructorAndGetters() {
        CardBoardBox box = new CardBoardBox();

        // Verifica se a lista de produtos inicial está vazia
        assertTrue(box.getProducts().isEmpty());

        // Verifica se o tipo do pacote retornado é "CardBoardBox"
        assertEquals("CardBoardBox", box.getType());

        // Verifica se o peso inicial da caixa é 0
        assertEquals(0.0, box.getWeight(), 0.0001);
    }

    /**
     *
     */
    @Test
    public void testToString() {
        Product.Type type = Product.Type.SMALL_ELECTRONICS;
        Product product1 = new Product("Product 4", 4.0, type);
        Product product2 = new Product("Product 5", 5.0, type);

        CardBoardBox box = new CardBoardBox();
        try {
            box.addProduct(product1);
            box.addProduct(product2);
        } catch (UnsupportedPackageException | NoSpaceAvailablePackageException e) {
            e.getMessage();
        }

        // Verifica se a representação em string da caixa de papelão está correta
        String expectedString = "Package Code = C[" +
                "Product ID = " + product1.getId() + ", Name = Product 4, Weight = 4.0 Kg, Type = SMALL_ELECTRONICS, " +
                "Product ID = " + product2.getId() + ", Name = Product 5, Weight = 5.0 Kg, Type = SMALL_ELECTRONICS" +
                "]";
        assertEquals(expectedString, box.toString());
    }
}