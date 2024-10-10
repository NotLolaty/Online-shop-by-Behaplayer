import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class User {
    private String email;
    private String password;
    private String username;
    private String name;
    private String lastname;
    private int age;
    private double balance;
    private Map<Product, Integer> purchasedItems;

    public User(String email, String password, String username, String name, String lastname, int age, double balance) {
        this.email = email;
        this.password = password;
        this.username = username;
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.balance = balance;
        this.purchasedItems = new HashMap<>();
    }

    public boolean userLogin(String scEmail, String scPassword) {
        if (Objects.equals(scEmail, email) && Objects.equals(scPassword, password)) {
            System.out.println("Hello " + name + " " + lastname + ", how is it going?");
            return true;
        } else {
            System.out.println("Email or password aren't right!");
            return false;
        }
    }

    public void showUserInfo() {
        System.out.println("User Info for " + username);
        System.out.println("Email: " + email);
        System.out.println("Username: " + username);
        System.out.println("Name: " + name);
        System.out.println("Last Name: " + lastname);
        System.out.println("Age: " + age);
        System.out.println("Balance: $" + balance);
    }

    public void addBalance(double amount) {
        balance += amount;
        System.out.println("Your balance has been increased by $" + amount + ". New balance: $" + balance);
    }

    public boolean canAfford(double amount) {
        return balance >= amount;
    }

    public void deductBalance(double amount) {
        balance -= amount;
        System.out.println("Your balance has been decreased by $" + amount + ". Remaining balance: $" + balance);
    }

    public void purchaseProduct(Product product, int quantity) {
        purchasedItems.put(product, purchasedItems.getOrDefault(product, 0) + quantity);
    }

    public void showPurchasedProducts() {
        System.out.println("Purchased products for " + username + ":");
        for (Map.Entry<Product, Integer> entry : purchasedItems.entrySet()) {
            System.out.println(entry.getKey().getName() + " (Quantity: " + entry.getValue() + ")");
        }
    }

    // Getters
    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public int getAge() {
        return age;
    }
}
