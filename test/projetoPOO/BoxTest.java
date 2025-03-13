package projetoPOO;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */


import CustomExceptions.UnsupportedPackageException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import projetoPOO.Product.Type;

/**
 *
 * @author franc
 */
public class BoxTest {

    /**
     *
     */
    @Test
    public void testConstructorAndGetters() {
        Product.Type type = Product.Type.SMALL_TOYS;
        Product product = new Product("Product 1", 1.0, type);
        Box box = new Box(product);

        // Verifica se o produto passado no construtor é retornado corretamente pelo getter
        assertEquals(product, box.getProduct());

        // Verifica se o tipo do pacote retornado é "Box"
        assertEquals("Box", box.getType());

        // Verifica se o peso da caixa é igual ao peso do produto
        assertEquals(product.getWeight(), box.getWeight(), 0.0001);
    }

    /**
     *
     */
    @Test
    public void testCheckProduct() {
        // Cria produtos adequados e inadequados para serem armazenados na caixa
        Product product1 = new Product("Product 2", 2.0, Product.Type.CLOTHING);
        Product product2 = new Product("Product 3", 3.0, Product.Type.SMALL_TOYS);
        Product product3 = new Product("Product 4", 4.0, Product.Type.LARGE_TOYS);

        // Verifica se uma exceção UnsupportedPackageException é lançada para produtos inadequados
        assertThrows(UnsupportedPackageException.class, () -> new Box(product1));
        assertThrows(UnsupportedPackageException.class, () -> new Box(product2));
        assertThrows(UnsupportedPackageException.class, () -> new Box(product3));
    }

    /**
     *
     */
    @Test
    public void testToString() {
        Product product = new Product("Product 5", 5.0, Product.Type.ACCESSORIES);
        Box box = new Box(product);

        // Verifica se a representação em string da caixa está correta
        String expectedString = "Package Code = Bo\nProduct ID = " + product.getId() +
                ", Name = Product 5" +
                ", Weight = 5.0 Kg" +
                ", Type = ACCESSORIES\n";
        assertEquals(expectedString, box.toString());
    }
}
