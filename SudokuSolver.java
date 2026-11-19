import java.util.Scanner;
class SudokuSolver{
    static boolean safe(int[][] a,int row,int col,int num){
        for(int i=0;i<9;i++){
            if(a[row][i]==num||a[i][col]==num)
                return false;
        }
        int sr=(row/3)*3;
        int sc=(col/3)*3;
        for(int i=sr;i<sr+3;i++){
            for(int j=sc;j<sc+3;j++){
                if(a[i][j]==num)
                    return false;
            }
        }
        return true;
    }
    static boolean solve(int[][] a){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(a[i][j]==0){
                    for(int num=1;num<=9;num++){
                        if(safe(a,i,j,num)){
                            a[i][j]=num;
                            if(solve(a))
                                return true;
                            a[i][j]=0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int[][] a=new int[9][9];
        System.out.println("Enter Sudoku (use 0 for empty cells):");
        for(int i=0;i<9;i++)
            for(int j=0;j<9;j++)
                a[i][j]=sc.nextInt();
        if(solve(a)){
            for(int i=0;i<9;i++){
                for(int j=0;j<9;j++)
                    System.out.print(a[i][j]+" ");
                System.out.println();
            }
        }
        else
            System.out.println("No solution");
    }
}