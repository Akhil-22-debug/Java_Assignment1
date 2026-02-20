import java.io.*;
import java.util.*;

public class FileHandler {

    private static final String FILE_NAME = "employees.txt";

    // Read employees from file
    public static ArrayList<Employee> readEmployees() {
        ArrayList<Employee> list = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(FILE_NAME));
            String line;

            while ((line = br.readLine()) != null) {
                list.add(Employee.fromFileString(line));
            }

            br.close();
        } catch (IOException e) {
            System.out.println("File not found. New file will be created.");
        }

        return list;
    }

    // Write employees to file
    public static void writeEmployees(ArrayList<Employee> list) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME));

            for (Employee emp : list) {
                bw.write(emp.toFileString());
                bw.newLine();
            }

            bw.close();
        } catch (IOException e) {
            System.out.println("Error writing to file.");
        }
    }
}