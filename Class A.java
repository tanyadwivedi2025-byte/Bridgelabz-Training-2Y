import java.util.Scanner;
class A{
    static String[][] calculateBMI(double[][] data){
        String[][] result=new String[10][4];
        for(int i=0;i<10;i++){
            double w=data[i][0];
            double h=data[i][1]/100;
            double bmi=w/(h*h);
            String status;
            if(bmi<=18.4)
                status="Underweight";
            else if(bmi<25)
                status="Normal";
            else if(bmi<40)
                status="Overweight";
            else
                status="Obese";
            result[i][0]=String.valueOf(data[i][1]);
            result[i][1]=String.valueOf(w);
            result[i][2]=String.format("%.2f",bmi);
            result[i][3]=status;
        }
        return result;
    }
    static void display(String[][] r){
        System.out.println("Height\tWeight\tBMI\tStatus");
        for(int i=0;i<10;i++){
            for(int j=0;j<4;j++)
                System.out.print(r[i][j]+"\t");
            System.out.println();
        }
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        double[][] data=new double[10][2];
        for(int i=0;i<10;i++){
            System.out.print("Enter weight and height: ");
            data[i][0]=sc.nextDouble();
            data[i][1]=sc.nextDouble();
        }
        String[][] r=calculateBMI(data);
        display(r);
    }
}