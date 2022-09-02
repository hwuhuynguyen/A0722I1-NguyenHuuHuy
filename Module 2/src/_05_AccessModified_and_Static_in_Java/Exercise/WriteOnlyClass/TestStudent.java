package _05_AccessModified_and_Static_in_Java.Exercise.WriteOnlyClass;

public class TestStudent {
    public static void main(String[] args) {
        Student s = new Student();
        s.setName("Alex");
        s.setClasses("A01");

        System.out.println(s.getName());
        System.out.println(s.getClasses());
    }
}
