import java.util.Scanner;
class QuickSort{
    static int partition(int[] a,int low,int high){
        int pivot=a[high];
        int i=low-1;
        for(int j=low;j<high;j++){
            if(a[j]<pivot){
                i++;
                int temp=a[i];
                a[i]=a[j];
                a[j]=temp;
            }
        }
        int temp=a[i+1];
        a[i+1]=a[high];
        a[high]=temp;
        return i+1;
    }
    static void sort(int[] a,int low,int high){
        if(low<high){
            int pi=partition(a,low,high);
            sort(a,low,pi-1);
            sort(a,pi+1,high);
        }
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter size: ");
        int n=sc.nextInt();
        int[] a=new int[n];
        System.out.println("Enter product prices:");
        for(int i=0;i<n;i++)
            a[i]=sc.nextInt();
        sort(a,0,n-1);
        System.out.println("Sorted prices:");
        for(int i=0;i<n;i++)
            System.out.print(a[i]+" ");
    }
}