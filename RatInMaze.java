import java.util.Scanner;
class RatInMaze{
    static boolean solve(int[][] a,int[][] path,int r,int c,int n){
        if(r==n-1&&c==n-1){
            path[r][c]=1;
            return true;
        }
        if(r<0||c<0||r>=n||c>=n||a[r][c]==0||path[r][c]==1)
            return false;
        path[r][c]=1;
        if(solve(a,path,r+1,c,n))
            return true;
        if(solve(a,path,r,c+1,n))
            return true;
        if(solve(a,path,r-1,c,n))
            return true;
        if(solve(a,path,r,c-1,n))
            return true;
        path[r][c]=0;
        return false;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter size: ");
        int n=sc.nextInt();
        int[][] a=new int[n][n];
        int[][] path=new int[n][n];
        System.out.println("Enter maze (1=Open, 0=Blocked):");
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                a[i][j]=sc.nextInt();
        if(solve(a,path,0,0,n)){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++)
                    System.out.print(path[i][j]+" ");
                System.out.println();
            }
        }
        else
            System.out.println("Path not found");
    }
}