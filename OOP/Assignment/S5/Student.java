public class Student extends Person {
    // ========== Atribut ==========
    private int numCourses;
    private String[] courses;
    private int[] grades;
    private static final int MAX_COURSES = 30;
    
    // ========== Constructor ==========
    public Student(String name, String address) {
        super(name, address);
        this.numCourses = 0;
        this.courses = new String[MAX_COURSES];
        this.grades = new int[MAX_COURSES];
    }
    
    // ========== Method: Tambah Course & Grade ==========
    public void addCourseGrade(String course, int grade) {
        if (numCourses < MAX_COURSES) {
            courses[numCourses] = course;
            grades[numCourses] = grade;
            numCourses++;
        } else {
            System.out.println("⚠️ Maksimal kursus (" + MAX_COURSES + ") telah tercapai!");
        }
    }
    
    // ========== Method: Print Semua Grade ==========
    public void printGrades() {
        System.out.print("  ");
        for (int i = 0; i < numCourses; i++) {
            System.out.print(courses[i] + ":" + grades[i]);
            if (i < numCourses - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }
    
    // ========== Method: Hitung Rata-rata ==========
    public double getAverageGrade() {
        if (numCourses == 0) {
            return 0.0;
        }
        int total = 0;
        for (int i = 0; i < numCourses; i++) {
            total += grades[i];
        }
        return (double) total / numCourses;
    }
    
    // ========== toString (Override) ==========
    public String toString() {
        return "Student: " + super.getName() + "(" + super.getAddress() + ")";
    }
}