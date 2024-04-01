public class Point {
    int x = 0;
    int y = 0;

    void Set(int vertical, int horizontal) {
        x = horizontal;
        y = vertical;
    }

    void Move(int d_x, int d_y) {
        x += d_x;
        y += d_y;
    }

    void Rotate() {
        int temp_x = x;
        x = y;
        y = -temp_x;
    }

    int RetrieveVertical() {
        return y;
    }

    int RetrieveHorizontal() {
        return x;
    }

    int calculateManhattanDistance(Point other) {
        return Math.abs(x - other.x) + Math.abs(y - other.y);
    }

    double ChebyshevDistance(Point other) {
        return Math.max(Math.abs(x - other.x), Math.abs(y - other.y));
    }

    void PrintPoint() {
        System.out.println(x + " " + y);
    }
}
