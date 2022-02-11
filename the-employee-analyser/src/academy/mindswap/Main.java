package academy.mindswap;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Employee> employeesList = Arrays.asList(
                new Employee("João Souto", 27, Departments.ADMINISTRATION, 15, 10000),
                new Employee("Tiago Correia", 30, Departments.MAINTENANCE, 3, 2000),
                new Employee("Maria Morais", 31, Departments.SALES, 7, 6000),
                new Employee("João Gonçalves", 22, Departments.PRODUCTION, 1, 1500),
                new Employee("Luís Faria", 29, Departments.MAINTENANCE, 8, 3000),
                new Employee("Diogo Bozan ", 38, Departments.MAINTENANCE, 113, 7500),
                new Employee("António Mota", 52, Departments.PRODUCTION, 28, 500),
                new Employee("André Alves" , 32, Departments.SALES, 10, 3600),
                new Employee("André Faiões", 63, Departments.MAINTENANCE, 35, 4000),
                new Employee("Diogo Noronha", 42, Departments.SALES, 9, 8000)
        );

        EmployeeAnalyser mindera = new EmployeeAnalyser(employeesList);

        System.out.println(mindera.departmentYearsCounter(Departments.PRODUCTION, 20));
        System.out.println(mindera.salaryOverEmployees(4000));
        System.out.println(mindera.getOldestEmployees(3));
        System.out.println(mindera.getOlderThan(70));
        System.out.println(mindera.averageSalaryDepartment(Departments.MAINTENANCE));
        System.out.println(mindera.sameFirstNames(Departments.SALES, Departments.MAINTENANCE));
    }
}
