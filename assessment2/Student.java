import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;

class Student {
    String firstName;
    String lastName;
    String studentID;
    double mark1;
    double mark2;
    double mark3;
    double totalMark;
    
    public Student(String firstName, String lastName, String studentID, double mark1, double mark2, double mark3) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentID = studentID;
        this.mark1 = mark1;
        this.mark2 = mark2;
        this.mark3 = mark3;
        this.totalMark = mark1 + mark2 + mark3;
    }
    public double getTotalMark() {
        return totalMark;
    }
}

class StudentMarks {
    private List<Student> students;
      private double parseDoubleWithDefault(String str, double defaultValue) {
        try {
            return Double.parseDouble(str);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }
    
    public StudentMarks() {
        students = new ArrayList<>();
    }
    public void readFromFile(String fileName) {
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
            String unitName = bufferedReader.readLine();
            bufferedReader.readLine();
            
            System.out.println("Name of the unit: " + unitName.substring(6));
            
            String line;
            while((line = bufferedReader.readLine()) !=null) {
                if (line.trim().startsWith("#")) {
                    continue;
                }
                String[] data = line.split(",");
                if (data.length >= 6) {
                    String firstName = data[1].trim();
                    String lastName = data[0].trim();
                    String studentID = data[2].trim();
                    
                    double mark1 = parseDoubleWithDefault(data[3].trim(), 0.0);
                    double mark2 = parseDoubleWithDefault(data[4].trim(), 0.0);
                    double mark3 = parseDoubleWithDefault(data[5].trim(), 0.0);
                    
                    System.out.println("Student Name: " + firstName + " " + lastName);
                    System.out.println("Student ID: " + studentID);
                    System.out.println("A1: " + mark1);
                    System.out.println("A2: " + mark2);
                    System.out.println("A3: " + mark3);
                    System.out.println();
                    
                    Student student = new Student(firstName, lastName, studentID, mark1, mark2, mark3);
                    students.add(student);
                }
            } 
            bufferedReader.close();
        }catch (IOException e) {
        System.out.println("Error reading the file: " + e.getMessage());
    }
}
public void calculateTotalMark() {
    System.out.println("Calculate student marks.");
    for (Student student : students) {
        System.out.println("Student name: " + student.firstName + " " + student.lastName);
        System.out.println("Student ID: " + student.studentID);
        System.out.println("Total mark: " + student.getTotalMark());
        System.out.println();
    }
}
public void StudentMarkThreshold(double threshold) {
    System.out.println("Students with mark below given threshold of " + threshold + ": ");
    for (Student student : students) {
        if (student.getTotalMark() < threshold) {
            System.out.println("Student Name: " + student.firstName + " " + student.lastName);
            System.out.println("Student ID: " + student.studentID);
            System.out.println("Total Mark: " + student.getTotalMark());
            System.out.println();
        }
    }  
}
public void TopAndBottomMarks() {
    List<Student> topMarks = new ArrayList<>();
    List<Student> bottomMarks = new ArrayList<>();
    for (Student student : students) {
        if (topMarks.size() <5) {
            topMarks.add(student);
        } else {
            for (int i = 0; i< topMarks(); i++) {
                if (student.getTotalMark() > topMarks.get(i).getTotalMark()){
                    topMarks.add(i, student);
                    topMarks.remove(5);
                    break;
                }
            }
        }
        }
    }
    
}
}