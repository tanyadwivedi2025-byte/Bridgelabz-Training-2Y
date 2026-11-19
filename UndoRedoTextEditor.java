import java.util.Scanner;
class UndoRedoTextEditor{
    static class Node{
        String text;
        Node next,prev;
        Node(String t){
            text=t;
        }
    }
    static Node head,tail,current;
    static int size=0;
    static void add(String text){
        if(current!=null&&current.next!=null){
            current.next=null;
            tail=current;
            size=0;
            Node p=head;
            while(p!=null){
                size++;
                p=p.next;
            }
        }
        Node n=new Node(text);
        if(head==null)
            head=tail=current=n;
        else{
            tail.next=n;
            n.prev=tail;
            tail=n;
            current=n;
        }
        size++;
        if(size>10){
            head=head.next;
            head.prev=null;
            size--;
        }
        System.out.println("Text added");
    }
    static void undo(){
        if(current!=null&&current.prev!=null)
            current=current.prev;
        else
            System.out.println("Nothing to undo");
    }
    static void redo(){
        if(current!=null&&current.next!=null)
            current=current.next;
        else
            System.out.println("Nothing to redo");
    }
    static void display(){
        if(current==null)
            System.out.println("Empty text");
        else
            System.out.println("Current Text: "+current.text);
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(true){
            System.out.println("1.Add Text 2.Undo 3.Redo 4.Display 5.Exit");
            int ch=sc.nextInt();
            sc.nextLine();
            if(ch==1){
                System.out.print("Enter text: ");
                add(sc.nextLine());
            }
            else if(ch==2)
                undo();
            else if(ch==3)
                redo();
            else if(ch==4)
                display();
            else
                break;
        }
    }
}