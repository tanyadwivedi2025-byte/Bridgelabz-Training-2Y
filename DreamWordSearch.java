import java.util.Scanner;
class DreamWordSearch{
    static int[] dr={-1,-1,-1,0,0,1,1,1};
    static int[] dc={-1,0,1,-1,1,-1,0,1};
    static boolean search(char[][] a,boolean[][] visited,String word,int r,int c,int index){
        if(index==word.length())
            return true;
        if(r<0||c<0||r>=4||c>=4||visited[r][c]||a[r][c]!=word.charAt(index))
            return false;
        visited[r][c]=true;
        for(int i=0;i<8;i++){
            if(search(a,visited,word,r+dr[i],c+dc[i],index+1))
                return true;
        }
        visited[r][c]=false;
        return false;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        char[][] a=new char[4][4];
        System.out.println("Enter 4x4 grid:");
        for(int i=0;i<4;i++)
            for(int j=0;j<4;j++)
                a[i][j]=sc.next().charAt(0);
        System.out.print("Enter word: ");
        String word=sc.next();
        boolean found=false;
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                if(search(a,new boolean[4][4],word,i,j,0)){
                    found=true;
                    break;
                }
            }
            if(found)break;
        }
        System.out.println(found?"Word Found":"Word Not Found");
    }
}