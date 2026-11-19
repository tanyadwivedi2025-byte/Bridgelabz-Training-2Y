import java.util.Scanner;
class LinearSearchNegative{
    static int search(int[] a){
        for(int i=0;i<a.length;i++){
            if(a[i]<0)
                return i;
        }
        return -1;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter size: ");
        int n=sc.nextInt();
        int[] a=new int[n];
        System.out.println("Enter array elements:");
        for(int i=0;i<n;i++)
            a[i]=sc.nextInt();
        int result=search(a);
        if(result==-1)
            System.out.println("Negative number not found");
        else
            System.out.println("First negative number index: "+result);
    }
}