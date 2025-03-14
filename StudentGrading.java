import java.util.Scanner;

class InvalidMarksException extends Exception {
    public InvalidMarksException(String message) {
        super(message);
    }
}


class Student {
    private String name;
    private int marks;

    
    public Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

  
    public String assignGrade() throws InvalidMarksException {
        if (marks < 0 || marks > 100) {
            throw new InvalidMarksException("Marks must be between 0 and 100.");
        }
        if (marks >= 85) {
            return "A";
        } else if (marks >= 70) {
            return "B";
        } else if (marks >= 50) {
            return "C";
        } else {
            return "F";
        }
    }
}


public class StudentGrading {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter student's name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter student's marks: ");
        int marks = scanner.nextInt();
        
        Student student = new Student(name, marks);
        
        try {
            String grade = student.assignGrade();
            System.out.println("Grade: " + grade);
        } catch (InvalidMarksException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Grade assigned successfully.");
        }
        
        scanner.close();
    }
}
