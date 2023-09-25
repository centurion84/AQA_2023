package homeWork7;

import org.testng.annotations.Test;

public class PersonTest {

    @Test
    public void createNewPerson() {
        // Create objects of class
        Person person1 = new Person("Nicole", 24);
        Person person2 = new Person("Jacob", 37);

        // Output of name and age of each person
        System.out.println("First person:");
        System.out.println("Name: " + person1.name + ", age: " + person1.age);

        System.out.println("\nSecond person:");
        System.out.println("Name: " + person2.name + ", age: " + person2.age);
    }

}
