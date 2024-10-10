import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProductDatabase productDatabase = new ProductDatabase();
        UserDatabase userDatabase = new UserDatabase(); // Инициализация базы пользователей

        boolean running = true;

        while (running) {
            System.out.println("Welcome to our online store! Select an action from the menu below:");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Exit");

            int selectedAction = scanner.nextInt();

            if (selectedAction == 1) {
                System.out.print("To login please enter your email: ");
                String scEmail = scanner.next();
                System.out.print("And the password too: ");
                String scPswrd = scanner.next();

                User currentUser = userDatabase.findUser(scEmail, scPswrd);

                if (currentUser != null && currentUser.userLogin(scEmail, scPswrd)) {
                    Cart cart = new Cart();
                    boolean userRunning = true;

                    while (userRunning) {
                        System.out.println("This is your profile, select an action from the menu below:");
                        System.out.println("1. Show user info");
                        System.out.println("2. View Products");
                        System.out.println("3. Add to Cart");
                        System.out.println("4. View Cart");
                        System.out.println("5. Purchase Products");
                        System.out.println("6. View Purchased Products");
                        System.out.println("7. Exit");

                        int profileSelectedAction = scanner.nextInt();

                        switch (profileSelectedAction) {
                            case 1:
                                currentUser.showUserInfo();
                                break;
                            case 2:
                                List<Product> products = productDatabase.getProducts();
                                System.out.println("Available products:");
                                for (Product product : products) {
                                    System.out.println(product.getName() + " - $" + product.getPrice() + " (Available: " + product.getQuantity() + ")");
                                }
                                break;
                            case 3:
                                System.out.print("Enter the name of the product you want to add to the cart: ");
                                String productName = scanner.next();
                                Product product = productDatabase.getProductByName(productName);
                                if (product != null) {
                                    cart.addProduct(product);
                                } else {
                                    System.out.println("Product not found.");
                                }
                                break;
                            case 4:
                                cart.showCart();
                                break;
                            case 5:
                                cart.purchaseProducts(currentUser);
                                break;
                            case 6:
                                currentUser.showPurchasedProducts();
                                break;
                            case 7:
                                userRunning = false;
                                System.out.println("Thank you for visiting our store!");
                                break;
                            default:
                                System.out.println("Invalid option. Please try again.");
                        }
                    }
                }
            } else if (selectedAction == 2) {
                System.out.print("Enter your email: ");
                String email = scanner.next();
                System.out.print("Enter your password: ");
                String password = scanner.next();
                System.out.print("Enter your username: ");
                String username = scanner.next();
                System.out.print("Enter your name: ");
                String name = scanner.next();
                System.out.print("Enter your last name: ");
                String lastname = scanner.next();
                System.out.print("Enter your age: ");
                int age = scanner.nextInt();
                User newUser = new User(email, password, username, name, lastname, age, 0);
                userDatabase.registerUser(newUser);
            } else {
                running = false;
                System.out.println("Exiting the application.");
            }
        }

        scanner.close();
    }
}
