package projetoPOO;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author franc
 */
public class ProductTest {

    /**
     *
     */
    @Test
    public void testConstructorAndGetters() {
        Product.Type type = Product.Type.CLOTHING;
        Product product = new Product("Product 1", 1.0, type);

        // Verifica se os valores passados no construtor são retornados corretamente pelos getters
        assertEquals("Product 1", product.getName());
        assertEquals(1.0, product.getWeight(), 0.0001);
        assertEquals(type, product.getType());
    }

    /**
     *
     */
    @Test
    public void testSetters() {
        Product product = new Product("Product 2", 2.0, Product.Type.SMALL_TOYS);

        // Define novos valores para o nome, peso e tipo do produto
        product.setName("New Name");
        product.setWeight(3.0);
        product.setType(Product.Type.ACCESSORIES);

        // Verifica se os valores foram atualizados corretamente pelos setters
        assertEquals("New Name", product.getName());
        assertEquals(3.0, product.getWeight(), 0.0001);
        assertEquals(Product.Type.ACCESSORIES, product.getType());
    }

    /**
     *
     */
    @Test
    public void testHashCodeAndEquals() {
        Product product1 = new Product("Product 3", 1.0, Product.Type.SMALL_ELECTRONICS);
        Product product2 = new Product("Product 4", 2.0, Product.Type.SMALL_ELECTRONICS);
        Product product3 = new Product("Product 3", 1.0, Product.Type.SMALL_ELECTRONICS);

        // Verifica se o método hashCode retorna valores únicos para produtos com IDs diferentes
        assertNotEquals(product1.hashCode(), product2.hashCode());

        // Verifica se o método equals retorna true para produtos com o mesmo ID
        assertTrue(product1.equals(product3));

        // Verifica se o método equals retorna false para produtos com IDs diferentes
        assertFalse(product1.equals(product2));
    }

    /**
     *
     */
    @Test
    public void testToString() {
        Product product = new Product("Product 5", 5.0, Product.Type.BOOKS);

        // Verifica se a representação em string do produto está correta
        String expectedString = "Product ID = " + product.getId() +
                ", Name = Product 5" +
                ", Weight = 5.0 Kg" +
                ", Type = BOOKS\n";
        assertEquals(expectedString, product.toString());
    }
}
