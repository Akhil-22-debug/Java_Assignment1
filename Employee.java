public class Employee {
    private int id;
    private String name;
    private double basicSalary;

    // Default constructor
    public Employee() {
    }

    // Parameterized constructor
    public Employee(int id, String name, double basicSalary) {
        this.id = id;
        this.name = name;
        this.basicSalary = basicSalary;
    }

    // Method overloading
    public double calculateSalary() {
        double hra = basicSalary * 0.20;
        double da = basicSalary * 0.10;
        return basicSalary + hra + da;
    }

    public double calculateSalary(double bonus) {
        return calculateSalary() + bonus;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    // Convert object to file format
    public String toFileString() {
        return id + "," + name + "," + basicSalary;
    }

    // Create object from file data
    public static Employee fromFileString(String line) {
        String[] data = line.split(",");
        int id = Integer.parseInt(data[0]);
        String name = data[1];
        double salary = Double.parseDouble(data[2]);
        return new Employee(id, name, salary);
    }
}