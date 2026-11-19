import java.util.Scanner;
class I{
    static String getMonth(int m){
        String[] months={"January","February","March","April","May","June","July","August","September","October","November","December"};
        return months[m-1];
    }
    static boolean isLeapYear(int y){
        return y%400==0||(y%4==0&&y%100!=0);
    }
    static int getDays(int m,int y){
        int[] days={31,28,31,30,31,30,31,31,30,31,30,31};
        if(m==2&&isLeapYear(y))
            return 29;
        return days[m-1];
    }
    static int getFirstDay(int m,int y){
        int y0=y-(14-m)/12;
        int x=y0+y0/4-y0/100+y0/400;
        int m0=m+12*((14-m)/12)-2;
        return (1+x+31*m0/12)%7;
    }
    static void displayCalendar(int m,int y){
        System.out.println("\n"+getMonth(m)+" "+y);
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");
        int first=getFirstDay(m,y);
        int days=getDays(m,y);
        for(int i=0;i<first;i++)
            System.out.print("    ");
        for(int i=1;i<=days;i++){
            System.out.printf("%3d ",i);
            if((first+i)%7==0)
                System.out.println();
        }
        System.out.println();
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter month (1-12): ");
        int m=sc.nextInt();
        System.out.print("Enter year: ");
        int y=sc.nextInt();
        if(m>=1&&m<=12&&y>0)
            displayCalendar(m,y);
        else
            System.out.println("Invalid input");
    }
}