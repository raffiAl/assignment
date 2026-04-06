// SUPER CLASS
class Produk {
    protected int harga;
    protected String nama;

    public Produk(String nama, int harga) {
        this.nama = nama;
        this.harga = harga;
    }

    public String tampilInfo() {
        return "[UMUM] " + nama + " | Harga: " + harga;
    }
}




