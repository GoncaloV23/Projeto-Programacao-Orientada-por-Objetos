package projetoPOO;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import Vehicles.RollingCart;
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
public class RollingCartTest {

    /**
     *
     */
    @Test
    public void testConstructorAndGetters() {
        int x = 10;
        int y = 20;
        RollingCart cart = new RollingCart(x, y);

        // Verifica se as coordenadas foram atribuídas corretamente
        assertEquals(x, cart.getX());
        assertEquals(y, cart.getY());

        // Verifica se o código foi gerado corretamente
        String expectedCode = "RC-" + cart.hashCode();
        assertEquals(expectedCode, cart.getCode());

        // Verifica se a lista de embalagens foi inicializada corretamente
        assertNotNull(cart.getPackages());
        assertTrue(cart.getPackages().isEmpty());
    }

    /**
     *
     */
    @Test
    public void testAddPackage() {
        int x = 10;
        int y = 20;
        RollingCart cart = new RollingCart(x, y);

        // Criação de embalagens para teste
        Product.Type type1 = Product.Type.CLOTHING;
        Product.Type type2 = Product.Type.BOOKS;
        Product product1 = new Product("Product 1", 10.0, type1);
        Product product2 = new Product("Product 2", 20.0, type2);
        Package box1 = new Box(product1);
        Package bag1 = new Bag(product2);

        // Adiciona uma embalagem do tipo "Clothing" ao carrinho de transporte
        cart.addPackage(box1);
        assertEquals(1, cart.getPackages().size());
        assertTrue(cart.getPackages().contains(box1));

        // Adiciona uma embalagem do tipo "Books" ao carrinho de transporte
        cart.addPackage(bag1);
        assertEquals(2, cart.getPackages().size());
        assertTrue(cart.getPackages().contains(box1));
        assertTrue(cart.getPackages().contains(bag1));
    }

    /**
     *
     */
    @Test
    public void testRemovePackage() {
        int x = 10;
        int y = 20;
        RollingCart cart = new RollingCart(x, y);

        // Criação de embalagens para teste
        Product.Type type1 = Product.Type.CLOTHING;
        Product.Type type2 = Product.Type.BOOKS;
        Product product1 = new Product("Product 1", 10.0, type1);
        Product product2 = new Product("Product 2", 20.0, type2);
        Package box1 = new Box(product1);
        Package bag1 = new Bag(product2);

        // Adiciona as embalagens ao carrinho de transporte
        cart.addPackage(box1);
        cart.addPackage(bag1);

        // Verifica se as embalagens foram adicionadas corretamente
        assertEquals(2, cart.getPackages().size());
        assertTrue(cart.getPackages().contains(box1));
        assertTrue(cart.getPackages().contains(bag1));

        // Remove uma embalagem do carrinho de transporte
        cart.removeOnePackage(box1);

        // Verifica se a embalagem foi removida corretamente
        assertEquals(1, cart.getPackages().size());
        assertFalse(cart.getPackages().contains(box1));
        assertTrue(cart.getPackages().contains(bag1));
    }
}
