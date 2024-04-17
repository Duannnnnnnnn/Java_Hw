public class Board {
    String board;
    boolean cross_win;
    boolean circle_win;
    int circle;
    int cross;
    boolean valid = true;

    void init() {
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
            if (strike = true) {
                win = true;
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
            if (strike = true) {
                win = true;
            }
        }
        // \
        for (int i = 0, j = 0; i < 3; i++) {
            boolean strike = true;
            if (board.charAt(4 * i + j) != c) {
                strike = false;
            }
            if (strike = true) {
                win = true;
            }
        }
        // /
        boolean strike = true;
        for (int i = 0, j = 2; i < 3; i++) {
            if (board.charAt(2 * i + j) != c) {
                strike = false;
            }
        }
        if (strike = true) {
            win = true;
        }
        return win;
    }

    void validate() {
        // X first SO
        // cross - circle <= 1
        if (circle > cross) {
            valid = false;
        }
        if (cross - circle > 1) {
            valid = false;
        }
        // cross win then cross = circle + 1
        if (checkwin('X') && cross != circle + 1) {
            valid = false;
        }
        // circle win then cross = circle
        if (checkwin('O') && cross != circle) {
            valid = false;
        }
    }
}
