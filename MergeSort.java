import java.util.Scanner;
class MergeSort{
    static void merge(int[] a,int l,int m,int r){
        int n1=m-l+1;
        int n2=r-m;
        int[] left=new int[n1];
        int[] right=new int[n2];
        for(int i=0;i<n1;i++)
            left[i]=a[l+i];
        for(int j=0;j<n2;j++)
            right[j]=a[m+1+j];
        int i=0,j=0,k=l;
        while(i<n1&&j<n2){
            if(left[i]<=right[j])
                a[k++]=left[i++];
            else
                a[k++]=right[j++];
        }
        while(i<n1)
            a[k++]=left[i++];
        while(j<n2)
            a[k++]=right[j++];
    }
    static void sort(int[] a,int l,int r){
        if(l<r){
            int m=(l+r)/2;
            sort(a,l,m);
            sort(a,m+1,r);
            merge(a,l,m,r);
        }
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter size: ");
        int n=sc.nextInt();
        int[] a=new int[n];
        System.out.println("Enter book prices:");
        for(int i=0;i<n;i++)
            a[i]=sc.nextInt();
        sort(a,0,n-1);
        System.out.println("Sorted prices:");
        for(int i=0;i<n;i++)
            System.out.print(a[i]+" ");
    }
}