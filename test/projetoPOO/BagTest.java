package projetoPOO;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import CustomExceptions.UnsupportedPackageException;
import projetoPOO.Product.Type;

/**
 *
 * @author franc
 */
public class BagTest {

    /**
     *
     */
    @Test
    public void testCheckProduct_UnsupportedProduct() {
        Product.Type type = Product.Type.BOOKS;
        Product product = new Product("Product 1", 1.0, type);
        Bag bag = new Bag(null);

        // Verifica se a exceção UnsupportedPackageException é lançada ao adicionar um produto não suportado
        UnsupportedPackageException exception = assertThrows(UnsupportedPackageException.class, () -> bag.checkProduct(product));
        assertEquals("O saco não suporta esse produto", exception.getMessage());
    }

    /**
     *
     */
    @Test
    public void testGetType() {
        Product.Type type = Product.Type.CLOTHING;
        Product product = new Product("Product 1", 1.0, type);
        Bag bag = new Bag(product);

        // Verifica se o tipo do saco é retornado corretamente
        assertEquals("Bag", bag.getType());
    }

    /**
     *
     */
    @Test
    public void testGetWeight() {
        Product.Type type = Product.Type.CLOTHING;
        Product product = new Product("Product 1", 1.0, type);
        Bag bag = new Bag(product);

        // Verifica se o peso do saco é retornado corretamente
        assertEquals(4.0, bag.getWeight(), 0.0001);
    }

    /**
     *
     */
    @Test
    public void testGetProduct() {
        Product.Type type = Product.Type.CLOTHING;
        Product product = new Product("Product 1", 1.0, type);
        Bag bag = new Bag(product);

        // Verifica se o produto contido no saco é retornado corretamente
        assertEquals(product, bag.getProduct());
    }

    /**
     *
     */
    @Test
    public void testToString() {
        Product.Type type = Product.Type.CLOTHING;
        Product product = new Product("Product 1", 1.0, type);
        Bag bag = new Bag(product);

        // Verifica se a representação em string do saco está correta
        String expectedString = "Package Type: Bag, Product: " + product.toString();
        assertEquals(expectedString, bag.toString());
    }
}
