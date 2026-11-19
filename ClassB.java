import java.util.Scanner;
class B{
    static int findLength(String s){
        int count=0;
        for(char ch:s.toCharArray())
            count++;
        return count;
    }
    static char[] uniqueCharacters(String s){
        int n=findLength(s);
        char[] temp=new char[n];
        int count=0;
        for(int i=0;i<n;i++){
            boolean found=false;
            for(int j=0;j<i;j++){
                if(s.charAt(i)==s.charAt(j)){
                    found=true;
                    break;
                }
            }
            if(!found)
                temp[count++]=s.charAt(i);
        }
        char[] result=new char[count];
        for(int i=0;i<count;i++)
            result[i]=temp[i];
        return result;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter string: ");
        String s=sc.nextLine();
        char[] r=uniqueCharacters(s);
        for(char ch:r)
            System.out.print(ch+" ");
    }
}