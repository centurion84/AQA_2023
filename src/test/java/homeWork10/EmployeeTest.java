package homeWork10;

import org.testng.annotations.Test;

public class EmployeeTest {

    @Test
    public void employeeTest() {
        // create objects of super and subclasses
        Employee employee1 = new Employee("John Doe", "123 Main St", 5000.0, "Employee");
        Employee employee2 = new Employee("John Doe", "123 Main St", 5000.0, "Employee");
        Manager manager = new Manager("Mike Johnson", "789 Oak St", 7000.0);
        Developer developer = new Developer("Alice Brown", "101 Pine St", 6000.0, "Java");
        QA qa = new QA("Bob Green", "222 Maple St", 4000.0);

        // Using override method getBonus()
        System.out.println("Employee has a bonus " + employee1.calculateBonus() + "USD");
        System.out.println("Manager has a bonus " + manager.calculateBonus() + "USD");
        System.out.println("Developer has a bonus " + developer.calculateBonus() + "USD");
        System.out.println("QA has a bonus " + qa.calculateBonus() + "USD");

        // Using override method performWork()
        System.out.println(employee1.getName() + " - " + employee1.performWork());
        System.out.println(manager.getName() + " - " + manager.performWork());
        System.out.println(developer.getName() + " - " + developer.performWork());
        System.out.println(qa.getName() + " - " + qa.performWork());

        // Using override methods equals()
        System.out.println("employee1.equals(employee2): " + employee1.equals(employee2));
        System.out.println("employee1.equals(manager): " + employee1.equals(manager));

        // Using override methods hashCode()
        System.out.println("employee1.hashCode(): " + employee1.hashCode());
        System.out.println("employee2.hashCode(): " + employee2.hashCode());
        System.out.println("manager.hashCode(): " + manager.hashCode());
        System.out.println("developer.hashCode(): " + developer.hashCode());
        System.out.println("qa.hashCode(): " + qa.hashCode());

        // Use override method toString()
        System.out.println("employee1.toString(): " + employee1);
        System.out.println("manager.toString(): " + manager);
        System.out.println("developer.toString(): " + developer);
        System.out.println("qa.toString(): " + qa);

        // Use override method generateReport()
        System.out.println(employee2.generateReport());
        System.out.println(manager.generateReport());
        System.out.println(developer.generateReport());
        System.out.println(qa.generateReport());
    }
}
