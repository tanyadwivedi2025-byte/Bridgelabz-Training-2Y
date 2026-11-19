import java.util.Scanner;
class FirstLastOccurrence{
    static int first(int[] a,int target){
        int left=0,right=a.length-1;
        int ans=-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(a[mid]==target){
                ans=mid;
                right=mid-1;
            }
            else if(a[mid]<target)
                left=mid+1;
            else
                right=mid-1;
        }
        return ans;
    }
    static int last(int[] a,int target){
        int left=0,right=a.length-1;
        int ans=-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(a[mid]==target){
                ans=mid;
                left=mid+1;
            }
            else if(a[mid]<target)
                left=mid+1;
            else
                right=mid-1;
        }
        return ans;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter size: ");
        int n=sc.nextInt();
        int[] a=new int[n];
        System.out.println("Enter sorted array:");
        for(int i=0;i<n;i++)
            a[i]=sc.nextInt();
        System.out.print("Enter target: ");
        int target=sc.nextInt();
        System.out.println("First occurrence: "+first(a,target));
        System.out.println("Last occurrence: "+last(a,target));
    }
}