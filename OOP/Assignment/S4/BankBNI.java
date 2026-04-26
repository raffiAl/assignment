public class BankBNI extends Bank {
    private static final double SUKU_BUNGA_BNI = 4.25;
    private static final double BIAYA_TRANSFER_BNI = 2500;
    
    // Constructor
    public BankBNI(double saldo) {
        super("Bank BNI", saldo);
    }
    
    // ========== METHOD OVERRIDING ==========
    
    @Override
    public void showSukuBunga() {
        System.out.println("🏦 Bank BNI - Suku Bunga: " + SUKU_BUNGA_BNI + "% per tahun");
    }
    
    @Override
    public double getSukuBunga() {
        return SUKU_BUNGA_BNI;
    }
    
    @Override
    public double hitungBiayaTransfer(double jumlah) {
        // BNI: Flat Rp 2.500 untuk semua nominal
        return BIAYA_TRANSFER_BNI;
    }
    
    // Method khusus BNI
    public void showInfoBNI() {
        System.out.println("\n" + "=".repeat(45));
        System.out.println("        📋 INFORMASI BANK BNI");
        System.out.println("=".repeat(45));
        showSukuBunga();
        System.out.println("💰 Biaya transfer: Rp " + BIAYA_TRANSFER_BNI + " (flat)");
        System.out.println("💵 Saldo saat ini: Rp " + getSaldo());
        System.out.println("=".repeat(45));
    }
}