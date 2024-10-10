import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Product, Integer> cartItems;

    public Cart() {
        this.cartItems = new HashMap<>();
    }

    public void addProduct(Product product) {
        cartItems.put(product, cartItems.getOrDefault(product, 0) + 1);
        System.out.println(product.getName() + " has been added to your cart.");
    }

    public void showCart() {
        System.out.println("Your cart items:");
        for (Map.Entry<Product, Integer> entry : cartItems.entrySet()) {
            System.out.println(entry.getKey().getName() + " (Quantity: " + entry.getValue() + ")");
        }
    }

    public void purchaseProducts(User user) {
        double totalPrice = 0.0;
        for (Map.Entry<Product, Integer> entry : cartItems.entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();

            // Проверяем, достаточно ли у пользователя баланса
            if (user.canAfford(product.getPrice() * quantity) && product.getQuantity() >= quantity) {
                user.purchaseProduct(product, quantity);
                product.decreaseQuantity(quantity); // Уменьшаем количество продукта в базе
                totalPrice += product.getPrice() * quantity;
            } else {
                System.out.println("Not enough balance or quantity to purchase " + product.getName());
            }
        }
        if (totalPrice > 0) {
            user.deductBalance(totalPrice);
            cartItems.clear(); // Очищаем корзину после покупки
            System.out.println("Purchase completed. Total cost: $" + totalPrice);
        }
    }
}
