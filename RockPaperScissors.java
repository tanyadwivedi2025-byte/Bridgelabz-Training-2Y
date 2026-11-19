
import java.util.Scanner;
import java.util.Random;
public class RockPaperScissors {
    static String computerChoice() {
        Random r = new Random();
        int choice = r.nextInt(3);
        if (choice == 0) return "Rock";
        if (choice == 1) return "Paper";
        return "Scissors";
    }
    static String findWinner(String player, String computer) {
        if (player.equals(computer)) return "Draw";
        if (player.equals("Rock") && computer.equals("Scissors")) return "Player";
        if (player.equals("Paper") && computer.equals("Rock")) return "Player";
        if (player.equals("Scissors") && computer.equals("Paper")) return "Player";
        return "Computer";
    }
    static String[][] playGames(Scanner sc, int games) {
        String[][] result = new String[games][3];
        for (int i = 0; i < games; i++) {
            System.out.print("Enter Rock, Paper or Scissors: ");
            String player = sc.next();
            if (!player.equalsIgnoreCase("Rock") &&
                    !player.equalsIgnoreCase("Paper") &&
                    !player.equalsIgnoreCase("Scissors")) {
                System.out.println("Invalid choice. Try again.");
                i--;
                continue;
            }
            player = player.substring(0, 1).toUpperCase() + player.substring(1).toLowerCase();
            String computer = computerChoice();
            String winner = findWinner(player, computer);
            result[i][0] = player;
            result[i][1] = computer;
            result[i][2] = winner;
        }
        return result;
    }
    static void displayResults(String[][] result) {
        int playerWins = 0;
        int computerWins = 0;
        int draws = 0;
        System.out.println("\nPlayer\tComputer\tWinner");
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i][0] + "\t" + result[i][1] + "\t\t" + result[i][2]);
            if (result[i][2].equals("Player")) playerWins++;
            else if (result[i][2].equals("Computer")) computerWins++;
            else draws++;
        }
        double playerPercentage = playerWins * 100.0 / result.length;
        double computerPercentage = computerWins * 100.0 / result.length;
        System.out.println("\nPlayer Wins: " + playerWins);
        System.out.println("Computer Wins: " + computerWins);
        System.out.println("Draws: " + draws);
        System.out.println("Player Win Percentage: " + playerPercentage + "%");
        System.out.println("Computer Win Percentage: " + computerPercentage + "%");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of games: ");
        int games = sc.nextInt();
        if (games <= 0) {
            System.out.println("Enter a positive number.");
            sc.close();
            return;
        }
        String[][] result = playGames(sc, games);
        displayResults(result);
        sc.close();
    }
}
