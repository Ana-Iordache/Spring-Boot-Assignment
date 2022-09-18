package ro.hubs.ing.springbootproject.classes;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {
    private List<Product> products = new ArrayList<>(Arrays.asList(
            new Product(100, "Boromir bread", 8.99, 50),
            new Product(200, "Milka dark chocolate", 6.60, 78),
            new Product(300, "Oreo biscuits", 5.8, 20)
    ));

    public List<Product> getAllProducts() {
        return products;
    }

    public Product getProduct(int id) {
        return products.stream().filter(product -> product.getId() == id).findAny().orElse(null);
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void updateProduct(int id, Product newProduct) {
        if (newProduct != null) {
            Product product = products.stream().filter(p -> p.getId() == id).findAny().orElse(null);
            if (product != null) {
                product.setId(newProduct.getId());
                product.setName(newProduct.getName());
                product.setQuantity(newProduct.getQuantity());
                product.setPrice(newProduct.getPrice());
            }
        }
    }

    public void deleteProduct(int id) {
        products.removeIf(product -> product.getId() == id);
    }
}
