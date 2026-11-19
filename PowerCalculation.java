package Level2;
import java.util.Scanner;
public interface PowerCalculation {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter base: ");
        double base = sc.nextDouble();
        System.out.println("Enetr exponent: ");
        double exponent = sc.nextDouble();
        double result = Math.pow(base, exponent);
        System.out.println("Result = " + result);
        sc.close();
    }
}
