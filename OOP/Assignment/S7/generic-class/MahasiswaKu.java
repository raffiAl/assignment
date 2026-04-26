// File: MahasiswaKu.java
public class MahasiswaKu {
    private String nama;
    private String nim;
    private int umur;
    private String gender;

    public MahasiswaKu(String nama, String nim, int umur, String gender) {
        this.nama = nama;
        this.nim = nim;
        this.umur = umur;
        this.gender = gender;
    }

    public String getNama() { return nama; }
    public String getNim() { return nim; }
    public int getUmur() { return umur; }
    public String getGender() { return gender; }

    @Override
    public String toString() {
        return "Mahasiswa[nama=" + nama + ", nim=" + nim + ", umur=" + umur + ", gender=" + gender + "]";
    }
}