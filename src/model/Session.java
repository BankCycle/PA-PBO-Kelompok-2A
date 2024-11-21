package model;

public class Session {
    private static Session instance = null;
    private User currentUser;
    
    private Session() {
    }
    
    // Mengembalikan instance tunggal
    public static Session getInstance() {
        if (instance == null) {
            instance = new Session();
        }
        return instance;
    }
    
    // Setter dan Getter untuk user
    public void setCurrentUser(User user) {
        this.currentUser = user;
    }
    
    public User getCurrentUser() {
        return currentUser;
    }
    
    // Mengecek apakah ada user yang login
    public boolean isLoggedIn() {
        return currentUser != null;
    }
    
    // Logout dengan menghapus data user
    public void logout() {
        currentUser = null;
    }
}
