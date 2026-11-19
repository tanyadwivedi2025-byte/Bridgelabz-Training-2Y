import java.util.Scanner;
class WordSearch{
    static boolean search(char[][] a,String word,int r,int c,int index){
        if(index==word.length())
            return true;
        if(r<0||c<0||r>=a.length||c>=a[0].length||a[r][c]!=word.charAt(index))
            return false;
        char ch=a[r][c];
        a[r][c]='#';
        boolean found=search(a,word,r+1,c,index+1)||
                search(a,word,r-1,c,index+1)||
                search(a,word,r,c+1,index+1)||
                search(a,word,r,c-1,index+1);
        a[r][c]=ch;
        return found;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter rows and columns: ");
        int r=sc.nextInt();
        int c=sc.nextInt();
        char[][] a=new char[r][c];
        System.out.println("Enter grid characters:");
        for(int i=0;i<r;i++)
            for(int j=0;j<c;j++)
                a[i][j]=sc.next().charAt(0);
        System.out.print("Enter word: ");
        String word=sc.next();
        boolean found=false;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(search(a,word,i,j,0)){
                    found=true;
                    break;
                }
            }
            if(found)break;
        }
        System.out.println(found?"Word Found":"Word Not Found");
    }
}