import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TugasA {
    public static void main(String[] args) {
        String csvFile = "students.csv";
        int totalBaris = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while (br.readLine() != null) {
                totalBaris++;
            }
            System.out.println("Jumlah baris dalam file " + csvFile + " adalah: " + totalBaris);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
