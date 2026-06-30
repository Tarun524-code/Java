package Graphs;
import java.util.*;
public class floodFill {
    static void dfs(int[][] img, int x, int y, int oldColor, int newColor) {
        if (x < 0 || x >= img.length || y < 0 || y >= img[0].length) return;
        if (img[x][y] != oldColor) return;

        img[x][y] = newColor;

        dfs(img, x+1, y, oldColor, newColor);
        dfs(img, x-1, y, oldColor, newColor);
        dfs(img, x, y+1, oldColor, newColor);
        dfs(img, x, y-1, oldColor, newColor); 
    }

    static int[][] FloodFill(int[][] img, int sr, int sc, int newColor) {
        int oldColor = img[sr][sc];
        if (oldColor != newColor) {
            dfs(img, sr, sc, oldColor, newColor);
        }
        return img;
    }

    static void printImage(int[][] img) {
        for (int[] row : img) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int rows = sc.nextInt();
        System.out.print("Enter number of columns: ");
        int cols = sc.nextInt();

        int[][] image = new int[rows][cols];

        System.out.println("Enter the image matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                image[i][j] = sc.nextInt();
            }
        }

        System.out.print("Enter starting row: ");
        int sr = sc.nextInt();
        System.out.print("Enter starting column: ");
        int scCol = sc.nextInt();
        System.out.print("Enter new color: ");
        int newColor = sc.nextInt();

        System.out.println("\nOriginal Image:");
        printImage(image);

        FloodFill(image, sr, scCol, newColor);

        System.out.println("\nImage after Flood Fill:");
        printImage(image);

        sc.close();
    }
}
