
import java.util.Scanner;
import java.util.Random;
public class StudentGrade {
    static int[][] generateMarks(int n) {
        Random r = new Random();
        int[][] marks = new int[n][3];
        for (int i = 0; i < n; i++) {
            marks[i][0] = r.nextInt(101);
            marks[i][1] = r.nextInt(101);
            marks[i][2] = r.nextInt(101);
        }
        return marks;
    }
    static double[][] calculateResult(int[][] marks) {
        double[][] result = new double[marks.length][3];
        for (int i = 0; i < marks.length; i++) {
            int total = marks[i][0] + marks[i][1] + marks[i][2];
            double average = total / 3.0;
            double percentage = (total / 300.0) * 100;
            result[i][0] = Math.round(total * 100.0) / 100.0;
            result[i][1] = Math.round(average * 100.0) / 100.0;
            result[i][2] = Math.round(percentage * 100.0) / 100.0;
        }
        return result;
    }
    static String[][] calculateGrade(double[][] result) {
        String[][] grade = new String[result.length][1];
        for (int i = 0; i < result.length; i++) {
            double percentage = result[i][2];
            if (percentage >= 80) grade[i][0] = "A";
            else if (percentage >= 70) grade[i][0] = "B";
            else if (percentage >= 60) grade[i][0] = "C";
            else if (percentage >= 50) grade[i][0] = "D";
            else if (percentage >= 40) grade[i][0] = "E";
            else grade[i][0] = "R";
        }
        return grade;
    }
    static void display(int[][] marks, double[][] result, String[][] grade) {
        System.out.println("Student\tPhysics\tChemistry\tMaths\tTotal\tAverage\tPercentage\tGrade");
        for (int i = 0; i < marks.length; i++) {
            System.out.println((i + 1) + "\t" + marks[i][0] + "\t" + marks[i][1] + "\t\t" + marks[i][2] + "\t" + result[i][0] + "\t" + result[i][1] + "\t" + result[i][2] + "%\t\t" + grade[i][0]);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        if (n <= 0) {
            System.out.println("Enter a positive number.");
            sc.close();
            return;
        }
        int[][] marks = generateMarks(n);
        double[][] result = calculateResult(marks);
        String[][] grade = calculateGrade(result);
        display(marks, result, grade);
        sc.close();
    }
}
