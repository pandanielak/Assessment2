import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the file name:");
        String fileName = scanner.nextLine();
        scanner.close();

        try {
            scanner = new Scanner(new File(fileName));
            String unitName = "";
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.startsWith("#")) {
                    // Ignore comments
                    continue;
                } else if (unitName.isEmpty()) {
                    unitName = line;
                } else {
                    String[] parts = line.split(",");
                    if (parts.length == 4) {
                        String studentName = parts[0];
                        String studentId = parts[1];
                        double assignment1 = Double.parseDouble(parts[2]);
                        double assignment2 = Double.parseDouble(parts[3]);
                        System.out.println("Unit: " + unitName);
                        System.out.println("Student Name: " + studentName);
                        System.out.println("Student ID: " + studentId);
                        System.out.println("Assignment 1: " + assignment1);
                        System.out.println("Assignment 2: " + assignment2);
                    }
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }
}
