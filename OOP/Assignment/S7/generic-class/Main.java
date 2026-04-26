// File: MainSoal1.java
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // ❌ KODE AWAL YANG ERROR (Raw Type & ClassCastException):
        // List list = new ArrayList();
        // list.add(new MahasiswaKu("Budi", "001", 20, "L"));
        // list.add("String Kalimat"); // Tidak di-filter tipe datanya
        // MahasiswaKu m = (MahasiswaKu) list.get(1); // ERROR! ClassCastException

        // ✅ PERBAIKAN DENGAN GENERIC (Type-Safe):
        List<MahasiswaKu> listMhs = new ArrayList<MahasiswaKu>();

        // Sekarang list hanya bisa menampung objek MahasiswaKu
        listMhs.add(new MahasiswaKu("Budi Santoso", "220101001", 20, "Laki-laki"));
        listMhs.add(new MahasiswaKu("Siti Aminah", "220101002", 19, "Perempuan"));
        
        // listMhs.add("String Kalimat"); // ❌ BARIS INI AKAN LANGSUNG ERROR COMPILE (Aman!)
        
        // Tidak perlu casting lagi
        MahasiswaKu m1 = listMhs.get(0); 
        System.out.println("Data Mahasiswa 1: " + m1);

        System.out.println("\n📦 Semua Data Mahasiswa:");
        for (MahasiswaKu mhs : listMhs) {
            System.out.println(" -> " + mhs);
        }
    }
}