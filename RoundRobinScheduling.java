import java.util.Scanner;
class RoundRobinScheduling {
    static class Node {
        int id, burst, remaining, priority, completion;
        Node next;

        Node(int i, int b, int p) {
            id = i;
            burst = b;
            remaining = b;
            priority = p;
        }
    }

    static Node head, tail;

    static void insert(int id, int burst, int priority) {
        Node n = new Node(id, burst, priority);
        if (head == null) {
            head = tail = n;
            n.next = head;
        } else {
            tail.next = n;
            tail = n;
            tail.next = head;
        }
    }

    static void display() {
        if (head == null) return;
        Node p = head;
        do {
            if (p.remaining > 0)
                System.out.println("P" + p.id + " Remaining: " + p.remaining);
            p = p.next;
        } while (p != head);
    }

    static void schedule(int quantum) {
        if (head == null || quantum <= 0) return;
        int time = 0, completed = 0, n = 0;
        Node p = head;
        do {
            n++;
            p = p.next;
        } while (p != head);
        while (completed < n) {
            p = head;
            do {
                if (p.remaining > 0) {
                    int run = Math.min(quantum, p.remaining);
                    time += run;
                    p.remaining -= run;
                    if (p.remaining == 0) {
                        p.completion = time;
                        completed++;
                    }
                }
                p = p.next;
            } while (p != head);
            System.out.println("After round:");
            display();
        }
        double totalWT = 0, totalTAT = 0;
        System.out.println("Process\tWaiting\tTurnaround");
        p = head;
        do {
            int tat = p.completion;
            int wt = tat - p.burst;
            totalWT += wt;
            totalTAT += tat;
            System.out.println("P" + p.id + "\t" + wt + "\t" + tat);
            p = p.next;
        } while (p != head);
        System.out.println("Average Waiting Time: " + totalWT / n);
        System.out.println("Average Turnaround Time: " + totalTAT / n);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.print("Enter Process ID, Burst Time, Priority: ");
            insert(sc.nextInt(), sc.nextInt(), sc.nextInt());
        }
        System.out.print("Enter time quantum: ");
        int q = sc.nextInt();
        schedule(q);
    }
}