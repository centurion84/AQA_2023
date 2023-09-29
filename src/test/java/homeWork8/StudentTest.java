package homeWork8;

import org.testng.annotations.Test;

public class StudentTest extends StudentInfo {

    @Test
    public static void studentInfoTest() {
        // create student with default values
        Student student1 = new Student();
        displayStudentInfo(student1);

        // change student name to null
        student1.setName(null);
        displayStudentInfo(student1);

        // assign null to student object
        Student student2 = null;
        displayStudentInfo(student2);
    }
}