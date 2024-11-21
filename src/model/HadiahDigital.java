package model;

import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class HadiahDigital extends ProdukHadiah implements CRUD{
    private String tanggalExpired;

    public HadiahDigital(String namaProduk, int stok, int poinPenukaran, String tipe, String tanggalExpired) {
        super(namaProduk, stok, poinPenukaran, tipe);
        this.tanggalExpired = tanggalExpired;
    }

    public String getTanggalExpired() {
        return tanggalExpired;
    }

    public void setTanggalExpired(String tanggalExpired) {
        this.tanggalExpired = tanggalExpired;
    }

    @Override
    public void create() {
        try {
            String query = "INSERT INTO hadiah (id, nama_produk, stok, poin_penukaran, tipe, tanggal_expired, warna) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = Database.connection.prepareStatement(query);
            ps.setString(1, getIdItem());
            ps.setString(2, getNamaProduk());
            ps.setInt(3, getStok());
            ps.setInt(4, getPoinPenukaran());
            ps.setString(5, getTipe());
            ps.setString(6, tanggalExpired);
            ps.setString(7, "Tidak Ada");
            ps.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal menambah data!" + e.getMessage());
        }
    }

    @Override
    public void update(String id) {
        try {
            String query = "UPDATE hadiah SET nama_produk = ?, stok = ?, poin_penukaran = ?, tipe = ?, tanggal_expired = ?, warna = ? WHERE id = ?";
            PreparedStatement ps = Database.connection.prepareStatement(query);
            ps.setString(1, getNamaProduk());
            ps.setInt(2, getStok());
            ps.setInt(3, getPoinPenukaran());
            ps.setString(4, getTipe());
            ps.setString(5, getTanggalExpired());
            ps.setString(6, "Tidak ada");
            ps.setString(7, id);
            ps.executeUpdate();
            int rowAffected = ps.executeUpdate();
            if (rowAffected > 0) {
                JOptionPane.showMessageDialog(null, "Berhasil mengedit data!");
            }
        } catch (Exception e) {
        }
    }

    @Override
    public void delete(String id) {
        try {
            String query = "DELETE FROM hadiah WHERE id = ?";
            PreparedStatement ps = Database.connection.prepareStatement(query);
            ps.setString(1, id);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Berhasil menghapus data!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal menghapus data! " + e.getMessage());
        }
    }
    
    
}