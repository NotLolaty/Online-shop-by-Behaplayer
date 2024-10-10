import java.util.ArrayList;
import java.util.List;

public class ProductDatabase {
    private List<Product> products;

    public ProductDatabase() {
        products = new ArrayList<>();
        initializeProducts();
    }

    private void initializeProducts() {
        products.add(new Product("Laptop", 999.99, 10));
        products.add(new Product("Smartphone", 499.99, 15));
        products.add(new Product("Headphones", 199.99, 20));
        products.add(new Product("Smartwatch", 299.99, 5));
        products.add(new Product("Tablet", 399.99, 7));
    }

    public List<Product> getProducts() {
        return products;
    }

    public Product getProductByName(String name) {
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(name)) {
                return product;
            }
        }
        return null;
    }
}
