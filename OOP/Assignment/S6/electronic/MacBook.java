package electronic;

public class MacBook implements Laptop {
    // ========== Atribut ==========
    private int volume;
    private boolean is_power_on;
    
    // ========== Constructor ==========
    public MacBook() {
        this.volume = MIN_VOL;
        this.is_power_on = false;
    }
    
    // ========== Implementasi Method ==========
    @Override
    public void powerOn() {
        if (!is_power_on) {
            is_power_on = true;
            System.out.println("🍎 MacBook: Starting...");
            System.out.println("   ⚡ MacBook is ON");
        } else {
            System.out.println("🍎 MacBook: Sudah menyala!");
        }
    }
    
    @Override
    public void powerOff() {
        if (is_power_on) {
            is_power_on = false;
            System.out.println("🍎 MacBook: Shutting down...");
            System.out.println("   ⚫ MacBook is OFF");
        } else {
            System.out.println("🍎 MacBook: Sudah mati!");
        }
    }
    
    @Override
    public void volumeUp() {
        if (is_power_on) {
            if (volume < MAX_VOL) {
                volume++;
                System.out.println("🍎 MacBook: Volume " + volume);
            } else {
                System.out.println("🍎 MacBook: Volume sudah maksimal (100)!");
            }
        } else {
            System.out.println("🍎 MacBook: Nyalakan dulu laptopnya!");
        }
    }
    
    @Override
    public void volumeDown() {
        if (is_power_on) {
            if (volume > MIN_VOL) {
                volume--;
                System.out.println("🍎 MacBook: Volume " + volume);
            } else {
                System.out.println("🍎 MacBook: Volume sudah minimal (0)!");
            }
        } else {
            System.out.println("🍎 MacBook: Nyalakan dulu laptopnya!");
        }
    }
}