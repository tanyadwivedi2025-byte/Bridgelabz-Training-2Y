import java.util.Scanner;
class G{
    static boolean palindrome1(String s){
        int start=0,end=s.length()-1;
        while(start<end){
            if(s.charAt(start)!=s.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }
    static boolean palindrome2(String s,int start,int end){
        if(start>=end)
            return true;
        if(s.charAt(start)!=s.charAt(end))
            return false;
        return palindrome2(s,start+1,end-1);
    }
    static char[] reverse(String s){
        char[] a=s.toCharArray();
        char[] r=new char[a.length];
        for(int i=0;i<a.length;i++)
            r[i]=a[a.length-1-i];
        return r;
    }
    static boolean palindrome3(String s){
        char[] a=s.toCharArray();
        char[] r=reverse(s);
        for(int i=0;i<a.length;i++){
            if(a[i]!=r[i])
                return false;
        }
        return true;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter string: ");
        String s=sc.nextLine();
        System.out.println("Logic 1: "+palindrome1(s));
        System.out.println("Logic 2: "+palindrome2(s,0,s.length()-1));
        System.out.println("Logic 3: "+palindrome3(s));
    }
}