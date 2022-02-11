package academy.mindswap;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class EmployeeAnalyser {

    List<Employee> list;

    public EmployeeAnalyser(List<Employee> list) {
        this.list = list;
    }

    public int departmentYearsCounter(Departments department, int yearsWorking){
        return (int) this.list.stream().
                filter(e -> e.getDepartment().equals(department)).
                filter(e -> e.getYearsWorkingATDepartment() >= yearsWorking).
                count();
    }

    public List<String> salaryOverEmployees (int salary){
        List<String> employeesList = new ArrayList<>();
        this.list.stream().
                filter(e -> e.getSalary() > salary).
                forEach(e -> employeesList.add(e.getName()));
        return employeesList;
    }

    public List<Employee> getOldestEmployees(int numberOfEmployees){
        List<Employee> employeesList = new ArrayList<>();
        this.list.stream().
                sorted((e1, e2) -> Integer.compare(e2.getAge(), e1.getAge())).
                limit(numberOfEmployees).
                forEach(e -> employeesList.add(e));

        return employeesList;
    }

    public String getOlderThan (int age){
        Optional<Employee> employee = this.list.stream()
                .filter(e -> e.getAge() > age)
                .findFirst();

        return employee.isPresent() ? employee.get().toString() : "no employee";
    }

    public double averageSalaryDepartment(Departments department){
        OptionalDouble od = this.list.stream()
                .filter(e -> e.getDepartment().equals(department))
                .mapToInt(e -> e.getSalary())
                .average();

        return od.isPresent() ? od.getAsDouble() : 0;
    }

    public List<String> sameFirstNames(Departments dep1, Departments dep2){

        Set<String> dep1Employees = this.list.stream()
                .filter(e -> e.getDepartment().equals(dep1))
                .map(e -> e.getName().substring(0, e.getName().indexOf(" ")))
                .collect(Collectors.toSet());

        Set<String> dep2Employees = this.list.stream()
                .filter(e -> e.getDepartment().equals(dep2))
                .map(e -> e.getName().substring(0, e.getName().indexOf(" ")))
                .collect(Collectors.toSet());

        List<String> employeesList = dep1Employees.stream()
                .filter(dep1e -> dep2Employees.contains(dep1e))
                .collect(Collectors.toList());


        return employeesList;
    }

}
