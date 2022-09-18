package ro.hubs.ing.springbootproject.tests;

import org.junit.Test;
import ro.hubs.ing.springbootproject.classes.Product;
import ro.hubs.ing.springbootproject.exceptions.NegativePriceException;

import static org.junit.Assert.*;

public class ProductTests {
    @Test
    public void constructorWithParametersTest() {
        int id = 500;
        String name = "Fanta orange";
        double price = 6.99;
        int quantity = 80;

        Product product = new Product(id, name, price, quantity);

        assertEquals("The id is not correct initialized!", id, product.getId());
        assertEquals("The name is not correct initialized!", name, product.getName());
        assertEquals("The price is not correct initialized!", price, product.getPrice(), 0.001);
        assertEquals("The quantity is not correct initialized!", quantity, product.getQuantity());
    }

    @Test
    public void checkCalculateTotalValue() {
        Product product = new Product();

        product.setPrice(8.99);
        product.setQuantity(15);

        double result = 0;
        try {
            result = product.calculateTotalValue();
        } catch (NegativePriceException e) {
            fail(e.getMessage());
        }
        double actual = 134.85;

        assertEquals("The total value of the product is not calculated correctly!", actual, result, 0.001);
    }

    @Test
    public void checkIfProductHasName() throws NegativePriceException {
        Product product = new Product();

        product.setPrice(8.99);
        product.setQuantity(15);

        product.calculateTotalValue();

        assertEquals("The product doesn't have a name!", "Unknown product", product.getName());
    }

    @Test
    public void checkIfQuantityIsPositive() {
        Product product = new Product();
        product.setQuantity(-2);

        assertEquals("The product has a negative number for quantity!", 0, product.getQuantity());
    }

    @Test
    public void throwExceptionIfPriceIsNegative() {
        Product product = new Product(500, "some product", -28.9, 20);
        try {
            product.calculateTotalValue();
            fail("The method didn't throw an exception!");
        } catch (NegativePriceException e) {
            assertTrue("The method didn't throw an exception!", true);
        }
    }
}
