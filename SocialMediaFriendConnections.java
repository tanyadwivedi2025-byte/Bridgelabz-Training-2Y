import java.util.Scanner;
import java.util.ArrayList;
class SocialMediaFriendConnections{
    static class Node{
        int id,age;
        String name;
        ArrayList<Integer> friends=new ArrayList<>();
        Node next;
        Node(int i,String n,int a){
            id=i;
            name=n;
            age=a;
        }
    }
    static Node head;
    static void addUser(int id,String name,int age){
        Node n=new Node(id,name,age);
        n.next=head;
        head=n;
    }
    static Node find(int id){
        Node p=head;
        while(p!=null){
            if(p.id==id)
                return p;
            p=p.next;
        }
        return null;
    }
    static void addFriend(int id1,int id2){
        Node a=find(id1);
        Node b=find(id2);
        if(a!=null&&b!=null&&!a.friends.contains(id2)){
            a.friends.add(id2);
            b.friends.add(id1);
            System.out.println("Friend added");
        }
    }
    static void removeFriend(int id1,int id2){
        Node a=find(id1);
        Node b=find(id2);
        if(a!=null&&b!=null){
            a.friends.remove(Integer.valueOf(id2));
            b.friends.remove(Integer.valueOf(id1));
            System.out.println("Friend removed");
        }
    }
    static void mutual(int id1,int id2){
        Node a=find(id1);
        Node b=find(id2);
        if(a==null||b==null)return;
        System.out.println("Mutual friends:");
        for(int id:a.friends){
            if(b.friends.contains(id))
                System.out.println(id);
        }
    }
    static void displayFriends(int id){
        Node p=find(id);
        if(p==null)return;
        System.out.println("Friends of "+p.name+":");
        for(int x:p.friends)
            System.out.println(x);
    }
    static void search(String key){
        Node p=head;
        while(p!=null){
            if(p.name.equalsIgnoreCase(key)||String.valueOf(p.id).equals(key))
                System.out.println(p.id+" "+p.name+" "+p.age);
            p=p.next;
        }
    }
    static void count(){
        Node p=head;
        while(p!=null){
            System.out.println(p.name+" Friends: "+p.friends.size());
            p=p.next;
        }
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(true){
            System.out.println("1.Add User 2.Add Friend 3.Remove Friend 4.Mutual Friends 5.Display Friends 6.Search User 7.Count Friends 8.Exit");
            int ch=sc.nextInt();
            if(ch==1){
                System.out.print("ID Name Age: ");
                addUser(sc.nextInt(),sc.next(),sc.nextInt());
            }
            else if(ch==2)
                addFriend(sc.nextInt(),sc.nextInt());
            else if(ch==3)
                removeFriend(sc.nextInt(),sc.nextInt());
            else if(ch==4)
                mutual(sc.nextInt(),sc.nextInt());
            else if(ch==5)
                displayFriends(sc.nextInt());
            else if(ch==6)
                search(sc.next());
            else if(ch==7)
                count();
            else
                break;
        }
    }
}