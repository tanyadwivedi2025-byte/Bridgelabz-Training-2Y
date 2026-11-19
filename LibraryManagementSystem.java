import java.util.Scanner;
class LibraryManagementSystem{
    static class Node{
        String title,author,genre;
        int id;
        boolean available;
        Node next,prev;
        Node(String t,String a,String g,int i,boolean av){
            title=t;
            author=a;
            genre=g;
            id=i;
            available=av;
        }
    }
    static Node head,tail;
    static void insert(String t,String a,String g,int id,boolean av,int pos){
        Node n=new Node(t,a,g,id,av);
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
    static void delete(int id){
        Node p=head;
        while(p!=null&&p.id!=id)
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
    static void search(String key){
        Node p=head;
        while(p!=null){
            if(p.title.equalsIgnoreCase(key)||p.author.equalsIgnoreCase(key))
                System.out.println(p.title+" "+p.author+" "+p.id);
            p=p.next;
        }
    }
    static void update(int id,boolean av){
        Node p=head;
        while(p!=null){
            if(p.id==id){
                p.available=av;
                return;
            }
            p=p.next;
        }
    }
    static void display(){
        Node p=head;
        while(p!=null){
            System.out.println(p.title+" "+p.author+" "+p.genre+" "+p.id+" "+p.available);
            p=p.next;
        }
    }
    static void reverse(){
        Node p=tail;
        while(p!=null){
            System.out.println(p.title+" "+p.author+" "+p.genre+" "+p.id+" "+p.available);
            p=p.prev;
        }
    }
    static void count(){
        int c=0;
        Node p=head;
        while(p!=null){
            c++;
            p=p.next;
        }
        System.out.println("Total books: "+c);
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(true){
            System.out.println("1.Insert 2.Delete 3.Search 4.Update 5.Forward 6.Reverse 7.Count 8.Exit");
            int ch=sc.nextInt();
            if(ch==1){
                System.out.print("Title Author Genre ID Available(true/false) Position: ");
                String t=sc.next();
                String a=sc.next();
                String g=sc.next();
                int id=sc.nextInt();
                boolean av=sc.nextBoolean();
                int pos=sc.nextInt();
                insert(t,a,g,id,av,pos);
            }
            else if(ch==2)
                delete(sc.nextInt());
            else if(ch==3)
                search(sc.next());
            else if(ch==4)
                update(sc.nextInt(),sc.nextBoolean());
            else if(ch==5)
                display();
            else if(ch==6)
                reverse();
            else if(ch==7)
                count();
            else
                break;
        }
    }
}