import java.util.Scanner;
class GraphColoring{
    static boolean safe(int[][] graph,int[] color,int v,int c,int n){
        for(int i=0;i<n;i++){
            if(graph[v][i]==1&&color[i]==c)
                return false;
        }
        return true;
    }
    static boolean solve(int[][] graph,int[] color,int v,int n,int m){
        if(v==n)
            return true;
        for(int c=1;c<=m;c++){
            if(safe(graph,color,v,c,n)){
                color[v]=c;
                if(solve(graph,color,v+1,n,m))
                    return true;
                color[v]=0;
            }
        }
        return false;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter vertices: ");
        int n=sc.nextInt();
        int[][] graph=new int[n][n];
        System.out.println("Enter adjacency matrix:");
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                graph[i][j]=sc.nextInt();
        System.out.print("Enter number of colors: ");
        int m=sc.nextInt();
        int[] color=new int[n];
        if(solve(graph,color,0,n,m)){
            for(int i=0;i<n;i++)
                System.out.println("Vertex "+i+" : Color "+color[i]);
        }
        else
            System.out.println("Coloring not possible");
    }
}