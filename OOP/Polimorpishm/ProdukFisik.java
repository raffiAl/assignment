// SUB CLASS 1
class ProdukFisik extends Produk {
    private double beratKg;

    public ProdukFisik(String nama, int harga, double beratKg) {
        super(nama, harga);
        this.beratKg = beratKg;
    }

    @Override
    public String tampilInfo() {
        return "[FISIK] " + nama + " | Harga: " + harga + " | Berat: " + beratKg + " kg";
    }
}