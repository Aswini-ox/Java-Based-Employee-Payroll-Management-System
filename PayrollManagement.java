import java.util.ArrayList;
import java.util.Scanner;

class Employee {
    private int id;
    private String name;
    private double basicSalary;
    private double hra;
    private double da;
    private double deductions;

    // ANSI escape codes for colors
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";

    public Employee(int id, String name, double basicSalary, double hra, double da, double deductions) {
        this.id = id;
        this.name = name;
        this.basicSalary = basicSalary;
        this.hra = hra;
        this.da = da;
        this.deductions = deductions;
    }

    public double calculateNetSalary() {
        return basicSalary + hra + da - deductions;
    }

    public void printPaySlip() {
        System.out.println(CYAN + "===========================================" + RESET);
        System.out.println(PURPLE + "               PAY SLIP" + RESET);
        System.out.println(CYAN + "===========================================" + RESET);
        System.out.println(YELLOW + "Employee ID   : " + RESET + id);
        System.out.println(YELLOW + "Employee Name : " + RESET + name);
        System.out.println(CYAN + "-------------------------------------------" + RESET);
        System.out.printf(YELLOW + "%-20s" + RESET + " : %.2f\n", "Basic Salary", basicSalary);
        System.out.printf(YELLOW + "%-20s" + RESET + " : %.2f\n", "HRA", hra);
        System.out.printf(YELLOW + "%-20s" + RESET + " : %.2f\n", "DA", da);
        System.out.printf(YELLOW + "%-20s" + RESET + " : %.2f\n", "Deductions", deductions);
        System.out.println(CYAN + "-------------------------------------------" + RESET);
        System.out.printf(GREEN + "%-20s" + RESET + " : %.2f\n", "Net Salary", calculateNetSalary());
        System.out.println(CYAN + "===========================================\n" + RESET);
    }
}

public class PayrollManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Employee> employees = new ArrayList<>();
        int choice;

        do {
            System.out.println(Employee.BLUE + "========= Employee Payroll Management System =========" + Employee.RESET);
            System.out.println("1. Add Employee");
            System.out.println("2. Display All Pay Slips");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch(choice) {
                case 1:
                    System.out.print("Enter Employee ID: ");
                    int id = sc.nextInt();
                    sc.nextLine(); 
                    System.out.print("Enter Employee Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Basic Salary: ");
                    double basicSalary = sc.nextDouble();
                    System.out.print("Enter HRA: ");
                    double hra = sc.nextDouble();
                    System.out.print("Enter DA: ");
                    double da = sc.nextDouble();
                    System.out.print("Enter Deductions: ");
                    double deductions = sc.nextDouble();

                    Employee emp = new Employee(id, name, basicSalary, hra, da, deductions);
                    employees.add(emp);
                    System.out.println(Employee.GREEN + "\nEmployee added successfully!\n" + Employee.RESET);
                    break;

                case 2:
                    if (employees.isEmpty()) {
                        System.out.println(Employee.RED + "\nNo employees found.\n" + Employee.RESET);
                    } else {
                        System.out.println(Employee.BLUE + "\n========== All Employee Pay Slips ==========\n" + Employee.RESET);
                        for (Employee e : employees) {
                            e.printPaySlip();
                        }
                    }
                    break;

                case 3:
                    System.out.println(Employee.PURPLE + "Exiting... Thank you!" + Employee.RESET);
                    break;

                default:
                    System.out.println(Employee.RED + "Invalid choice! Please try again.\n" + Employee.RESET);
            }
        } while(choice != 3);

        sc.close();
    }
}
