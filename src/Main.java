import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Number of Rows : ");
        int a = input.nextInt();
        System.out.print("Number of Columns : ");
        int b = input.nextInt();
        String[][] area = Minefield.minefieldArea(a, b);
        String[][] emptyArea = Minefield.emptyArea(a, b);
        Minefield.print(emptyArea);

//        Minefield.print(area);

        Minefield.check(area, emptyArea, a, b);
    }
}