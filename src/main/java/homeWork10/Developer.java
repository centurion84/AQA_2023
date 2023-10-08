package homeWork10;

import java.util.Objects;

class Developer extends Employee {
    private final String programmingLanguage;

    public Developer(String name, String address, double salary, String programmingLanguage) {
        super(name, address, salary, "Developer");
        this.programmingLanguage = programmingLanguage;
    }

    public String getProgrammingLanguage() {
        return programmingLanguage;
    }

    @Override
    public double calculateBonus() {
        return getSalary() * 0.1;
    }

    @Override
    public String performWork() {
        return "Developer is writing code in " + getProgrammingLanguage();
    }

    @Override
    public String toString() {
        return "Developer{" +
                "programmingLanguage='" + programmingLanguage + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Developer developer = (Developer) o;
        return Objects.equals(programmingLanguage, developer.programmingLanguage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), programmingLanguage);
    }
}
