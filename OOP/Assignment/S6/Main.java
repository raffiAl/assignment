import java.util.Scanner;
import electronic.Lenovo;
import electronic.Toshiba;
import electronic.MacBook;
import electronic.Laptop;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // ========================================
        // PILIH LAPTOP
        // ========================================
        System.out.println("█".repeat(50));
        System.out.println("   🖥️  LAPTOP CONTROLLER SIMULATOR");
        System.out.println("█".repeat(50));
        System.out.println("\nPilih Laptop:");
        System.out.println("  1. Lenovo");
        System.out.println("  2. Toshiba");
        System.out.println("  3. MacBook");
        System.out.print("\nMasukkan pilihan (1-3): ");
        
        int pilihan = scanner.nextInt();
        Laptop laptop = null;
        
        switch (pilihan) {
            case 1:
                laptop = new Lenovo();
                System.out.println("\n✅ Laptop terpilih: LENOVO");
                break;
            case 2:
                laptop = new Toshiba();
                System.out.println("\n✅ Laptop terpilih: TOSHIBA");
                break;
            case 3:
                laptop = new MacBook();
                System.out.println("\n✅ Laptop terpilih: MACBOOK");
                break;
            default:
                System.out.println("\n❌ Pilihan tidak valid! Program berhenti.");
                scanner.close();
                return;
        }
        
        // Buat LaptopUser
        LaptopUser user = new LaptopUser(laptop);
        
        // ========================================
        // MENU UTAMA
        // ========================================
        String command;
        boolean running = true;
        
        System.out.println("\n" + "─".repeat(50));
        System.out.println("📋 PETUNJUK PENGGUNAAN:");
        System.out.println("   ON   → Menyalakan laptop");
        System.out.println("   OFF  → Mematikan laptop");
        System.out.println("   UP   → Menambah volume");
        System.out.println("   DOWN → Mengurangi volume");
        System.out.println("   EXIT → Keluar program");
        System.out.println("─".repeat(50));
        
        do {
            System.out.print("\n🎮 Input command: ");
            command = scanner.next().toUpperCase();
            
            switch (command) {
                case "ON":
                    user.turnOnLaptop();
                    break;
                    
                case "OFF":
                    user.turnOffLaptop();
                    break;
                    
                case "UP":
                    user.volumeUp();
                    break;
                    
                case "DOWN":
                    user.volumeDown();
                    break;
                    
                case "EXIT":
                    System.out.println("\n👋 Terima kasih telah menggunakan simulator!");
                    running = false;
                    break;
                    
                default:
                    System.out.println("❌ Command tidak dikenali! Gunakan: ON, OFF, UP, DOWN, EXIT");
            }
            
        } while (running);
        
        scanner.close();
    }
}