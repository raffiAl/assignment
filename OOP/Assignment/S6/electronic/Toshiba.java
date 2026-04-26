package electronic;

public class Toshiba implements Laptop {
    // ========== Atribut ==========
    private int volume;
    private boolean is_power_on;
    
    // ========== Constructor ==========
    public Toshiba() {
        this.volume = MIN_VOL;
        this.is_power_on = false;
    }
    
    // ========== Implementasi Method ==========
    @Override
    public void powerOn() {
        if (!is_power_on) {
            is_power_on = true;
            System.out.println("💻 Toshiba: Booting up...");
            System.out.println("   ⚡ Toshiba is ON");
        } else {
            System.out.println("💻 Toshiba: Sudah menyala!");
        }
    }
    
    @Override
    public void powerOff() {
        if (is_power_on) {
            is_power_on = false;
            System.out.println("💻 Toshiba: Shutting down...");
            System.out.println("   ⚫ Toshiba is OFF");
        } else {
            System.out.println("💻 Toshiba: Sudah mati!");
        }
    }
    
    @Override
    public void volumeUp() {
        if (is_power_on) {
            if (volume < MAX_VOL) {
                volume++;
                System.out.println("💻 Toshiba: Volume " + volume);
            } else {
                System.out.println("💻 Toshiba: Volume sudah maksimal (100)!");
            }
        } else {
            System.out.println("💻 Toshiba: Nyalakan dulu laptopnya!");
        }
    }
    
    @Override
    public void volumeDown() {
        if (is_power_on) {
            if (volume > MIN_VOL) {
                volume--;
                System.out.println("💻 Toshiba: Volume " + volume);
            } else {
                System.out.println("💻 Toshiba: Volume sudah minimal (0)!");
            }
        } else {
            System.out.println("💻 Toshiba: Nyalakan dulu laptopnya!");
        }
    }
}