package Level1;
import java.util.Scanner;
public class ArraySum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] numbers = new double[10];
        double total = 0.0;
        int index = 0;
        while (true) {
            System.out.print("Enter a number: ");
            double number = sc.nextDouble();
            if (number <= 0) {
                break;
            }
            if (index == 10) {
                break;
            }
            numbers[index] = number;
            index++;
        }
        for (int i = 0; i < index; i++) {
            total = total + numbers[i];
        }
        System.out.println("Total = " + total);
        sc.close();
    }
}