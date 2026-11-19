import java.util.Scanner;
class TaskScheduler{
    static class Node{
        int id,priority;
        String name,date;
        Node next;
        Node(int i,String n,int p,String d){
            id=i;
            name=n;
            priority=p;
            date=d;
        }
    }
    static Node head,tail,current;
    static void insert(int id,String name,int priority,String date,int pos){
        Node n=new Node(id,name,priority,date);
        if(head==null){
            head=tail=n;
            n.next=head;
            current=head;
            return;
        }
        if(pos==1){
            n.next=head;
            head=n;
            tail.next=head;
            return;
        }
        Node p=head;
        for(int i=1;i<pos-1&&p.next!=head;i++)
            p=p.next;
        n.next=p.next;
        p.next=n;
        if(p==tail)
            tail=n;
        tail.next=head;
    }
    static void delete(int id){
        if(head==null)return;
        Node p=head,prev=tail;
        do{
            if(p.id==id){
                if(p==head)
                    head=head.next;
                if(p==tail)
                    tail=prev;
                prev.next=p.next;
                if(p==head&&p==tail){
                    head=tail=null;
                    current=null;
                    return;
                }
                tail.next=head;
                if(current==p)
                    current=p.next;
                return;
            }
            prev=p;
            p=p.next;
        }while(p!=head);
        System.out.println("Task not found");
    }
    static void display(){
        if(head==null)return;
        Node p=head;
        do{
            System.out.println(p.id+" "+p.name+" "+p.priority+" "+p.date);
            p=p.next;
        }while(p!=head);
    }
    static void search(int priority){
        if(head==null)return;
        Node p=head;
        do{
            if(p.priority==priority)
                System.out.println(p.id+" "+p.name+" "+p.date);
            p=p.next;
        }while(p!=head);
    }
    static void nextTask(){
        if(current==null){
            System.out.println("No tasks");
            return;
        }
        System.out.println(current.id+" "+current.name+" "+current.priority+" "+current.date);
        current=current.next;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(true){
            System.out.println("1.Insert 2.Delete 3.Current/Next 4.Display 5.Search 6.Exit");
            int ch=sc.nextInt();
            if(ch==1){
                System.out.print("ID Name Priority Date Position: ");
                int id=sc.nextInt();
                String n=sc.next();
                int p=sc.nextInt();
                String d=sc.next();
                int pos=sc.nextInt();
                insert(id,n,p,d,pos);
            }
            else if(ch==2)
                delete(sc.nextInt());
            else if(ch==3)
                nextTask();
            else if(ch==4)
                display();
            else if(ch==5)
                search(sc.nextInt());
            else
                break;
        }
    }
}