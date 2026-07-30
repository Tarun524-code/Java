package DynamicProgramming;
import java.util.Scanner;

public class BooleanParenthesization {
    public static int countWays(String symbols, String operators) {
        int n = symbols.length();
        int[][] trueDP = new int[n][n];
        int[][] falseDP = new int[n][n];

        for (int i = 0; i < n; i++) {
            if (symbols.charAt(i) == 'T') {
                trueDP[i][i] = 1;
                falseDP[i][i] = 0;
            } else {
                trueDP[i][i] = 0;
                falseDP[i][i] = 1;
            }
        }

        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                for (int k = i; k < j; k++) {
                    char op = operators.charAt(k);
                    int lt = trueDP[i][k], lf = falseDP[i][k];
                    int rt = trueDP[k + 1][j], rf = falseDP[k + 1][j];

                    if (op == '&') {
                        trueDP[i][j] += lt * rt;
                        falseDP[i][j] += lt * rf + lf * rt + lf * rf;
                    } else if (op == '|') {
                        trueDP[i][j] += lt * rt + lt * rf + lf * rt;
                        falseDP[i][j] += lf * rf;
                    } else if (op == '^') {
                        trueDP[i][j] += lt * rf + lf * rt;
                        falseDP[i][j] += lt * rt + lf * rf;
                    }
                }
            }
        }
        return trueDP[0][n - 1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter symbols string (T/F): ");
        String symbols = sc.nextLine();
        System.out.print("Enter operators string (&,|,^): ");
        String operators = sc.nextLine();

        int result = countWays(symbols, operators);
        System.out.println("Number of ways to evaluate to True: " + result);
        sc.close();
    }
}
