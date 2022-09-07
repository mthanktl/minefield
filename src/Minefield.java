import java.util.Scanner;
import java.util.Random;

public class Minefield {
    static String[][] minefieldArea(int a, int b) {
        Random randomNumber = new Random();
        String[][] area = new String[a][b];

        int low = 0;
        int highA = a;
        int highB = b;
        int mine = a * b / 4;
        int i = 0;

        while (i < mine) {
            int randomrow = randomNumber.nextInt(highA - low) + low;
            int randomcol = randomNumber.nextInt(highB - low) + low;
            if (area[randomrow][randomcol] != " * ") {
                area[randomrow][randomcol] = " * ";
                i++;
            }

        }
        for (i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                if (area[i][j] != " * ") {
                    area[i][j] = " - ";
                }
            }
        }
        return area;
    }

    static void print(String[][] area) {
        for (int i = 0; i < area.length; i++) {
            for (int j = 0; j < area[i].length; j++) {
                System.out.print(area[i][j]);
            }
            System.out.println();
        }
    }

    static String[][] emptyArea(int a, int b) {
        String[][] emptyArea = new String[a][b];
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                emptyArea[i][j] = " - ";
            }
        }
        return emptyArea;
    }

    static String[][] check(String[][] area, String[][] emptyArea, int x, int y) {
        int mine = x * y / 4;
        int k = (x * y) - mine;

        boolean p = true;

        while (p) {
            Scanner input = new Scanner(System.in);
            System.out.print("Select row : ");
            int a = input.nextInt();
            System.out.print("Select column : ");
            int b = input.nextInt();

            if (a < 0 || a >= x || b < 0 || b >= y){
                System.out.println("You entered an incorrect value");
                continue;
            }

            if (area[a][b].equals(" * ")) {
                System.out.println("===Game Over===");
                System.out.println("===Minefield===");
                Minefield.print(area);
                p = false;
                break;

            } else if (area[a][b].equals(emptyArea[a][b])) {
                int count = 0;
                for (int i = -1; i <= 1; i++) {
                    if (((a + i) < 0) || (a + i >= area.length)) {
                        continue;
                    }
                    for (int j = -1; j <= 1; j++) {
                        if (((b + j) < 0) || (b + j >= area.length)) {
                            continue;
                        }
                        if (area[a + i][b + j].equals(" * ")) {
                            count++;
                        }
                    }
                }
                emptyArea[a][b] = " " + count + " ";
                Minefield.print(emptyArea);
                k--;
            }
            System.out.println("remaining space : " + k);
            if (k == 0) {
                System.out.println("win");
                break;
            }
        }
        return area;
    }
}