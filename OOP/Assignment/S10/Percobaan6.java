public class Percobaan6 {
    static void demo() {
        NullPointerException t = new NullPointerException("Coba Throw");
        throw t;
    }
    public static void main(String[] args) {
        try {
            demo();
        } catch (NullPointerException e) {
            System.out.println("Ada pesan error: " + e);
        }
        System.out.println("Selesai");
    }
}
