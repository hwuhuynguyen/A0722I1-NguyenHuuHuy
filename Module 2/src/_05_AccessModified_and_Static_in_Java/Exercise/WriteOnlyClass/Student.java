package _05_AccessModified_and_Static_in_Java.Exercise.WriteOnlyClass;

public class Student {
    private String name = "John";
    private String classes = "C02";

    public Student() {}
    public String getName() {
        return this.name;
    }
    public String getClasses() {
        return this.classes;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setClasses(String classes) {
        this.classes = classes;
    }
}
