import java.util.Scanner;


abstract class Staff {
    protected String name;
    protected int id;
    protected String department;

    public Staff(String name, int id, String department) {
        this.name = name;
        this.id = id;
        this.department = department;
    }

    public abstract double calculateSalary();

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Department: " + department;
    }
}


class Professor extends Staff {
    private double monthlySalary;

    public Professor(String name, int id, String department, double monthlySalary) {
        super(name, id, department);
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double calculateSalary() {
        return monthlySalary;
    }

    @Override
    public String toString() {
        return super.toString() + ", Salary: " + calculateSalary();
    }
}


class Lecturer extends Staff {
    private int lecturesDelivered;
    private double payPerLecture;

    public Lecturer(String name, int id, String department, int lecturesDelivered, double payPerLecture) {
        super(name, id, department);
        this.lecturesDelivered = lecturesDelivered;
        this.payPerLecture = payPerLecture;
    }

    @Override
    public double calculateSalary() {
        return lecturesDelivered * payPerLecture;
    }

    @Override
    public String toString() {
        return super.toString() + ", Salary: " + calculateSalary();
    }
}


class Administrator extends Staff {
    private double baseSalary;
    private double performanceBonus;

    public Administrator(String name, int id, String department, double baseSalary, double performanceBonus) {
        super(name, id, department);
        this.baseSalary = baseSalary;
        this.performanceBonus = performanceBonus;
    }

    @Override
    public double calculateSalary() {
        return baseSalary + performanceBonus;
    }

    @Override
    public String toString() {
        return super.toString() + ", Salary: " + calculateSalary();
    }
}


class ResearchAssistant extends Staff {
    private double stipend;
    private double researchGrant;

    public ResearchAssistant(String name, int id, String department, double stipend, double researchGrant) {
        super(name, id, department);
        this.stipend = stipend;
        this.researchGrant = researchGrant;
    }

    @Override
    public double calculateSalary() {
        return stipend + researchGrant;
    }

    @Override
    public String toString() {
        return super.toString() + ", Salary: " + calculateSalary();
    }
}


public class UniversityPayroll {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Staff[] staffArray = new Staff[4];

       
        System.out.println("Enter details for a Professor:");
        staffArray[0] = new Professor(scanner.next(), scanner.nextInt(), scanner.next(), scanner.nextDouble());
        
        System.out.println("Enter details for a Lecturer:");
        staffArray[1] = new Lecturer(scanner.next(), scanner.nextInt(), scanner.next(), scanner.nextInt(), scanner.nextDouble());
        
        System.out.println("Enter details for an Administrator:");
        staffArray[2] = new Administrator(scanner.next(), scanner.nextInt(), scanner.next(), scanner.nextDouble(), scanner.nextDouble());
        
        System.out.println("Enter details for a Research Assistant:");
        staffArray[3] = new ResearchAssistant(scanner.next(), scanner.nextInt(), scanner.next(), scanner.nextDouble(), scanner.nextDouble());
        
       
        System.out.println("\nStaff Details and Salaries:");
        for (Staff staff : staffArray) {
            if (staff instanceof Professor) {
                System.out.println("Professor: " + staff);
            } else if (staff instanceof Lecturer) {
                System.out.println("Lecturer: " + staff);
            } else if (staff instanceof Administrator) {
                System.out.println("Administrator: " + staff);
            } else if (staff instanceof ResearchAssistant) {
                System.out.println("Research Assistant: " + staff);
            }
        }

        scanner.close();
    }
}
