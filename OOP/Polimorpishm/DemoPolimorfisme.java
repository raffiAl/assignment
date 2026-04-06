// PROGRAM UTAMA
public class DemoPolimorfisme {
    public static void main(String[] args) {
        System.out.println("=== DEMO OVERRIDING ===");
        System.out.println("Menampil tampilInfo() dari masing-masipg objek:\n");

        Produk p1 = new Produk("Kaos Polos", 85000);
        ProdukFisik p2 = new ProdukFisik("Sepatu Lari", 350000, 0.8);
        ProdukDigital p3 = new ProdukDigital("Microsoft 365", 680000, "1 Tahun");

        System.out.println(p1.tampilInfo());
        System.out.println(p2.tampilInfo());
        System.out.println(p3.tampilInfo());

        System.out.println("\n=== DEMO OVERLOADING ===");
        System.out.println("Menampil hitungBayar() dengan argumen berbeda:\n");

        Kasir kasir = new Kasir();

        int total1 = kasir.hitungBayar(50000, 2);
        int total2 = kasir.hitungBayar(50000, 2, 15);

        System.out.println("hitungBayar(50000, 2) = " + total1);
        System.out.println("hitungBayar(50000, 2, 15) = " + total2);
    }
}