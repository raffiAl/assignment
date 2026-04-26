import electronic.Laptop;

public class LaptopUser {
    // ========== Atribut ==========
    private Laptop laptop;
    
    // ========== Constructor ==========
    public LaptopUser(Laptop laptop) {
        this.laptop = laptop;
    }
    
    // ========== Method ==========
    public void turnOnLaptop() {
        laptop.powerOn();
    }
    
    public void turnOffLaptop() {
        laptop.powerOff();
    }
    
    public void volumeUp() {
        laptop.volumeUp();
    }
    
    public void volumeDown() {
        laptop.volumeDown();
    }
    
    // Getter untuk akses laptop
    public Laptop getLaptop() {
        return laptop;
    }
}