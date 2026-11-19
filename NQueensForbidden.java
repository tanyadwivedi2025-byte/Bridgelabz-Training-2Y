import java.util.Scanner;
class NQueensForbidden{
    static int[] board;
    static boolean[][] blocked;
    static boolean[] col,left,right;
    static boolean solve(int row,int n){
        if(row==n)
            return true;
        for(int c=0;c<n;c++){
            int d1=row-c+n-1;
            int d2=row+c;
            if(!blocked[row][c]&&!col[c]&&!left[d1]&&!right[d2]){
                board[row]=c;
                col[c]=true;
                left[d1]=true;
                right[d2]=true;
                if(solve(row+1,n))
                    return true;
                col[c]=false;
                left[d1]=false;
                right[d2]=false;
            }
        }
        return false;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter N: ");
        int n=sc.nextInt();
        if(n<=0)return;
        board=new int[n];
        blocked=new boolean[n][n];
        col=new boolean[n];
        left=new boolean[2*n-1];
        right=new boolean[2*n-1];
        System.out.print("Enter number of forbidden squares: ");
        int k=sc.nextInt();
        System.out.println("Enter row and column (0-based):");
        for(int i=0;i<k;i++){
            int r=sc.nextInt();
            int c=sc.nextInt();
            if(r>=0&&r<n&&c>=0&&c<n)
                blocked[r][c]=true;
        }
        if(solve(0,n)){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++)
                    System.out.print(board[i]==j?"Q ":blocked[i][j]?"X ":". ");
                System.out.println();
            }
        }
        else
            System.out.println("No solution");
    }
}