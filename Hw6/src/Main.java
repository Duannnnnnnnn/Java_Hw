import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Board B = new Board();
        Scanner scanner = new Scanner(System.in);
        B.board = scanner.nextLine();
        scanner.close();
        B.init();
    }  
}
