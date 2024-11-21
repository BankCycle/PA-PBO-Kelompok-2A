package model;

import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class User {
    final private String namaLengkap;
    final private String username;
    final private String email;
    final private String password;
    final private String role;
    private int poin;

    public User(String namaLengkap, String username, String email, String password) {
        this.namaLengkap = namaLengkap;
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = "user";
        this.poin = 0;
    }

    public String getNamaLengkap() {
        return namaLengkap;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }
    
        public int getPoin() {
        return poin;
    }

    public void tambahPoin(int tambahan) {
        this.poin += tambahan;
    }

    public void updatePoinToDatabase() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = Database.connect(); 
            String query = "UPDATE users SET poin = ? WHERE username = ?";
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, this.poin);
            pstmt.setString(2, this.username);
            pstmt.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal memperbarui poin! " + e.getMessage());
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close(); 
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public final void createUser(){
        try {
            String query = "INSERT INTO users (Nama_Lengkap, Username, Email, Password, Role) VALUES(?,?,?,?,?)";
            Database.preparedStatement = Database.connection.prepareStatement(query);
            Database.preparedStatement.setString(1, this.getNamaLengkap());
            Database.preparedStatement.setString(2, this.getUsername());
            Database.preparedStatement.setString(3, this.getEmail());
            Database.preparedStatement.setString(4, this.getPassword());
            Database.preparedStatement.setString(5, this.getRole());
            Database.preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Berhasil menambah user!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal menambah user!" + e.getMessage());
        } 
    }
    
    public static final String login(String username, String password) {
        try {
            String query = "SELECT * FROM users WHERE username = ? AND password = ?";
            Database.preparedStatement = Database.connection.prepareStatement(query);
            Database.preparedStatement.setString(1, username);
            Database.preparedStatement.setString(2, password);
            Database.resultSet = Database.preparedStatement.executeQuery();

            if (Database.resultSet.next()) {
                // Ambil data user dari database
                String namaLengkap = Database.resultSet.getString("Nama_Lengkap");
                String email = Database.resultSet.getString("Email");
                String role = Database.resultSet.getString("Role");
                int poin = Database.resultSet.getInt("poin");

                User user = new User(namaLengkap, username, email, password);
                user.tambahPoin(poin);

                // Simpan user ke dalam session
                Session.getInstance().setCurrentUser(user);

                JOptionPane.showMessageDialog(null, "Login Berhasil!");
                return role;
            } else {
                JOptionPane.showMessageDialog(null, "Username atau Password salah.");
                return null;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Login Gagal! " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}
