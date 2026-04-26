public class Grade {
    String name;
    String nim;
    String grade;
    String status;
    int score;

    public Grade(String name, String nim, int score) {
        this.name = name;
        this.nim = nim;
        this.score = score;

        if (score < 0 || score > 100) {
            this.grade = "Nilai tidak valid, Nilai harus antara 0-100";
            this.status = "Tidak Valid";
        }
        else if (score >= 80) {
            this.status = "Lulus";
            this.grade = "A";
        } else if (score >= 70) {
            this.status = "Lulus";
            this.grade = "B";
        } else if (score >= 60) {
            this.status = "Lulus";
            this.grade = "C";
        } else if (score >= 50) {
            this.status = "Tidak Lulus";
            this.grade = "D";
        } else {
            this.status = "Tidak Lulus";
            this.grade = "E";
        }
    }

    public String getScore() {
        return String.format(
            "Nama  : %s\nNIM   : %s\nGrade : %s\nNilai : %d\nStatus: %s\n---------------------------", name, nim, grade, score, status);
    }
}

