public class Board {
    String board;
    boolean cross_win;
    boolean circle_win;
    int circle;
    int cross;
    boolean valid = true;

    public void init() {
        for (int i = 0; i < 9; i++) {
            if (board.charAt(i) == 'O') {
                circle++;
            }
            if (board.charAt(i) == 'X') {
                cross++;
            }
        }
    }

    boolean checkwin(char c) {
        boolean win = false;
        // row
        for (int i = 0; i < 3; i++) {
            boolean strike = true;
            for (int j = 0; j < 3; j++) {
                if (board.charAt(3 * i + j) != c) {
                    strike = false;
                }
            }
            if (strike) {
                win = true;
                //System.out.println("b0");
            }
        }
        // col
        for (int i = 0; i < 3; i++) {
            boolean strike = true;
            for (int j = 0; j < 3; j++) {
                if (board.charAt(i + 3 * j) != c) {
                    strike = false;
                }
            }
            if (strike) {
                win = true;
                //System.out.println("b1");
            }
        }
        // \
        for (int i = 0; i < 3; i++) {
            boolean strike = true;
            if (board.charAt(4 * i) != c) {
                strike = false;
            }
            if (strike) {
                win = true;
                //System.out.println("b2");
            }
        }
        // /
        boolean strike = true;
        for (int i = 0, j = 2; i < 3; i++) {
            if (board.charAt(2 * i + j) != c) {
                strike = false;
            }
            if (strike) {
                win = true;
                //System.out.println("b3");
            }
        }

        return win;
    }

    void validate() {
        // X first SO
        // cross - circle <= 1
        if (circle > cross) {
            valid = false;
            //System.out.println("c1");
        }
        if (cross - circle > 1) {
            valid = false;
            //System.out.println("c2");
        }
        // cross win then cross = circle + 1
        if (checkwin('X') && cross != circle + 1) {
            valid = false;
            //System.out.println("c3");
        }
        // circle win then cross = circle
        if (checkwin('O') && cross != circle) {
            valid = false;
            // System.out.println("c4");
        }
    }
}
