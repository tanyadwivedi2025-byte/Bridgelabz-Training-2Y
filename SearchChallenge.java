import java.util.Scanner;
import java.util.Arrays;
class SearchChallenge{
    static int firstMissingPositive(int[] a){
        int n=a.length;
        boolean[] visited=new boolean[n+2];
        for(int i=0;i<n;i++){
            if(a[i]>0&&a[i]<=n+1)
                visited[a[i]]=true;
        }
        for(int i=1;i<=n+1;i++){
            if(!visited[i])
                return i;
        }
        return n+1;
    }
    static int binarySearch(int[] a,int target){
        int left=0;
        int right=a.length-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(a[mid]==target)
                return mid;
            else if(a[mid]<target)
                left=mid+1;
            else
                right=mid-1;
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
        int missing=firstMissingPositive(a);
        System.out.println("First missing positive: "+missing);
        Arrays.sort(a);
        System.out.print("Enter target: ");
        int target=sc.nextInt();
        int index=binarySearch(a,target);
        System.out.println("Sorted array:");
        for(int i=0;i<n;i++)
            System.out.print(a[i]+" ");
        System.out.println();
        System.out.println("Target index: "+index);
    }
}