// CLASS KASIR (OVERLOADING)
class Kasir {
    // Overload 1: tanpa diskon
    public int hitungBayar(int harga, int qty) {
        return harga * qty;
    }

    // Overload 2: dengan diskon
    public int hitungBayar(int harga, int qty, double diskonPersen) {
        int total = harga * qty;
        return (int) (total - (total * diskonPersen / 100));
    }
}