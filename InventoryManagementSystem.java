import java.util.Scanner;
class InventoryManagementSystem{
    static class Node{
        int id,quantity;
        String name;
        double price;
        Node next;
        Node(String n,int i,int q,double p){
            name=n;
            id=i;
            quantity=q;
            price=p;
        }
    }
    static Node head;
    static void insert(String n,int id,int q,double p,int pos){
        Node t=new Node(n,id,q,p);
        if(pos==1){
            t.next=head;
            head=t;
            return;
        }
        Node x=head;
        for(int i=1;x!=null&&i<pos-1;i++)
            x=x.next;
        if(x==null)return;
        t.next=x.next;
        x.next=t;
    }
    static void delete(int id){
        if(head==null)return;
        if(head.id==id){
            head=head.next;
            return;
        }
        Node p=head;
        while(p.next!=null&&p.next.id!=id)
            p=p.next;
        if(p.next!=null)
            p.next=p.next.next;
    }
    static void update(int id,int q){
        Node p=head;
        while(p!=null){
            if(p.id==id){
                p.quantity=q;
                return;
            }
            p=p.next;
        }
    }
    static void search(String key){
        Node p=head;
        while(p!=null){
            if(p.name.equalsIgnoreCase(key)||String.valueOf(p.id).equals(key))
                System.out.println(p.name+" "+p.id+" "+p.quantity+" "+p.price);
            p=p.next;
        }
    }
    static void total(){
        double sum=0;
        Node p=head;
        while(p!=null){
            sum+=p.price*p.quantity;
            p=p.next;
        }
        System.out.println("Total value: "+sum);
    }
    static void sort(int choice,int order){
        for(Node i=head;i!=null;i=i.next){
            for(Node j=i.next;j!=null;j=j.next){
                int c;
                if(choice==1)
                    c=i.name.compareToIgnoreCase(j.name);
                else
                    c=Double.compare(i.price,j.price);
                if((order==1&&c>0)||(order==2&&c<0)){
                    String name=i.name;
                    i.name=j.name;
                    j.name=name;
                    int id=i.id;
                    i.id=j.id;
                    j.id=id;
                    int q=i.quantity;
                    i.quantity=j.quantity;
                    j.quantity=q;
                    double price=i.price;
                    i.price=j.price;
                    j.price=price;
                }
            }
        }
    }
    static void display(){
        Node p=head;
        while(p!=null){
            System.out.println(p.name+" "+p.id+" "+p.quantity+" "+p.price);
            p=p.next;
        }
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(true){
            System.out.println("1.Insert 2.Delete 3.Update 4.Search 5.Total 6.Sort 7.Display 8.Exit");
            int ch=sc.nextInt();
            if(ch==1){
                System.out.print("Name ID Quantity Price Position: ");
                String n=sc.next();
                int id=sc.nextInt();
                int q=sc.nextInt();
                double p=sc.nextDouble();
                int pos=sc.nextInt();
                insert(n,id,q,p,pos);
            }
            else if(ch==2)
                delete(sc.nextInt());
            else if(ch==3)
                update(sc.nextInt(),sc.nextInt());
            else if(ch==4)
                search(sc.next());
            else if(ch==5)
                total();
            else if(ch==6){
                System.out.println("1.Name 2.Price");
                int c=sc.nextInt();
                System.out.println("1.Ascending 2.Descending");
                int o=sc.nextInt();
                sort(c,o);
            }
            else if(ch==7)
                display();
            else
                break;
        }
    }
}