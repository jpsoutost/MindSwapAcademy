package academy.mindswap;

public class Employee {
    private String name;
    private int age;
    private Departments department;
    private int YearsWorkingATDepartment;
    private int salary;

    public Employee(String name, int age, Departments department, int yearsWorkingATDepartment, int salary) {
        this.name = name;
        this.age = age;
        this.department = department;
        YearsWorkingATDepartment = yearsWorkingATDepartment;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Departments getDepartment() {
        return department;
    }

    public int getYearsWorkingATDepartment() {
        return YearsWorkingATDepartment;
    }

    public int getSalary() {
        return salary;
    }


    @Override
    public String toString() {
        return this.name;
    }
}
