package Level2;
import java.util.Scanner;
public class BMICalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of persons: ");
        int number = sc.nextInt();
        double[] weight = new double[number];
        double[] height = new double[number];
        double[] bmi = new double[number];
        String[] status = new String[number];
        for (int i = 0; i < number; i++) {
            System.out.print("Enter weight of person " + (i + 1) + " in kg: ");
            weight[i] = sc.nextDouble();
            System.out.print("Enter height of person " + (i + 1) + " in meters: ");
            height[i] = sc.nextDouble();
            bmi[i] = weight[i] / (height[i] * height[i]);
            if (bmi[i] <= 18.4) {
                status[i] = "Underweight";
            } else if (bmi[i] <= 24.9) {
                status[i] = "Normal";
            } else if (bmi[i] <= 39.9) {
                status[i] = "Overweight";
            } else {
                status[i] = "Obese";
            }
        }
        System.out.println("\nResult:");
        for (int i = 0; i < number; i++) {
            System.out.println("Person " + (i + 1)
                    + " | Height = " + height[i]
                    + " | Weight = " + weight[i]
                    + " | BMI = " + bmi[i]
                    + " | Status = " + status[i]);
        }
        sc.close();
    }
}