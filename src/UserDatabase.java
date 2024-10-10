import java.util.ArrayList;
import java.util.List;

public class UserDatabase {
    private List<User> users;

    public UserDatabase() {
        users = new ArrayList<>();
        initializeUsers();
    }

    private void initializeUsers() {
        users.add(new User("bmutalov90@gmail.com", "beh123mut1195", "Behaplayer", "Behruz", "Mutalov", 15, 1000.0));
        users.add(new User("user2@example.com", "password123", "UserTwo", "User", "Two", 20, 500.0));
    }

    public void registerUser(User user) {
        users.add(user);
        System.out.println("User registered successfully!");
    }

    public User findUser(String email, String password) {
        for (User user : users) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }
}
