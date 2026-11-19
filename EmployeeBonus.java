package Level2;
import java.util.Scanner;
public class EmployeeBonus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] salary = new double[10];
        double[] years = new double[10];
        double totalBonus = 0;
        double totalOldSalary = 0;
        double totalNewSalary = 0;
        for (int i = 0; i < 10; i++) {
            System.out.print("Enter salary of employee " + (i + 1) + ": ");
            salary[i] = sc.nextDouble();
            System.out.print("Enter years of service: ");
            years[i] = sc.nextDouble();
            if (years[i] < 0) {
                System.out.println("Invalid years. Please enter again.");
                i--;
            }
        }
        for (int i = 0; i < 10; i++) {
            double bonus;
            if (years[i] > 5) {
                bonus = salary[i] * 0.05;
            } else {
                bonus = salary[i] * 0.02;
            }
            double newSalary = salary[i] + bonus;
            totalBonus = totalBonus + bonus;
            totalOldSalary = totalOldSalary + salary[i];
            totalNewSalary = totalNewSalary + newSalary;
            System.out.println("Employee " + (i + 1) +
                    " Bonus = " + bonus +
                    ", New Salary = " + newSalary);
        }
        System.out.println("\nTotal Old Salary = " + totalOldSalary);
        System.out.println("Total Bonus = " + totalBonus);
        System.out.println("Total New Salary = " + totalNewSalary);
        sc.close();
    }
}