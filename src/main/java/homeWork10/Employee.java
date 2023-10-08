package homeWork10;

import java.util.Objects;

public class Employee {
    private final String name;
    private final String address;
    private final double salary;
    private final String position;

    public Employee(String name, String address, double salary, String position) {
        this.name = name;
        this.address = address;
        this.salary = salary;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public double getSalary() {
        return salary;
    }

    public String getPosition() {
        return position;
    }

    public double calculateBonus() {
        return getSalary() * 0.2;
    }

    public String generateReport() {
        return "Performance report for " + getPosition() + " " + getName() + " -> Good";
    }

    public String performWork() {
        return "Employee is performing general tasks";
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", salary=" + salary +
                ", position='" + position + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Double.compare(salary, employee.salary) == 0 &&
                Objects.equals(name, employee.name) &&
                Objects.equals(address, employee.address) &&
                Objects.equals(position, employee.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, address, salary, position);
    }
}
