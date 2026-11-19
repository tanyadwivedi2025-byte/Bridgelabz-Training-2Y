import java.util.Scanner;
class J{
    static String[] initializeDeck(){
        String[] suits={"Hearts","Diamonds","Clubs","Spades"};
        String[] ranks={"2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"};
        String[] deck=new String[52];
        int k=0;
        for(int i=0;i<suits.length;i++){
            for(int j=0;j<ranks.length;j++){
                deck[k++]=ranks[j]+" of "+suits[i];
            }
        }
        return deck;
    }
    static String[] shuffleDeck(String[] deck){
        for(int i=0;i<deck.length;i++){
            int r=i+(int)(Math.random()*(deck.length-i));
            String temp=deck[i];
            deck[i]=deck[r];
            deck[r]=temp;
        }
        return deck;
    }
    static String[][] distributeCards(String[] deck,int n,int x){
        if(n>52||x<=0||n<=0||n%x!=0)
            return null;
        String[][] players=new String[x][n/x];
        int k=0;
        for(int i=0;i<x;i++){
            for(int j=0;j<n/x;j++){
                players[i][j]=deck[k++];
            }
        }
        return players;
    }
    static void printPlayers(String[][] players){
        for(int i=0;i<players.length;i++){
            System.out.println("Player "+(i+1)+":");
            for(int j=0;j<players[i].length;j++)
                System.out.println(players[i][j]);
            System.out.println();
        }
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String[] deck=initializeDeck();
        System.out.print("Enter number of cards: ");
        int n=sc.nextInt();
        System.out.print("Enter number of players: ");
        int x=sc.nextInt();
        if(n<=0||n>52||x<=0||x>n||n%x!=0){
            System.out.println("Cards cannot be distributed equally");
            return;
        }
        deck=shuffleDeck(deck);
        String[][] players=distributeCards(deck,n,x);
        printPlayers(players);
    }
}