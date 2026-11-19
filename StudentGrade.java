package Level2;
import java.util.Scanner;
public class StudentGrade {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int number = sc.nextInt();
        int[] physics = new int[number];
        int[] chemistry = new int[number];
        int[] maths = new int[number];
        double[] percentage = new double[number];
        char[] grade = new char[number];
        for (int i = 0; i < number; i++) {
            System.out.print("Enter Physics marks for student " + (i + 1) + ": ");
            physics[i] = sc.nextInt();
            System.out.print("Enter Chemistry marks: ");
            chemistry[i] = sc.nextInt();
            System.out.print("Enter Maths marks: ");
            maths[i] = sc.nextInt();
            if (physics[i] < 0 || chemistry[i] < 0 || maths[i] < 0) {
                System.out.println("Marks cannot be negative. Enter again.");
                i--;
            }
        }
        for (int i = 0; i < number; i++) {
            int total = physics[i] + chemistry[i] + maths[i];
            percentage[i] = total / 3.0;
            if (percentage[i] >= 80) {
                grade[i] = 'A';
            } else if (percentage[i] >= 70) {
                grade[i] = 'B';
            } else if (percentage[i] >= 60) {
                grade[i] = 'C';
            } else if (percentage[i] >= 50) {
                grade[i] = 'D';
            } else if (percentage[i] >= 40) {
                grade[i] = 'E';
            } else {
                grade[i] = 'R';
            }
        }
        System.out.println("\nResult:");
        for (int i = 0; i < number; i++) {
            System.out.println("Student " + (i + 1)
                    + " | Physics = " + physics[i]
                    + " | Chemistry = " + chemistry[i]
                    + " | Maths = " + maths[i]
                    + " | Percentage = " + percentage[i]
                    + " | Grade = " + grade[i]);
        }
        sc.close();
    }
}
