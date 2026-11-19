import java.util.Scanner;
class PeakElement{
    static int search(int[] a){
        int left=0;
        int right=a.length-1;
        while(left<right){
            int mid=left+(right-left)/2;
            if(a[mid]<a[mid+1])
                left=mid+1;
            else
                right=mid;
        }
        return left;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter size: ");
        int n=sc.nextInt();
        int[] a=new int[n];
        System.out.println("Enter array elements:");
        for(int i=0;i<n;i++)
            a[i]=sc.nextInt();
        int index=search(a);
        System.out.println("Peak element: "+a[index]);
        System.out.println("Index: "+index);
    }
}