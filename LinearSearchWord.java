import java.util.Scanner;
class LinearSearchWord{
    static String search(String[] a,String word){
        for(int i=0;i<a.length;i++){
            if(a[i].contains(word))
                return a[i];
        }
        return "Not Found";
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter number of sentences: ");
        int n=sc.nextInt();
        sc.nextLine();
        String[] a=new String[n];
        for(int i=0;i<n;i++){
            System.out.print("Enter sentence: ");
            a[i]=sc.nextLine();
        }
        System.out.print("Enter word to search: ");
        String word=sc.nextLine();
        System.out.println(search(a,word));
    }
}