package electronic;

public interface Laptop {
    // ========== Konstanta ==========
    int MAX_VOL = 100;
    int MIN_VOL = 0;
    
    // ========== Method Abstract ==========
    void powerOn();
    void powerOff();
    void volumeUp();
    void volumeDown();
}