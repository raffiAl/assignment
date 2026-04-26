public class BankBCA extends Bank {
    private static final double SUKU_BUNGA_BCA = 3.75;
    private static final double BIAYA_TRANSFER_BCA = 6500;
    private static final double BATAS_GRATIS = 100000; // Gratis jika < 100rb
    
    // Constructor
    public BankBCA(double saldo) {
        super("Bank BCA", saldo);
    }
    
    // ========== METHOD OVERRIDING ==========
    
    @Override
    public void showSukuBunga() {
        System.out.println("🏦 Bank BCA - Suku Bunga: " + SUKU_BUNGA_BCA + "% per tahun");
    }
    
    @Override
    public double getSukuBunga() {
        return SUKU_BUNGA_BCA;
    }
    
    @Override
    public double hitungBiayaTransfer(double jumlah) {
        // BCA: Gratis jika < 100rb, Rp 6.500 jika >= 100rb
        if (jumlah < BATAS_GRATIS) {
            return 0; // Gratis
        } else {
            return BIAYA_TRANSFER_BCA;
        }
    }
    
    // Method khusus BCA
    public void showInfoBCA() {
        System.out.println("\n" + "=".repeat(45));
        System.out.println("        📋 INFORMASI BANK BCA");
        System.out.println("=".repeat(45));
        showSukuBunga();
        System.out.println("💰 Biaya transfer: Gratis (< Rp 100rb) / Rp " + BIAYA_TRANSFER_BCA + " (>= Rp 100rb)");
        System.out.println("💵 Saldo saat ini: Rp " + getSaldo());
        System.out.println("=".repeat(45));
    }
}