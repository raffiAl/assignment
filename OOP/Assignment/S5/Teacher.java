public class Teacher extends Person {
    // ========== Atribut ==========
    private int numCourses;
    private String[] courses;
    private static final int MAX_COURSES = 30;
    
    // ========== Constructor ==========
    public Teacher(String name, String address) {
        super(name, address);
        this.numCourses = 0;
        this.courses = new String[MAX_COURSES];
    }
    
    // ========== Method: Tambah Course ==========
    public boolean addCourse(String course) {
        // Cek apakah course sudah ada
        for (int i = 0; i < numCourses; i++) {
            if (courses[i].equalsIgnoreCase(course)) {
                System.out.println("  ⚠️ Kursus \"" + course + "\" sudah ada!");
                return false;
            }
        }
        // Tambah course baru
        if (numCourses < MAX_COURSES) {
            courses[numCourses] = course;
            numCourses++;
            return true;
        } else {
            System.out.println("  ⚠️ Maksimal kursus (" + MAX_COURSES + ") telah tercapai!");
            return false;
        }
    }
    
    // ========== Method: Hapus Course ==========
    public boolean removeCourse(String course) {
        // Cari index course
        int index = -1;
        for (int i = 0; i < numCourses; i++) {
            if (courses[i].equalsIgnoreCase(course)) {
                index = i;
                break;
            }
        }
        // Jika tidak ditemukan
        if (index == -1) {
            System.out.println("  ⚠️ Kursus \"" + course + "\" tidak ditemukan!");
            return false;
        }
        // Geser elemen ke kiri
        for (int i = index; i < numCourses - 1; i++) {
            courses[i] = courses[i + 1];
        }
        courses[numCourses - 1] = null;
        numCourses--;
        return true;
    }
    
    // ========== toString (Override) ==========
    public String toString() {
        return "Teacher: " + super.getName() + "(" + super.getAddress() + ")";
    }
}