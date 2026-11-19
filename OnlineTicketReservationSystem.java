import java.util.Scanner;
class OnlineTicketReservationSystem{
    static class Node{
        int id,seat;
        String customer,movie,time;
        Node next;
        Node(int i,String c,String m,int s,String t){
            id=i;
            customer=c;
            movie=m;
            seat=s;
            time=t;
        }
    }
    static Node head,tail;
    static void insert(int id,String c,String m,int s,String t){
        Node n=new Node(id,c,m,s,t);
        if(head==null){
            head=tail=n;
            n.next=head;
        }
        else{
            tail.next=n;
            tail=n;
            tail.next=head;
        }
        System.out.println("Ticket booked");
    }
    static void delete(int id){
        if(head==null)return;
        Node p=head,prev=tail;
        do{
            if(p.id==id){
                if(head==tail){
                    head=tail=null;
                    return;
                }
                if(p==head)
                    head=head.next;
                if(p==tail)
                    tail=prev;
                prev.next=p.next;
                tail.next=head;
                System.out.println("Ticket cancelled");
                return;
            }
            prev=p;
            p=p.next;
        }while(p!=head);
        System.out.println("Ticket not found");
    }
    static void display(){
        if(head==null){
            System.out.println("No tickets booked");
            return;
        }
        Node p=head;
        do{
            System.out.println(p.id+" "+p.customer+" "+p.movie+" "+p.seat+" "+p.time);
            p=p.next;
        }while(p!=head);
    }
    static void search(String key){
        if(head==null)return;
        Node p=head;
        boolean found=false;
        do{
            if(p.customer.equalsIgnoreCase(key)||p.movie.equalsIgnoreCase(key)){
                System.out.println(p.id+" "+p.customer+" "+p.movie+" "+p.seat+" "+p.time);
                found=true;
            }
            p=p.next;
        }while(p!=head);
        if(!found)
            System.out.println("Ticket not found");
    }
    static void count(){
        int c=0;
        if(head!=null){
            Node p=head;
            do{
                c++;
                p=p.next;
            }while(p!=head);
        }
        System.out.println("Total booked tickets: "+c);
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(true){
            System.out.println("1.Book Ticket 2.Cancel Ticket 3.Display 4.Search 5.Count 6.Exit");
            int ch=sc.nextInt();
            if(ch==1){
                System.out.print("ID Customer Movie Seat BookingTime: ");
                int id=sc.nextInt();
                String c=sc.next();
                String m=sc.next();
                int s=sc.nextInt();
                String t=sc.next();
                insert(id,c,m,s,t);
            }
            else if(ch==2)
                delete(sc.nextInt());
            else if(ch==3)
                display();
            else if(ch==4)
                search(sc.next());
            else if(ch==5)
                count();
            else
                break;
        }
    }
}