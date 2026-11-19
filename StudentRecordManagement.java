import java.util.Scanner;
class StudentRecordManagement{
    static class Node{
        int roll,age;
        String name,grade;
        Node next;
        Node(int r,String n,int a,String g){
            roll=r;
            name=n;
            age=a;
            grade=g;
        }
    }
    static Node head;
    static void insert(int r,String n,int a,String g,int pos){
        Node t=new Node(r,n,a,g);
        if(pos==1){
            t.next=head;
            head=t;
            return;
        }
        Node p=head;
        for(int i=1;p!=null&&i<pos-1;i++)
            p=p.next;
        if(p==null){
            System.out.println("Invalid position");
            return;
        }
        t.next=p.next;
        p.next=t;
    }
    static void delete(int r){
        if(head==null)return;
        if(head.roll==r){
            head=head.next;
            return;
        }
        Node p=head;
        while(p.next!=null&&p.next.roll!=r)
            p=p.next;
        if(p.next!=null)
            p.next=p.next.next;
        else
            System.out.println("Student not found");
    }
    static void search(int r){
        Node p=head;
        while(p!=null){
            if(p.roll==r){
                System.out.println(p.roll+" "+p.name+" "+p.age+" "+p.grade);
                return;
            }
            p=p.next;
        }
        System.out.println("Student not found");
    }
    static void update(int r,String g){
        Node p=head;
        while(p!=null){
            if(p.roll==r){
                p.grade=g;
                System.out.println("Grade updated");
                return;
            }
            p=p.next;
        }
        System.out.println("Student not found");
    }
    static void display(){
        Node p=head;
        while(p!=null){
            System.out.println(p.roll+" "+p.name+" "+p.age+" "+p.grade);
            p=p.next;
        }
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(true){
            System.out.println("1.Insert 2.Delete 3.Search 4.Display 5.Update 6.Exit");
            int ch=sc.nextInt();
            if(ch==1){
                System.out.print("Roll, Name, Age, Grade, Position: ");
                int r=sc.nextInt();
                String n=sc.next();
                int a=sc.nextInt();
                String g=sc.next();
                int p=sc.nextInt();
                insert(r,n,a,g,p);
            }
            else if(ch==2){
                System.out.print("Enter roll: ");
                delete(sc.nextInt());
            }
            else if(ch==3){
                System.out.print("Enter roll: ");
                search(sc.nextInt());
            }
            else if(ch==4)
                display();
            else if(ch==5){
                System.out.print("Enter roll and new grade: ");
                update(sc.nextInt(),sc.next());
            }
            else
                break;
        }
    }
}