public class Bank {
    private String namaBank;
    private double saldo;
    
    // Constructor
    public Bank(String namaBank, double saldo) {
        this.namaBank = namaBank;
        this.saldo = saldo;
    }
    
    // Getter & Setter
    public String getNamaBank() { return namaBank; }
    public double getSaldo() { return saldo; }
    public void setSaldo(double saldo) { this.saldo = saldo; }
    
    // ========== METHOD OVERLOADING ==========
    
    // Versi 1: Transfer dengan nominal saja
    public void transferUang(double jumlah) {
        if (jumlah > 0 && jumlah <= saldo) {
            saldo -= jumlah;
            System.out.println("✅ Transfer berhasil: Rp " + jumlah);
            System.out.println("   Sisa saldo: Rp " + saldo);
        } else {
            System.out.println("❌ Transfer gagal! Saldo tidak mencukupi.");
        }
    }
    
    // Versi 2: Transfer dengan nominal + rekening tujuan
    public void transferUang(double jumlah, String rekeningTujuan) {
        if (jumlah > 0 && jumlah <= saldo) {
            saldo -= jumlah;
            System.out.println("✅ Transfer berhasil ke " + rekeningTujuan);
            System.out.println("   Jumlah: Rp " + jumlah);
            System.out.println("   Sisa saldo: Rp " + saldo);
        } else {
            System.out.println("❌ Transfer gagal ke " + rekeningTujuan + "! Saldo tidak mencukupi.");
        }
    }
    
    // Versi 3: Transfer dengan nominal + rekening tujuan + catatan
    public void transferUang(double jumlah, String rekeningTujuan, String catatan) {
        if (jumlah > 0 && jumlah <= saldo) {
            saldo -= jumlah;
            System.out.println("✅ Transfer berhasil ke " + rekeningTujuan);
            System.out.println("   Jumlah: Rp " + jumlah);
            System.out.println("   Catatan: " + catatan);
            System.out.println("   Sisa saldo: Rp " + saldo);
        } else {
            System.out.println("❌ Transfer gagal ke " + rekeningTujuan + "! Saldo tidak mencukupi.");
        }
    }
    
    // Versi 4: Transfer dengan nominal + rekening tujuan + nama penerima + catatan
    public void transferUang(double jumlah, String rekeningTujuan, String namaPenerima, String catatan) {
        if (jumlah > 0 && jumlah <= saldo) {
            saldo -= jumlah;
            System.out.println("✅ Transfer berhasil!");
            System.out.println("   Penerima: " + namaPenerima + " (" + rekeningTujuan + ")");
            System.out.println("   Jumlah: Rp " + jumlah);
            System.out.println("   Catatan: " + catatan);
            System.out.println("   Sisa saldo: Rp " + saldo);
        } else {
            System.out.println("❌ Transfer gagal! Saldo tidak mencukupi.");
        }
    }
    
    // ========== METHOD UNTUK OVERRIDING ==========
    
    // Method yang akan di-override oleh subclass
    public void showSukuBunga() {
        System.out.println("📖 Suku bunga standar bank: 3.5%");
    }
    
    public double getSukuBunga() {
        return 3.5;
    }
    
    // ========== BONUS CHALLENGE: BIAYA TRANSFER ==========
    
    // Method untuk menghitung biaya transfer (akan di-override)
    public double hitungBiayaTransfer(double jumlah) {
        return 2500; // Biaya standar
    }
    
    // Transfer dengan biaya admin
    public void transferDenganBiaya(double jumlah, String rekeningTujuan) {
        double biaya = hitungBiayaTransfer(jumlah);
        double total = jumlah + biaya;
        
        if (jumlah > 0 && total <= saldo) {
            saldo -= total;
            System.out.println("✅ Transfer berhasil ke " + rekeningTujuan);
            System.out.println("   Jumlah transfer: Rp " + jumlah);
            System.out.println("   Biaya admin: Rp " + biaya);
            System.out.println("   Total debet: Rp " + total);
            System.out.println("   Sisa saldo: Rp " + saldo);
        } else {
            System.out.println("❌ Transfer gagal! Saldo tidak mencukupi (termasuk biaya admin).");
        }
    }
    
    // Hitung bunga
    public double hitungBunga(double jumlah, int bulan) {
        return jumlah * (getSukuBunga() / 100 / 12) * bulan;
    }
}