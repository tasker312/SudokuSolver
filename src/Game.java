import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Game {
    public static final String sudokuString1 =
                    "5 3 0 0 7 0 0 0 0 " +
                    "6 0 0 1 9 5 0 0 0 " +
                    "0 9 8 0 0 0 0 6 0 " +
                    "8 0 0 0 6 0 0 0 3 " +
                    "4 0 0 8 0 3 0 0 1 " +
                    "7 0 0 0 2 0 0 0 6 " +
                    "0 6 0 0 0 0 2 8 0 " +
                    "0 0 0 4 1 9 0 0 5 " +
                    "0 0 0 0 8 0 0 7 9";
    private static final String sudokuString2 =
                    "0 0 0 0 0 0 1 6 0 " +
                    "6 0 0 3 0 0 4 0 0 " +
                    "0 0 9 0 0 7 0 0 0 " +
                    "0 0 8 0 0 4 0 0 0 " +
                    "0 0 2 0 0 0 0 0 7 " +
                    "0 9 0 8 0 0 2 5 0 " +
                    "0 2 0 0 1 8 0 0 0 " +
                    "0 0 0 0 9 0 0 0 0 " +
                    "4 7 0 0 0 0 0 0 1";
    public static final String sudokuString3 =
                   "0 0 4 0 0 6 0 0 7 " +
                    "0 9 0 0 5 0 0 2 0 " +
                    "1 0 0 7 0 0 9 0 0 " +
                    "0 0 6 0 0 1 0 0 5 " +
                    "0 8 0 0 0 0 0 4 0 " +
                    "4 0 0 5 0 0 7 0 0 " +
                    "0 0 5 0 0 2 0 0 4 " +
                    "0 3 0 0 1 0 0 7 0 " +
                    "6 0 0 8 0 0 3 0 0";
    public static final String sudokuString4 = "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0";
    public static final String sudokuString5 = "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0";
    public static final String sudokuString6 =
                    "0 0 2 1 " +
                    "0 0 0 0 " +
                    "0 0 0 0 " +
                    "1 4 0 0";
    public static final String sudokuString7 = "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 ";
    public static final String sudokuString8 =
                    "5 2 0 0 0 13 0 0 10 0 14 0 15 11 0 8 " +
                    "0 0 6 0 2 0 0 15 0 0 0 11 0 0 0 13 " +
                    "3 0 8 0 9 1 14 0 5 13 0 12 0 7 2 0 " +
                    "16 0 0 0 8 11 3 0 2 0 0 0 0 0 0 0 " +
                    "0 12 1 0 0 0 0 3 7 6 0 0 2 5 9 0 " +
                    "7 0 0 0 0 10 0 11 0 8 5 0 16 6 0 15 " +
                    "0 0 4 0 7 8 9 2 0 11 0 0 14 13 0 0 " +
                    "9 0 15 11 6 0 0 16 14 2 1 13 0 0 8 0 " +
                    "0 6 0 0 10 16 13 1 12 0 0 2 4 9 0 3 " +
                    "0 0 7 15 0 0 6 0 11 16 4 8 0 2 0 0 " +
                    "2 0 10 12 0 4 8 0 1 0 6 0 0 0 0 5 " +
                    "0 3 9 1 0 0 12 14 13 0 0 0 0 8 16 0 " +
                    "0 0 0 0 0 0 0 13 0 5 11 1 0 0 0 2 " +
                    "0 9 11 0 1 0 2 10 0 4 13 7 0 16 0 14 " +
                    "15 0 0 0 5 0 0 0 8 0 0 14 0 10 0 0 " +
                    "1 0 14 13 0 7 0 8 0 0 2 0 0 0 5 9";
    public static final String sudokuString9 =
                    "12 4 7 0 0 10 0 0 0 15 0 3 0 0 0 8 " +
                    "0 0 0 0 12 0 0 9 0 0 0 13 16 5 0 6 " +
                    "13 1 2 6 0 0 0 0 16 12 0 0 0 0 0 4 " +
                    "0 0 0 0 11 1 0 2 0 9 0 7 0 0 0 3 " +
                    "0 0 4 0 0 0 11 0 13 0 3 0 2 0 5 0 " +
                    "0 0 0 0 7 13 12 15 0 0 2 0 0 0 14 0 " +
                    "0 8 0 2 0 0 0 0 15 0 0 0 11 0 0 7 " +
                    "0 0 14 0 10 0 2 4 0 0 1 0 15 0 9 0 " +
                    "0 3 0 7 0 5 0 0 9 14 0 6 0 13 0 0 " +
                    "16 0 0 11 0 0 0 1 0 0 0 0 6 0 4 0 " +
                    "0 5 0 0 0 7 0 0 1 8 11 12 0 0 0 0 " +
                    "0 9 0 1 0 4 0 14 0 7 0 0 0 15 0 0 " +
                    "3 0 0 0 4 0 9 0 11 0 7 15 0 0 0 0 " +
                    "14 0 0 0 0 0 8 7 0 0 0 0 3 2 11 9 " +
                    "2 0 11 16 5 0 0 0 12 0 0 4 0 0 0 0 " +
                    "10 0 0 0 3 0 16 0 0 0 14 0 0 4 6 15";

    public static final List<String> sudokuStrings = new ArrayList<>(Arrays.asList(sudokuString1, sudokuString2, sudokuString3, sudokuString4, sudokuString5, sudokuString6, sudokuString7, sudokuString8, sudokuString9));

    public static void main(String[] args) {
        Sudoku sudoku = new Sudoku(sudokuString8);
        long start = System.currentTimeMillis();
        sudoku.solve();
        long end = System.currentTimeMillis();
        System.out.println((end - start) / 1000.0);

/*        sudokuStrings.forEach(str -> {
            Sudoku sudoku = new Sudoku(str);
            long start = System.currentTimeMillis();
            sudoku.solve();
            long end = System.currentTimeMillis();
            System.out.println((end - start) / 1000.0);
        });*/
    }
}
