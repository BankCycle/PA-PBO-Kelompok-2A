package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SetoranSampahModel {
    private int idSetoran;
    private String namaPenyetor;
    private double berat;
    private int poin;
    private String status;

    // Constructor
    public SetoranSampahModel() {}

    public SetoranSampahModel(int idSetoran, String namaPenyetor, double berat, int poin, String status) {
        this.idSetoran = idSetoran;
        this.namaPenyetor = namaPenyetor;
        this.berat = berat;
        this.poin = poin;
        this.status = status;
    }

    // Getters dan Setters
    public int getIdSetoran() {
        return idSetoran;
    }

    public void setIdSetoran(int idSetoran) {
        this.idSetoran = idSetoran;
    }

    public String getNamaPenyetor() {
        return namaPenyetor;
    }

    public void setNamaPenyetor(String namaPenyetor) {
        this.namaPenyetor = namaPenyetor;
    }

    public double getBerat() {
        return berat;
    }

    public void setBerat(double berat) {
        this.berat = berat;
    }

    public int getPoin() {
        return poin;
    }

    public void setPoin(int poin) {
        this.poin = poin;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Fetch all setoran sampah
    public static List<SetoranSampahModel> getAll() {
        List<SetoranSampahModel> list = new ArrayList<>();
        String query = "SELECT * FROM setoran_sampah";
        try (Connection conn = Database.connect(); PreparedStatement ps = conn.prepareStatement(query); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                list.add(new SetoranSampahModel(
                        rs.getInt("id_setoran"),
                        rs.getString("nama_penyetor"),
                        rs.getDouble("berat"),
                        rs.getInt("poin"),
                        rs.getString("status")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    // Ambil semua setoran berdasarkan nama penyetor
    public static List<SetoranSampahModel> getByNamaPenyetor(String namaPenyetor) {
        List<SetoranSampahModel> listSetoran = new ArrayList<>();
        String query = "SELECT * FROM setoran_sampah WHERE nama_penyetor = ?";
        try (Connection conn = Database.connect();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, namaPenyetor);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                SetoranSampahModel setoran = new SetoranSampahModel();
                setoran.setIdSetoran(rs.getInt("id_setoran"));
                setoran.setBerat(rs.getDouble("berat"));
                setoran.setPoin(rs.getInt("poin")); 
                setoran.setStatus(rs.getString("status"));
                listSetoran.add(setoran);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listSetoran;
    }

    // Update status setoran sampah
    public static boolean updateStatus(int idSetoran, String status) {
        String query = "UPDATE setoran_sampah SET status = ? WHERE id_setoran = ?";
        try (Connection conn = Database.connect(); PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, status);
            ps.setInt(2, idSetoran);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static boolean deleteSetoran(int idSetoran) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Database.connect();
            
            String query = "DELETE FROM setoran_sampah WHERE id_setoran = ?";
            ps = conn.prepareStatement(query);
            ps.setInt(1, idSetoran);
            
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            Database.disconnect();
        }
    }
    
    // Tambah data setoran baru
    public static boolean insertSetoran(String namaPenyetor, double berat, int poin) {
        String query = "INSERT INTO setoran_sampah (nama_penyetor, berat, poin, status) VALUES (?, ?, ?, ?)";
        try (Connection conn = Database.connect(); PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, namaPenyetor);
            ps.setDouble(2, berat);
            ps.setInt(3, poin);
            ps.setString(4, "Menunggu");
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean updateUserPoin(String namaPenyetor, int poin) {
        String query = "UPDATE users SET Poin = Poin + ? WHERE Username = ?";
        try (Connection conn = Database.connect();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, poin);
            stmt.setString(2, namaPenyetor);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
