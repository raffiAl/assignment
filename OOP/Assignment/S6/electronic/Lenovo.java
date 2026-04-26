package electronic;

public class Lenovo implements Laptop {
    // ========== Atribut ==========
    private int volume;
    private boolean is_power_on;
    
    // ========== Constructor ==========
    public Lenovo() {
        this.volume = MIN_VOL;
        this.is_power_on = false;
    }
    
    // ========== Implementasi Method ==========
    @Override
    public void powerOn() {
        if (!is_power_on) {
            is_power_on = true;
            System.out.println("💻 Lenovo: Menyalakan...");
            System.out.println("   ⚡ Lenovo is ON");
        } else {
            System.out.println("💻 Lenovo: Sudah menyala!");
        }
    }
    
    @Override
    public void powerOff() {
        if (is_power_on) {
            is_power_on = false;
            System.out.println("💻 Lenovo: Mematikan...");
            System.out.println("   ⚫ Lenovo is OFF");
        } else {
            System.out.println("💻 Lenovo: Sudah mati!");
        }
    }
    
    @Override
    public void volumeUp() {
        if (is_power_on) {
            if (volume < MAX_VOL) {
                volume++;
                System.out.println("💻 Lenovo: Volume " + volume);
            } else {
                System.out.println("💻 Lenovo: Volume sudah maksimal (100)!");
            }
        } else {
            System.out.println("💻 Lenovo: Nyalakan dulu laptopnya!");
        }
    }
    
    @Override
    public void volumeDown() {
        if (is_power_on) {
            if (volume > MIN_VOL) {
                volume--;
                System.out.println("💻 Lenovo: Volume " + volume);
            } else {
                System.out.println("💻 Lenovo: Volume sudah minimal (0)!");
            }
        } else {
            System.out.println("💻 Lenovo: Nyalakan dulu laptopnya!");
        }
    }
}