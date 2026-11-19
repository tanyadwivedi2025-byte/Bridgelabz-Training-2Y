import java.util.Scanner;
class MovieManagementSystem{
    static class Node{
        String title,director;
        int year;
        double rating;
        Node next,prev;
        Node(String t,String d,int y,double r){
            title=t;
            director=d;
            year=y;
            rating=r;
        }
    }
    static Node head,tail;
    static void insert(String t,String d,int y,double r,int pos){
        Node n=new Node(t,d,y,r);
        if(head==null){
            head=tail=n;
            return;
        }
        if(pos==1){
            n.next=head;
            head.prev=n;
            head=n;
            return;
        }
        Node p=head;
        for(int i=1;p.next!=null&&i<pos-1;i++)
            p=p.next;
        n.next=p.next;
        n.prev=p;
        if(p.next!=null)
            p.next.prev=n;
        else
            tail=n;
        p.next=n;
    }
    static void delete(String t){
        Node p=head;
        while(p!=null&&!p.title.equalsIgnoreCase(t))
            p=p.next;
        if(p==null)return;
        if(p.prev!=null)
            p.prev.next=p.next;
        else
            head=p.next;
        if(p.next!=null)
            p.next.prev=p.prev;
        else
            tail=p.prev;
    }
    static void search(String d){
        Node p=head;
        while(p!=null){
            if(p.director.equalsIgnoreCase(d)||String.valueOf(p.rating).equals(d))
                System.out.println(p.title+" "+p.director+" "+p.year+" "+p.rating);
            p=p.next;
        }
    }
    static void update(String t,double r){
        Node p=head;
        while(p!=null){
            if(p.title.equalsIgnoreCase(t)){
                p.rating=r;
                return;
            }
            p=p.next;
        }
    }
    static void display(){
        Node p=head;
        while(p!=null){
            System.out.println(p.title+" "+p.director+" "+p.year+" "+p.rating);
            p=p.next;
        }
    }
    static void reverse(){
        Node p=tail;
        while(p!=null){
            System.out.println(p.title+" "+p.director+" "+p.year+" "+p.rating);
            p=p.prev;
        }
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(true){
            System.out.println("1.Insert 2.Delete 3.Search 4.Forward 5.Reverse 6.Update 7.Exit");
            int ch=sc.nextInt();
            if(ch==1){
                System.out.print("Title Director Year Rating Position: ");
                String t=sc.next();
                String d=sc.next();
                int y=sc.nextInt();
                double r=sc.nextDouble();
                int pos=sc.nextInt();
                insert(t,d,y,r,pos);
            }
            else if(ch==2)
                delete(sc.next());
            else if(ch==3)
                search(sc.next());
            else if(ch==4)
                display();
            else if(ch==5)
                reverse();
            else if(ch==6)
                update(sc.next(),sc.nextDouble());
            else
                break;
        }
    }
}