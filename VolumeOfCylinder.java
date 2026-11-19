package Level1;
import java.util.Scanner;
public class VolumeOfCylinder {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter radius: ");
        double radius = sc.nextDouble();
        System.out.println("Enter height");
        double height = sc.nextDouble();
        double volume = Math.PI * radius * radius * height;
        System.out.println("Volume of Cylinder = " + volume);
        sc.close();
    }
}
