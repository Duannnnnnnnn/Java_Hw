import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        scanner.close();
        Board B = new Board();
        B.board = a;
        B.init();
        B.validate();
        if (B.valid) {
            System.out.println("valid");
        } else {
            System.out.println("invalid");
        }

    }
}