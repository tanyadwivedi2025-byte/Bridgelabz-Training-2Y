package Level2;
import java.util.Scanner;
public class BMIMultiArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of persons: ");
        int number = sc.nextInt();
        double[][] personData = new double[number][3];
        String[] weightStatus = new String[number];
        for (int i = 0; i < number; i++) {
            System.out.print("Enter weight of person " + (i + 1) + " in kg: ");
            personData[i][0] = sc.nextDouble();
            System.out.print("Enter height of person " + (i + 1) + " in meters: ");
            personData[i][1] = sc.nextDouble();
            personData[i][2] = personData[i][0] /
                    (personData[i][1] * personData[i][1]);
            if (personData[i][2] <= 18.4) {
                weightStatus[i] = "Underweight";
            } else if (personData[i][2] <= 24.9) {
                weightStatus[i] = "Normal";
            } else if (personData[i][2] <= 39.9) {
                weightStatus[i] = "Overweight";
            } else {
                weightStatus[i] = "Obese";
            }
        }
        System.out.println("\nResult:");
        for (int i = 0; i < number; i++) {
            System.out.println("Person " + (i + 1)
                    + " | Weight = " + personData[i][0]
                    + " | Height = " + personData[i][1]
                    + " | BMI = " + personData[i][2]
                    + " | Status = " + weightStatus[i]);
        }
        sc.close();
    }
}