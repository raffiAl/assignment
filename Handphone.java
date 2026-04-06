public class Handphone {
    String jenis_hp;
    int tahun_pembuatan;

    public void setDataHp(String jenis_hp, int tahun_pembuatan) {
        this.jenis_hp = jenis_hp;
        this.tahun_pembuatan = tahun_pembuatan;
    }

    public String getJenisHp() {
        return "Jenis HP: " + jenis_hp + ", Tahun Pembuatan: " + tahun_pembuatan;
    }

    public String getTahunPembuatan() {
        return "Tahun Pembuatan: " + tahun_pembuatan;
    }

    public static void main(String[] args) {
        Handphone hp1 = new Handphone();
        hp1.setDataHp("Smartphone", 2020);
        System.out.println(hp1.getJenisHp());
        System.out.println(hp1.getTahunPembuatan());
    }
}