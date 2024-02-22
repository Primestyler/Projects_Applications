import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countWins=0;
        int countLosses=0;
        int countTies=0;
        while (true) {
            System.out.printf("What is your move? To make a move, enter rock, paper or scissors. To quit the game, enter quit ");
            String myMove = scanner.nextLine();
            while (!myMove.equals("scissors") && !myMove.equals("rock") && !myMove.equals("paper") && !myMove.equals("quit")) {
                System.out.println("Invalid input");
                System.out.printf("Please type your move again ");
                myMove=scanner.nextLine();
            }
            String opps=opponentsMove();
            System.out.println("Computers move: "+opps);
            if (myMove.equals("quit")) {
                break;
            }
            if (myMove.equals(opps)) {
                System.out.println("Tie");
                countTies++;
            } else if (myMove.equals("rock") && opps.equals("scissors")|| myMove.equals("scissors") && opps.equals("paper")|| myMove.equals("paper") && opps.equals("rock")) {
                System.out.println("You win!");
                countWins++;
            } else{
                System.out.println("You lose!");
                countLosses++;
            }
        }
        System.out.println("Thanks for playing :)");
        System.out.println("Wins: "+ countWins+ " Losses: "+countLosses+" Ties: "+countTies);
    }
    public static String opponentsMove(){
        Random random=new Random();
        int move= random.nextInt(3);
        switch (move){
            case 0:return "rock";
            case 1: return "paper";
            case 2: return "scissors";
        }
        return "";
    }
}