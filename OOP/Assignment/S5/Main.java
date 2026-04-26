public class Main {
    public static void main(String[] args) {
        
        // ========================================
        // TEST 1: CLASS PERSON
        // ========================================
        System.out.println("█".repeat(50));
        System.out.println("   TEST 1: CLASS PERSON");
        System.out.println("█".repeat(50));
        
        Person person = new Person("Ahmad Ridwan", "Jakarta");
        System.out.println("\n📋 Data Person:");
        System.out.println("   " + person);
        System.out.println("   Nama    : " + person.getName());
        System.out.println("   Alamat  : " + person.getAddress());
        
        // Ubah alamat
        person.setAddress("Bandung");
        System.out.println("\n📝 Setelah ubah alamat:");
        System.out.println("   " + person);
        
        // ========================================
        // TEST 2: CLASS STUDENT
        // ========================================
        System.out.println("\n\n" + "█".repeat(50));
        System.out.println("   TEST 2: CLASS STUDENT");
        System.out.println("█".repeat(50));
        
        Student student1 = new Student("Budi Santoso", "Surabaya");
        System.out.println("\n📋 Data Student:");
        System.out.println("   " + student1);
        
        // Tambah course dan grade
        System.out.println("\n📚 Menambahkan course & grade:");
        student1.addCourseGrade("Matematika", 85);
        student1.addCourseGrade("Fisika", 90);
        student1.addCourseGrade("Kimia", 78);
        student1.addCourseGrade("B.Indonesia", 88);
        student1.addCourseGrade("B.Inggris", 92);
        
        // Print grades
        System.out.println("\n📊 Daftar Nilai:");
        student1.printGrades();
        
        // Hitung rata-rata
        System.out.println("\n📈 Rata-rata Nilai: " + String.format("%.2f", student1.getAverageGrade()));
        
        // ========================================
        // TEST 3: CLASS STUDENT KE-2
        // ========================================
        Student student2 = new Student("Siti Aminah", "Yogyakarta");
        System.out.println("\n\n📋 Data Student 2:");
        System.out.println("   " + student2);
        
        student2.addCourseGrade("Matematika", 70);
        student2.addCourseGrade("Fisika", 65);
        student2.addCourseGrade("Kimia", 75);
        
        System.out.println("\n📊 Daftar Nilai:");
        student2.printGrades();
        System.out.println("\n📈 Rata-rata Nilai: " + String.format("%.2f", student2.getAverageGrade()));
        
        // ========================================
        // TEST 4: CLASS TEACHER
        // ========================================
        System.out.println("\n\n" + "█".repeat(50));
        System.out.println("   TEST 4: CLASS TEACHER");
        System.out.println("█".repeat(50));
        
        Teacher teacher1 = new Teacher("Dr. Hendra", "Malang");
        System.out.println("\n📋 Data Teacher:");
        System.out.println("   " + teacher1);
        
        // Tambah course
        System.out.println("\n📚 Menambahkan course:");
        System.out.println("   Tambah Matematika    : " + teacher1.addCourse("Matematika"));
        System.out.println("   Tambah Fisika        : " + teacher1.addCourse("Fisika"));
        System.out.println("   Tambah Kimia         : " + teacher1.addCourse("Kimia"));
        System.out.println("   Tambah Matematika    : " + teacher1.addCourse("Matematika")); // Duplikat
        
        // Hapus course
        System.out.println("\n🗑️ Menghapus course:");
        System.out.println("   Hapus Fisika         : " + teacher1.removeCourse("Fisika"));
        System.out.println("   Hapus Biologi        : " + teacher1.removeCourse("Biologi")); // Tidak ada
        
        // Tambah course baru setelah hapus
        System.out.println("\n📚 Tambah course baru:");
        System.out.println("   Tambah B.Indonesia   : " + teacher1.addCourse("B.Indonesia"));
        
        // ========================================
        // TEST 5: CLASS TEACHER KE-2
        // ========================================
        Teacher teacher2 = new Teacher("Prof. Sari Dewi", "Semarang");
        System.out.println("\n\n📋 Data Teacher 2:");
        System.out.println("   " + teacher2);
        
        System.out.println("\n📚 Menambahkan course:");
        System.out.println("   Tambah PBO           : " + teacher2.addCourse("PBO"));
        System.out.println("   Tambah Struktur Data : " + teacher2.addCourse("Struktur Data"));
        System.out.println("   Tambah Algoritma     : " + teacher2.addCourse("Algoritma"));
        
        System.out.println("\n🗑️ Menghapus course:");
        System.out.println("   Hapus Algoritma      : " + teacher2.removeCourse("Algoritma"));
        
        // ========================================
        // RINGKASAN AKHIR
        // ========================================
        System.out.println("\n\n" + "█".repeat(50));
        System.out.println("   📊 RINGKASAN DATA");
        System.out.println("█".repeat(50));
        
        Person[] people = {
            person,
            student1,
            student2,
            teacher1,
            teacher2
        };
        
        System.out.println("\n👥 Semua Person (Polymorphism):");
        for (Person p : people) {
            System.out.println("   → " + p);
        }
        
        System.out.println("\n" + "=".repeat(50));
        System.out.println("   ✅ SEMUA TEST BERHASIL!");
        System.out.println("=".repeat(50));
    }
}