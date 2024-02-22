import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int n=4;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Player 1, whats your name? ");
        String p1 = scanner.nextLine();
        System.out.printf("Player 2, whats your name?");
        String p2 = scanner.nextLine();

        char[][] board = new char[n][n];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
        boolean isPlayer1 = true;
    while (true){
        drawBoard(board);
        char symbol = ' ';
        if (isPlayer1) {
            symbol = 'x';
        } else {
            symbol = 'o';
        }
        if (isPlayer1) {
            System.out.println(p1 + "s turn");
        } else {
            System.out.println(p2 + "s turn");
        }
        int row = 0;
        int col = 0;
        while (true) {
            System.out.printf("Enter a row: ");
            row = scanner.nextInt();
            System.out.printf("Enter a col: ");
            col = scanner.nextInt();
            if (row < 0 || row >= n || col < 0 || col >= n) {
                System.out.println("Row and cols are out of bounds)");
            } else if (board[row][col] != '-') {
                System.out.println("Someone is using this spot");
            } else {
                break;
            }
        }
        board[row][col] = symbol;
        if (hasWon(board) == 'x') {
            System.out.println(p1 + "has won");
            break;
        } else if (hasWon(board) == 'o') {
            System.out.println(p2 + " has won");
            break;
        } else {
            if (hasTied(board)) {
                System.out.println("Its a tie!");
                break;
            }else {
                isPlayer1=!isPlayer1;
            }
        }
    }
    drawBoard(board);
        }
        public static void drawBoard(char[][] board){
            for (int i = 0; i < board.length ; i++) {
                for (int j = 0; j <board[i].length ; j++) {
                    System.out.print(board[i][j]);
                }
                System.out.println();
            }
    }
    public static char hasWon(char [][] board){
        for (int i = 0; i <3 ; i++) {
            if(board[i][0]==board[i][1] && board[i][1]==board[i][2] && board[i][2]!='-'){
                return board[i][0];
            }
        }
        for (int i = 0; i <3 ; i++) {
            if(board[0][i]==board[1][i] && board[2][i]==board[0][i] && board[0][i]!='-'){
                return board[0][i];
            }
        }
        if (board[0][0] == board[1][1] && board[2][2]==board[1][1] && board[0][0]!='-') {
            return board[0][0];
        }
        if (board[2][0]==board[1][1] && board[0][2]==board[1][1] && board[0][2]!='-') {
            return board[0][2];
        }
        return '-';
    }
    public static boolean hasTied(char [][] board){
        for (int i = 0; i < board.length ; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(board[i][j]=='-'){
                    return false;
                }
            }
        }
        return true;
    }
}