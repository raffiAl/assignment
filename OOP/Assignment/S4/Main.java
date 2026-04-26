public class Main {
    public static void main(String[] args) {
        
        // ========================================
        // BAGIAN 1: METHOD OVERLOADING
        // ========================================
        System.out.println("\n" + "█".repeat(50));
        System.out.println("   PART 1: METHOD OVERLOADING");
        System.out.println("█".repeat(50));
        
        Bank bank = new Bank("Bank Umum", 5000000);
        
        System.out.println("\n💰 Saldo awal: Rp " + bank.getSaldo());
        System.out.println("\n--- Versi 1: Transfer nominal saja ---");
        bank.transferUang(500000);
        
        System.out.println("\n--- Versi 2: Transfer + rekening tujuan ---");
        bank.transferUang(300000, "1234567890");
        
        System.out.println("\n--- Versi 3: Transfer + rekening + catatan ---");
        bank.transferUang(200000, "0987654321", "Bayar utang");
        
        System.out.println("\n--- Versi 4: Transfer + rekening + nama + catatan ---");
        bank.transferUang(100000, "1122334455", "Budi Santoso", "Cicilan bulan ini");
        
        // ========================================
        // BAGIAN 2: METHOD OVERRIDING
        // ========================================
        System.out.println("\n\n" + "█".repeat(50));
        System.out.println("   PART 2: METHOD OVERRIDING");
        System.out.println("█".repeat(50));
        
        BankBNI bni = new BankBNI(10000000);
        BankBCA bca = new BankBCA(8000000);
        
        // Polymorphism - menggunakan reference Bank
        Bank[] banks = {bni, bca};
        
        System.out.println("\n--- Menampilkan Suku Bunga (Overriding) ---");
        for (Bank b : banks) {
            b.showSukuBunga();
        }
        
        // ========================================
        // BAGIAN 3: BONUS CHALLENGE - BIAYA TRANSFER
        // ========================================
        System.out.println("\n\n" + "█".repeat(50));
        System.out.println("   PART 3: BONUS CHALLENGE - BIAYA TRANSFER");
        System.out.println("█".repeat(50));
        
        bni.showInfoBNI();
        System.out.println("\n📊 Perbandingan biaya transfer BNI:");
        System.out.println("   Transfer Rp 50.000  → Biaya: Rp " + bni.hitungBiayaTransfer(50000));
        System.out.println("   Transfer Rp 500.000 → Biaya: Rp " + bni.hitungBiayaTransfer(500000));
        System.out.println("   Transfer Rp 5.000.000 → Biaya: Rp " + bni.hitungBiayaTransfer(5000000));
        
        bca.showInfoBCA();
        System.out.println("\n📊 Perbandingan biaya transfer BCA:");
        System.out.println("   Transfer Rp 50.000  → Biaya: Rp " + bca.hitungBiayaTransfer(50000));
        System.out.println("   Transfer Rp 99.999  → Biaya: Rp " + bca.hitungBiayaTransfer(99999));
        System.out.println("   Transfer Rp 100.000 → Biaya: Rp " + bca.hitungBiayaTransfer(100000));
        System.out.println("   Transfer Rp 500.000 → Biaya: Rp " + bca.hitungBiayaTransfer(500000));
        
        // Demo transfer dengan biaya
        System.out.println("\n--- Demo Transfer dengan Biaya ---");
        System.out.println("\n🏦 Transfer via BNI:");
        bni.transferDenganBiaya(1000000, "0012345678");
        
        System.out.println("\n🏦 Transfer via BCA (< 100rb, gratis):");
        bca.transferDenganBiaya(50000, "0087654321");
        
        System.out.println("\n🏦 Transfer via BCA (>= 100rb, berbayar):");
        bca.transferDenganBiaya(500000, "0098765432");
        
        // ========================================
        // BAGIAN 4: PERHITUNGAN BUNGA
        // ========================================
        System.out.println("\n\n" + "█".repeat(50));
        System.out.println("   PART 4: PERHITUNGAN BUNGA");
        System.out.println("█".repeat(50));
        
        double deposito = 10000000;
        int bulan = 12;
        
        System.out.println("\n📊 Simulasi deposito Rp " + deposito + " selama " + bulan + " bulan:");
        System.out.println("   BNI: Bunga = Rp " + String.format("%,.2f", bni.hitungBunga(deposito, bulan)));
        System.out.println("   BCA: Bunga = Rp " + String.format("%,.2f", bca.hitungBunga(deposito, bulan)));
        
        System.out.println("\n" + "=".repeat(50));
        System.out.println("   ✅ SEMUA TUGAS SELESAI!");
        System.out.println("=".repeat(50));
    }
}