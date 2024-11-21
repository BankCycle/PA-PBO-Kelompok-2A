package model;

import model.Database;
import com.sun.jdi.connect.spi.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.ResultSet;

public class HadiahFisik extends ProdukHadiah implements CRUD{
    private String warna;

    public HadiahFisik(String namaProduk, int stok, int poinPenukaran, String tipe, String warna) {
        super(namaProduk, stok, poinPenukaran, tipe);
        this.warna = warna;
    }

    public String getWarna() {
        return warna;
    }

    public void setWarna(String warna) {
        this.warna = warna;
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
            ps.setString(6, "Tidak ada");
            ps.setString(7, warna);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Berhasil menambah data!");
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
            ps.setString(5, "Tidak ada");
            ps.setString(6, getWarna());
            ps.setString(7, id);
            ps.executeUpdate();
            int rowAffected = ps.executeUpdate();
            if (rowAffected > 0) {
                JOptionPane.showMessageDialog(null, "Berhasil mengedit data!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
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
