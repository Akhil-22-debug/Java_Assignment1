import java.util.*;

public class PayrollApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Employee> employees = FileHandler.readEmployees();
        int choice;

        do {
            System.out.println("\n--- Employee Payroll System ---");
            System.out.println("1. Add Employee");
            System.out.println("2. Search Employee by ID");
            System.out.println("3. Display All Employees");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Basic Salary: ");
                    double salary = sc.nextDouble();

                    Employee emp = new Employee(id, name, salary);
                    employees.add(emp);

                    FileHandler.writeEmployees(employees);
                    System.out.println("Employee added successfully.");
                    break;

                case 2:
                    System.out.print("Enter ID to search: ");
                    int searchId = sc.nextInt();
                    boolean found = false;

                    for (Employee e : employees) {
                        if (e.getId() == searchId) {
                            System.out.println("ID: " + e.getId());
                            System.out.println("Name: " + e.getName());
                            System.out.println("Basic Salary: " + e.getBasicSalary());
                            System.out.println("Net Salary: " + e.calculateSalary());
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Employee not found.");
                    }
                    break;

                case 3:
                    for (Employee e : employees) {
                        System.out.println("\nID: " + e.getId());
                        System.out.println("Name: " + e.getName());
                        System.out.println("Basic Salary: " + e.getBasicSalary());
                        System.out.println("Net Salary: " + e.calculateSalary());
                    }
                    break;

                case 4:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 4);

        sc.close();
    }
}
