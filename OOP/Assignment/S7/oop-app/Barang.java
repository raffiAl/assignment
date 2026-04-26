// File: Barang.java
public class Barang {
    private String kode;
    private String nama;
    private int stok;
    private double harga;

    public Barang(String kode, String nama, int stok, double harga) {
        this.kode = kode;
        this.nama = nama;
        this.stok = stok;
        this.harga = harga;
    }

    public String getKode() { return kode; }
    public String getNama() { return nama; }
    public int getStok() { return stok; }
    public double getHarga() { return harga; }
    
    public void tambahStok(int jumlah) { this.stok += jumlah; }
    public void kurangiStok(int jumlah) { 
        if (this.stok >= jumlah) this.stok -= jumlah; 
        else System.out.println("Stok tidak mencukupi!");
    }

    @Override
    public String toString() {
        return kode + " | " + nama + " | Stok: " + stok + " | Rp " + String.format("%,.0f", harga);
    }
}