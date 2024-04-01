import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String com[] = scanner.nextLine().split(" ");
        scanner.close();
        Point main_point = new Point();
        Point other_point = new Point();
        main_point.x = Integer.parseInt(com[0]);
        main_point.y = Integer.parseInt(com[1]);
        other_point.x = Integer.parseInt(com[2]);
        other_point.y = Integer.parseInt(com[3]);
        int move_x = Integer.parseInt(com[4]);
        int move_y = Integer.parseInt(com[5]);
        main_point.PrintPoint();
        main_point.Move(move_x, move_y);
        main_point.PrintPoint();
        for (int i = 0; i < 4; i++) {
            main_point.Rotate();
            main_point.PrintPoint();
        }
        int m_d = main_point.calculateManhattanDistance(other_point);
        double c_d = main_point.ChebyshevDistance(other_point);
        System.out.println(m_d);
        System.out.println(c_d);
    }
}
