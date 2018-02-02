package listProcessingAndLambdas;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Created by aktemur on 24/02/2017.
 */

public class Main {
    private static Random random = new Random();

    public static void main(String[] args) {
        // Create two lists with the same random Students
        List<Student> students1 = new LinkedList<Student>();
        List<Student> students2 = new LinkedList<Student>();
        for (int i = 0; i < 100; i++) {
            double gpa = random.nextDouble() * 4.0;
            boolean isInCS = random.nextBoolean();
            Student s = new Student("stu" + i, gpa, isInCS);
            students1.add(s);
            students2.add(s);
        }

        int numCSStudents = getNumOfCSStudents(students1);
        int numHonorStudents = getNumOfHonorStudents(students1);
        int numRiskyStudents = getNumOfStudentsWithLowerGPA(students1, 2.0);
        System.out.print("There are " + numCSStudents + " CS students, ");
        System.out.print(numHonorStudents + " Honor students, ");
        System.out.println("and " + numRiskyStudents + " risky students in list 1");

        int numCSStudents2 = getNumOfCSStudents2(students2);
        int numHonorStudents2 = getNumOfHonorStudents2(students2);
        int numRiskyStudents2 = getNumOfStudentsWithLowerGPA2(students2, 2.0);
        System.out.print("There are " + numCSStudents2 + " CS students, ");
        System.out.print(numHonorStudents2 + " Honor students, ");
        System.out.println("and " + numRiskyStudents2 + " risky students in list 2.");

        System.out.println("------------------------------------------------------");

        System.out.println("Removing non-CS students...");
        removeNonCSStudents(students1);
        removeNonCSStudents2(students2);

        System.out.println("There are " + getNumOfHonorStudents(students1) + " Honor students and "
                + getNumOfStudentsWithLowerGPA(students1, 2.0) + " risky students in list 1.");
        System.out.println("There are " + getNumOfHonorStudents2(students2) + " Honor students and "
                + getNumOfStudentsWithLowerGPA2(students2, 2.0) + " risky students in list 2.");
    }

    //
    // The functions below iterate the list using the traditional for-loop approach
    //
    private static int getNumOfCSStudents(List<Student> students) {
        int count = 0;
        for (Student student : students) {
            if (student.isInCS()) {
                count++;
            }
        }
        return count;
    }

    private static int getNumOfHonorStudents(List<Student> students) {
        int count = 0;
        for (Student student : students) {
            if (student.getGpa() >= 3.0) {
                count++;
            }
        }
        return count;
    }

    private static int getNumOfStudentsWithLowerGPA(List<Student> students, double threshold) {
        int count = 0;
        for (Student student : students) {
            if (student.getGpa() < threshold) {
                count++;
            }
        }
        return count;
    }

    private static void removeNonCSStudents(List<Student> students) {
        int count = 0;
        for (int i = 0; i < students.size(); i++) {
            if (!students.get(i).isInCS()) {
                students.remove(i);
                i--; // Yuck, ugly!
            }
        }

        // Alternative:
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (!student.isInCS()) {
                iterator.remove();
            }
        }
    }

    //
    // The functions below use the "lambda" approach to filter the elements.
    // This works only with Java 8.
    //
    private static int getNumOfCSStudents2(List<Student> students) {
        return (int)students.stream().filter(student -> student.isInCS()).count();
        // Alternative:
        //     (int)students.stream().filter(Student::isInCS).count();
    }

    private static int getNumOfHonorStudents2(List<Student> students) {
        return (int)students.stream().filter(student -> student.getGpa() >= 3.0).count();
    }

    private static int getNumOfStudentsWithLowerGPA2(List<Student> students, double threshold) {
        return (int)students.stream().filter(student -> student.getGpa() < threshold).count();
    }

    private static void removeNonCSStudents2(List<Student> students) {
        students.removeIf(student -> !student.isInCS());
    }
}
