// SUB CLASS 2
class ProdukDigital extends Produk {
    private String masaAktif;

    public ProdukDigital(String nama, int harga, String masaAktif) {
        super(nama, harga);
        this.masaAktif = masaAktif;
    }

    @Override
    public String tampilInfo() {
        return "[DIGITAL] " + nama + " | Harga: " + harga + " | Masa Aktif: " + masaAktif;
    }
}