import java.util.*;

class Employee {
    String name;
    int age;
    double salary;

    Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return name + " | Age: " + age + " | Salary: $" + salary;
    }
}

public class Exp6_EasyProblem {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee("Alice", 30, 50000),
            new Employee("Bob", 25, 60000),
            new Employee("Charlie", 28, 55000)
        );

        employees.sort(Comparator.comparingDouble(e -> e.salary));

        System.out.println("Sorted Employees by Salary:");
        employees.forEach(System.out::println);
    }
}
