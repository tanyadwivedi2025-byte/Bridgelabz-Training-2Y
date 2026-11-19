package Level2;
import java.util.Scanner;
public class StudentGrade2D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int number = sc.nextInt();
        int[][] marks = new int[number][3];
        double[] percentage = new double[number];
        char[] grade = new char[number];
        for (int i = 0; i < number; i++) {
            System.out.println("Student " + (i + 1));
            System.out.print("Enter Physics marks: ");
            marks[i][0] = sc.nextInt();
            System.out.print("Enter Chemistry marks: ");
            marks[i][1] = sc.nextInt();
            System.out.print("Enter Maths marks: ");
            marks[i][2] = sc.nextInt();
            if (marks[i][0] < 0 || marks[i][1] < 0 || marks[i][2] < 0) {
                System.out.println("Marks cannot be negative. Enter again.");
                i--;
            }
        }
        for (int i = 0; i < number; i++) {
            int total = marks[i][0] + marks[i][1] + marks[i][2];
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
                    + " | Physics = " + marks[i][0]
                    + " | Chemistry = " + marks[i][1]
                    + " | Maths = " + marks[i][2]
                    + " | Percentage = " + percentage[i]
                    + " | Grade = " + grade[i]);
        }
        sc.close();
    }
}