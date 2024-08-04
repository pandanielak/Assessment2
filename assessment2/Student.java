import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.io.FileReader;
import java.io.IOException;

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
