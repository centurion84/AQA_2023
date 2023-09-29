package homeWork8;

public class StudentInfo {
    public static void displayStudentInfo(Student student) {
        if (student != null) {
            System.out.println("Student name: " + student.name);
            System.out.println("Student age: " + student.age);
        } else {
            System.out.println("Data is missing!");
        }
    }

    static class Student {
        private String name;
        private int age;

        public Student(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public Student() {
            this.name = "Robert";
            this.age = 23;
        }

        // getters and setters
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}
