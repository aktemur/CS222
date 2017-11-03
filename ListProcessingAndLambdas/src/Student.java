/**
 * Created by aktemur on 24/02/2017.
 */
public class Student {
    private String name;
    private double gpa;
    private boolean isInCS;

    public Student(String name, double gpa, boolean isInCS) {
        this.name = name;
        this.gpa = gpa;
        this.isInCS = isInCS;
    }

    public String getName() {
        return name;
    }

    public double getGpa() {
        return gpa;
    }

    public boolean isInCS() {
        return isInCS;
    }
}
