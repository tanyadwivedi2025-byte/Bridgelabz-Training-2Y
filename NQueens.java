import java.util.Scanner;
class NQueens{
    static boolean safe(int[][] a,int row,int col,int n){
        for(int i=0;i<row;i++){
            if(a[i][col]==1)
                return false;
        }
        for(int i=row-1,j=col-1;i>=0&&j>=0;i--,j--){
            if(a[i][j]==1)
                return false;
        }
        for(int i=row-1,j=col+1;i>=0&&j<n;i--,j++){
            if(a[i][j]==1)
                return false;
        }
        return true;
    }
    static boolean solve(int[][] a,int row,int n){
        if(row==n)
            return true;
        for(int col=0;col<n;col++){
            if(safe(a,row,col,n)){
                a[row][col]=1;
                if(solve(a,row+1,n))
                    return true;
                a[row][col]=0;
            }
        }
        return false;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter N: ");
        int n=sc.nextInt();
        int[][] a=new int[n][n];
        if(solve(a,0,n)){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++)
                    System.out.print(a[i][j]+" ");
                System.out.println();
            }
        }
        else
            System.out.println("No solution");
    }
}