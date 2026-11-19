import java.util.Scanner;
class D{
    static String[][] frequency(String s){
        int[] freq=new int[256];
        for(int i=0;i<s.length();i++)
            freq[s.charAt(i)]++;
        int count=0;
        for(int i=0;i<256;i++){
            if(freq[i]>0)
                count++;
        }
        String[][] r=new String[count][2];
        int k=0;
        for(int i=0;i<256;i++){
            if(freq[i]>0){
                r[k][0]=String.valueOf((char)i);
                r[k][1]=String.valueOf(freq[i]);
                k++;
            }
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