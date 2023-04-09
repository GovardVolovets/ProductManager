package ru.netology.product;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {

    @Test
    void shouldRemoveExistingProduct() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "Product 1", 100);
        Product product2 = new Product(2, "Product 2", 200);
        repo.add(product1);
        repo.add(product2);

        repo.remove(1);

        Product[] expected = new Product[]{product2};
        Assertions.assertArrayEquals(expected, repo.findAll());
    }

    @Test
    void shouldThrowNotFoundExceptionWhenRemovingNonExistingProduct() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "Product 1", 100);
        Product product2 = new Product(2, "Product 2", 200);
        repo.add(product1);
        repo.add(product2);

        Assertions.assertThrows(NotFoundException.class, () -> repo.remove(3));
    }

    @Test
    void shouldAddNewProduct() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "Product 1", 100);
        repo.add(product1);

        Product[] expected = new Product[]{product1};
        Assertions.assertArrayEquals(expected, repo.findAll());
    }

    @Test
    void shouldThrowAlreadyExistsExceptionWhenAddingProductWithDuplicateId() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "Product 1", 100);
        Product product2 = new Product(1, "Product 2", 200);
        repo.add(product1);

        Assertions.assertThrows(AlreadyExistsException.class, () -> repo.add(product2));
    }
}
