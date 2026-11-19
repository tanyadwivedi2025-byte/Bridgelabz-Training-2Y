import java.util.Scanner;
class CountingSort{
    static void sort(int[] a){
        int[] count=new int[9];
        for(int i=0;i<a.length;i++)
            count[a[i]-10]++;
        int k=0;
        for(int i=0;i<count.length;i++){
            while(count[i]>0){
                a[k++]=i+10;
                count[i]--;
            }
        }
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n=sc.nextInt();
        int[] a=new int[n];
        System.out.println("Enter student ages (10-18):");
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
            if(a[i]<10||a[i]>18){
                System.out.println("Invalid age");
                return;
            }
        }
        sort(a);
        System.out.println("Sorted ages:");
        for(int i=0;i<n;i++)
            System.out.print(a[i]+" ");
    }
}