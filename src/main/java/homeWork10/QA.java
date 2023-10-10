package homeWork10;

class QA extends Employee {
    public QA(String name, String address, double salary) {
        super(name, address, salary, "QA");
    }

    @Override
    public double calculateBonus() {
        return getSalary() * 0.05;
    }

    @Override
    public String performWork() {
        return "QA is testing software manually or using frameworks";
    }
}
