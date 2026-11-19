import java.util.Scanner;
class ArraySum{
    static int sum(int[] a,int n){
        if(n==0)
            return 0;
        return a[n-1]+sum(a,n-1);
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter size: ");
        int n=sc.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++)
            a[i]=sc.nextInt();
        System.out.println("Sum: "+sum(a,n));
    }
}