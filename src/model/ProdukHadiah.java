package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

public abstract class ProdukHadiah {
    private final String idItem;
    private String namaProduk;
    private int stok;
    private int poinPenukaran;
    private String tipe;

    public ProdukHadiah(String namaProduk, int stok, int poinPenukaran, String tipe) {
        this.idItem = generateID();
        this.namaProduk = namaProduk;
        this.stok = stok;
        this.poinPenukaran = poinPenukaran;
        this.tipe = tipe;
    }
    
    private String generateID(){
        String item = "ITM";
        Random random = new Random();
        int randomNumber = 100 + random.nextInt(900);
        return item+randomNumber;
    }
    
    public String getIdItem() {
        return idItem;
    }
    
    public String getNamaProduk() {
        return namaProduk;
    }

    public void setNamaProduk(String namaProduk) {
        this.namaProduk = namaProduk;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public int getPoinPenukaran() {
        return poinPenukaran;
    }

    public void setPoinPenukaran(int poinPenukaran) {
        this.poinPenukaran = poinPenukaran;
    }

    public String getTipe() {
        return tipe;
    }

    public void setTipe(String tipe) {
        this.tipe = tipe;
    }
    

    
}
