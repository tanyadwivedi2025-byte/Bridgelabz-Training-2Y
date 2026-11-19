import java.util.Scanner;
class F{
    static String[] frequency(String s){
        int n=s.length();
        int[] freq=new int[n];
        char[] ch=new char[n];
        for(int i=0;i<n;i++){
            ch[i]=s.charAt(i);
            freq[i]=1;
        }
        for(int i=0;i<n;i++){
            if(freq[i]==0)
                continue;
            for(int j=i+1;j<n;j++){
                if(ch[i]==ch[j]){
                    freq[i]++;
                    freq[j]=0;
                }
            }
        }
        String[] temp=new String[n];
        int k=0;
        for(int i=0;i<n;i++){
            if(freq[i]>0)
                temp[k++]=ch[i]+" : "+freq[i];
        }
        String[] r=new String[k];
        for(int i=0;i<k;i++)
            r[i]=temp[i];
        return r;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter string: ");
        String s=sc.nextLine();
        String[] r=frequency(s);
        for(String x:r)
            System.out.println(x);
    }
}