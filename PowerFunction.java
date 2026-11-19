import java.util.Scanner;
class PowerFunction{
    static long power(int x,int n){
        if(n==0)
            return 1;
        long half=power(x,n/2);
        if(n%2==0)
            return half*half;
        return x*half*half;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter base and power: ");
        int x=sc.nextInt();
        int n=sc.nextInt();
        if(n<0){
            System.out.println("Enter non-negative power");
            return;
        }
        System.out.println("Answer: "+power(x,n));
    }
}