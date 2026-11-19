import java.util.Scanner;
class Search2DMatrix{
    static boolean search(int[][] a,int target){
        int rows=a.length;
        int cols=a[0].length;
        int left=0;
        int right=rows*cols-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            int row=mid/cols;
            int col=mid%cols;
            if(a[row][col]==target)
                return true;
            else if(a[row][col]<target)
                left=mid+1;
            else
                right=mid-1;
        }
        return false;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter rows and columns: ");
        int r=sc.nextInt();
        int c=sc.nextInt();
        int[][] a=new int[r][c];
        System.out.println("Enter matrix elements:");
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++)
                a[i][j]=sc.nextInt();
        }
        System.out.print("Enter target: ");
        int target=sc.nextInt();
        if(search(a,target))
            System.out.println("Element found");
        else
            System.out.println("Element not found");
    }
}