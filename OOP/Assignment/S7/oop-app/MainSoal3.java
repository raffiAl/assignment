import java.util.ArrayList;
import java.util.Scanner;

public class MainSoal3 {
    public static void main(String[] args) {
        // Demonstrasi OOP: Membuat Class dan Object
        ArrayList<Barang> inventaris = new ArrayList<Barang>();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("█".repeat(50));
        System.out.println("   📦 APLIKASI MANAJEMEN INVENTARIS");
        System.out.println("█".repeat(50));

        // Tambah data default (Object)
        inventaris.add(new Barang("ELK001", "Mouse Logitech", 50, 150000));
        inventaris.add(new Barang("ELK002", "Keyboard Mechanical", 30, 450000));
        inventaris.add(new Barang("ELK003", "Monitor LED 24\"", 10, 1800000));

        do {
            System.out.println("\n─────────────────────────────────");
            System.out.println("MENU:");
            System.out.println("  1. Lihat Semua Barang");
            System.out.println("  2. Tambah Barang Baru (Object Baru)");
            System.out.println("  3. Tambah Stok Barang");
            System.out.println("  4. Cari Barang");
            System.out.println("  5. Keluar");
            System.out.println("─────────────────────────────────");
            System.out.print("Pilih menu (1-5): ");
            
            int pilihan = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (pilihan) {
                case 1:
                    System.out.println("\n📊 DAFTAR BARANG:");
                    if (inventaris.isEmpty()) {
                        System.out.println("   Inventaris kosong!");
                    } else {
                        for (int i = 0; i < inventaris.size(); i++) {
                            System.out.println("   " + (i + 1) + ". " + inventaris.get(i));
                        }
                    }
                    break;

                case 2:
                    System.out.println("\n➕ TAMBAH BARANG BARU:");
                    System.out.print("   Kode   : ");
                    String kode = scanner.nextLine();
                    System.out.print("   Nama   : ");
                    String nama = scanner.nextLine();
                    System.out.print("   Stok   : ");
                    int stok = scanner.nextInt();
                    System.out.print("   Harga  : ");
                    double harga = scanner.nextDouble();
                    
                    // INSTANSIASI OBJEK BARU
                    Barang barangBaru = new Barang(kode, nama, stok, harga);
                    inventaris.add(barangBaru);
                    System.out.println("   ✅ Barang berhasil ditambahkan!");
                    break;

                case 3:
                    System.out.println("\n📦 TAMBAH STOK:");
                    System.out.print("   Masukkan kode barang: ");
                    String kodeCari = scanner.nextLine();
                    boolean ditemukan = false;
                    
                    for (Barang b : inventaris) {
                        if (b.getKode().equalsIgnoreCase(kodeCari)) {
                            System.out.print("   Jumlah stok yang ditambah: ");
                            int tambah = scanner.nextInt();
                            b.tambahStok(tambah);
                            System.out.println("   ✅ Stok berhasil diupdate! Stok sekarang: " + b.getStok());
                            ditemukan = true;
                            break;
                        }
                    }
                    if (!ditemukan) System.out.println("   ❌ Barang dengan kode '" + kodeCari + "' tidak ditemukan!");
                    break;

                case 4:
                    System.out.println("\n🔍 CARI BARANG:");
                    System.out.print("   Masukkan nama/kode barang: ");
                    String keyword = scanner.nextLine().toLowerCase();
                    System.out.println("\n   Hasil pencarian:");
                    int count = 0;
                    for (Barang b : inventaris) {
                        if (b.getNama().toLowerCase().contains(keyword) || b.getKode().toLowerCase().contains(keyword)) {
                            System.out.println("   -> " + b);
                            count++;
                        }
                    }
                    if (count == 0) System.out.println("   Tidak ditemukan.");
                    break;

                case 5:
                    System.out.println("\n👋 Terima kasih!");
                    running = false;
                    break;

                default:
                    System.out.println("\n❌ Pilihan tidak valid!");
            }
        } while (running);

        scanner.close();
    }
}