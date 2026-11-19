import java.util.Scanner;
class E{
    static char[] uniqueCharacters(String s){
        char[] temp=new char[s.length()];
        int count=0;
        for(int i=0;i<s.length();i++){
            boolean found=false;
            for(int j=0;j<count;j++){
                if(temp[j]==s.charAt(i)){
                    found=true;
                    break;
                }
            }
            if(!found)
                temp[count++]=s.charAt(i);
        }
        char[] r=new char[count];
        for(int i=0;i<count;i++)
            r[i]=temp[i];
        return r;
    }
    static String[][] frequency(String s){
        char[] unique=uniqueCharacters(s);
        String[][] r=new String[unique.length][2];
        for(int i=0;i<unique.length;i++){
            int count=0;
            for(int j=0;j<s.length();j++){
                if(unique[i]==s.charAt(j))
                    count++;
            }
            r[i][0]=String.valueOf(unique[i]);
            r[i][1]=String.valueOf(count);
        }
        return r;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter string: ");
        String s=sc.nextLine();
        String[][] r=frequency(s);
        System.out.println("Character\tFrequency");
        for(int i=0;i<r.length;i++)
            System.out.println(r[i][0]+"\t\t"+r[i][1]);
    }
}