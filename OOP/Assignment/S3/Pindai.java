public class Pindai extends Grade {
    public Pindai(String name, String nim, int score) {
        super(name, nim, score);
    }

    public static void main(String[] args)  {
        Pindai student1 = new Pindai("Alice", "12345", 805);
        Pindai student2 = new Pindai("Bob", "67890", 75);
        Pindai student3 = new Pindai("Charlie", "54321", 65);
        Pindai student4 = new Pindai("David", "98765", 55);
        Pindai student5 = new Pindai("Eve", "11223", 45);

        System.out.println(student1.getScore());
        System.out.println(student2.getScore());
        System.out.println(student3.getScore());
        System.out.println(student4.getScore());
        System.out.println(student5.getScore());
    }
}
