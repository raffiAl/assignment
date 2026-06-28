import java.io.*;

public class TugasC {
    public static void main(String[] args) {
        File fileAsal = new File("students.csv");
        File fileTujuan = new File("copy_students.csv");
        
        try (BufferedReader br = new BufferedReader(new FileReader(fileAsal));
             BufferedWriter bw = new BufferedWriter(new FileWriter(fileTujuan))) {
            
            String line;
            while ((line = br.readLine()) != null) {
                bw.write(line);
                bw.newLine();
            }
            System.out.println("Berhasil menyalin seluruh isi " + fileAsal.getName() + " ke " + fileTujuan.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
