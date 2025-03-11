import java.util.*;
import java.util.stream.*;

class Student {
    String name;
    double marks;

    Student(String name, double marks) {
        this.name = name;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return name + " | Marks: " + marks;
    }
}

public class Exp6_MediumProblem {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("John", 82),
            new Student("Jane", 68),
            new Student("Emma", 91),
            new Student("Lucas", 74)
        );

        System.out.println("Students scoring above 75%:");
        students.stream()
                .filter(s -> s.marks > 75)
                .sorted(Comparator.comparingDouble(s -> -s.marks)) // Descending order
                .forEach(System.out::println);
    }
}
