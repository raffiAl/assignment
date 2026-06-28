import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TugasB {
    public static void main(String[] args) {
        String csvFile = "new_students.csv";
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== Input Data Mahasiswa Baru ===");
        System.out.print("Masukkan NIM   : ");
        String nim = scanner.nextLine();
        System.out.print("Masukkan Nama  : ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan Umur  : ");
        String umur = scanner.nextLine();
        System.out.print("Masukkan Prodi : ");
        String prodi = scanner.nextLine();
        
        String formatData = nim + ", " + nama + ", " + umur + ", " + prodi;
        
        // Mode 'true' di FileWriter agar data baru di-append (ditambah di bawahnya)
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(csvFile, true))) {
            bw.write(formatData);
            bw.newLine();
            System.out.println("Data sukses ditambahkan ke " + csvFile);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
