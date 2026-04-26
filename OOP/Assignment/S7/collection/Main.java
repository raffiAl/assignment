import java.util.ArrayList;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) {
        
        // ==========================================
        // CONTOH 1: ARRAYLIST
        // ==========================================
        System.out.println("█".repeat(50));
        System.out.println("   DEMO 1: ARRAYLIST");
        System.out.println("█".repeat(50));
        
        ArrayList<String> buah = new ArrayList<String>();
        
        // Tambah data
        buah.add("Apel");
        buah.add("Mangga");
        buah.add("Jeruk");
        buah.add("Durian");
        
        System.out.println("\nIsi ArrayList awal: " + buah);
        
        // Akses berdasarkan index
        System.out.println("Buah di index 2: " + buah.get(2));
        
        // Ubah data
        buah.set(1, "Mangga Harum Manis");
        System.out.println("Setelah diubah index 1: " + buah);
        
        // Hapus data
        buah.remove(0); // Hapus "Apel"
        System.out.println("Setelah hapus index 0: " + buah);
        
        // Cek ukuran
        System.out.println("Jumlah buah: " + buah.size());


        // ==========================================
        // CONTOH 2: ARRAYDEQUE (Double Ended Queue)
        // ==========================================
        System.out.println("\n\n" + "█".repeat(50));
        System.out.println("   DEMO 2: ARRAYDEQUE");
        System.out.println("█".repeat(50));
        
        Deque<String> antrian = new ArrayDeque<String>();
        
        // Tambah data dari belakang (Tail)
        antrian.addLast("Pelanggan 1");
        antrian.addLast("Pelanggan 2");
        
        // Tambah data dari depan (Head) - Prioritas
        antrian.addFirst("VIP 1");
        antrian.addFirst("VIP 2");
        
        System.out.println("\nIsi Antrian saat ini: " + antrian);
        System.out.println("(Perhatikan urutannya, VIP masuk dari depan)");
        
        // Lihat siapa yang paling depan dan paling belakang
        System.out.println("\nAntrian paling depan (Head): " + antrian.peekFirst());
        System.out.println("Antrian paling belakang (Tail): " + antrian.peekLast());
        
        // Proses antrian (Ambil dari depan)
        System.out.println("\nMemproses antrian...");
        System.out.println("Dilayani: " + antrian.pollFirst());
        System.out.println("Dilayani: " + antrian.pollFirst());
        
        System.out.println("\nSisa Antrian: " + antrian);
        
        // Tambah dari belakang lagi
        antrian.addLast("Pelanggan 3");
        System.out.println("Setelah tambah di belakang: " + antrian);
    }
}