import java.util.Scanner;
class SubsetSum{
    static boolean found=false;
    static void solve(int[] a,int index,int sum,int target,String ans){
        if(sum==target){
            System.out.println(ans);
            found=true;
            return;
        }
        if(index==a.length)
            return;
        solve(a,index+1,sum+a[index],target,ans+a[index]+" ");
        solve(a,index+1,sum,target,ans);
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter size: ");
        int n=sc.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++)
            a[i]=sc.nextInt();
        System.out.print("Enter target: ");
        int target=sc.nextInt();
        solve(a,0,0,target,"");
        if(!found)
            System.out.println("No subset found");
    }
}