import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();// for ""

        String[][] charArr = new String[n][m];
        for (int i = 0; i < n; i++) {
            String inputLine = scanner.nextLine();
            String[] words = inputLine.split(" ");
            for (int j = 0; j < m; j++) {
                charArr[i][j] = words[j];
            }
        }
        String target = scanner.nextLine();
        int bingo = 0;
        for (int t = 0; t < target.length(); t++) {
            char tc = target.charAt(t);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (tc == charArr[i][j].charAt(0)) {

                        charArr[i][j] = "1";
                    }
                }
            }
        }
        boolean first = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (charArr[i][j] == "1") {
                    if (first) {
                        charArr[i][j] = "_";
                        bingo++;
                        first = false;
                    }
                    // 上
                    if (i > 0 && charArr[i - 1][j] == "_") {
                        charArr[i][j] = "_";
                        bingo++;
                    }
                    // 下
                    else if (i < n - 1 && charArr[i + 1][j] == "_") {
                        charArr[i][j] = "_";
                        bingo++;
                    }
                    // 左
                    else if (j > 0 && charArr[i][j - 1] == "_") {
                        charArr[i][j] = "_";
                        bingo++;
                    }
                    // 右
                    else if (j < m - 1 && charArr[i][j + 1] == "_") {
                        charArr[i][j] = "_";
                        bingo++;
                    }
                }
            }
        }
        // for (int i = 0; i < n; i++) {
        // for (int j = 0; j < m; j++) {
        // System.out.print(charArr[i][j] + " ");
        // }
        // System.out.println(); // Move to the next line after printing each row
        // }
        if (bingo >= target.length()) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
        // System.out.println("true");
        // for (String[] row : charArr) {
        // for (String c : row) {
        // System.out.print(c + " ");
        // }
        // System.out.println(); // 换行
        // }
        scanner.close();
    }
}
