package generics.max;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingInt;

public class MaxEmployees {

    public static List<Employee> createEmployees() {
        return Arrays.asList(
                new Employee(1, "Peter Gibbons"),
                new Employee(2, "Samir Nagheenanajar"),
                new Employee(3, "Michael Bolton"),
                new Employee(4, "Milton Waddams")
        );
    }

    public static void main(String[] args) {
        List<Employee> employees = createEmployees();

        /** Anonymous class */
        Employee maxId = employees.stream()
                .max(new Comparator<Employee>() {
                    @Override
                    public int compare(Employee e1, Employee e2) {
                        return e1.getId() - e2.getId();
                    }
                }).orElse(Employee.DEFAULT_EMPLOYEE);
        Employee maxName = employees.stream()
                .max(new Comparator<Object>() {
                    @Override
                    public int compare(Object o1, Object o2) {
                        return o1.toString().compareTo(o2.toString());
                    }
                }).orElse(Employee.DEFAULT_EMPLOYEE);
        System.out.println(maxId);
        System.out.println(maxName);

        /** Lambda */
        Employee maxId1 = employees.stream()
                .max((e1, e2) -> e1.getId() - e2.getId()).orElse(Employee.DEFAULT_EMPLOYEE);
        Employee maxName1 = employees.stream()
                .max((Comparator<Object>) (o1, o2) -> o1.toString().compareTo(o2.toString())).orElse(Employee.DEFAULT_EMPLOYEE);
        System.out.println(maxId);
        System.out.println(maxName);

        /** Functional comparing */
        maxId = employees.stream()
                .max(comparingInt(Employee::getId)).orElse(Employee.DEFAULT_EMPLOYEE);
        maxName = employees.stream()
                .max(comparing(Object::toString)).orElse(Employee.DEFAULT_EMPLOYEE);
        System.out.println(maxId);
        System.out.println(maxName);
    }

}
