public class Game {
    public static void main(String[] args) {
        String sudokuString1 =
                "53  7    " +
                "6  195   " +
                " 98    6 " +
                "8   6   3" +
                "4  8 3  1" +
                "7   2   6" +
                " 6    28 " +
                "   419  5" +
                "    8  79";
        String sudokuString2 =
                "      16 " +
                "6  3  4  " +
                "  9  7   " +
                "  8  4   " +
                "  2     7" +
                " 9 8  25 " +
                " 2  18   " +
                "    9    " +
                "47      1";
        String sudokuString3 =
                "  4  6  7" +
                " 9  5  2 " +
                "1  7  9  " +
                "  6  1  5" +
                " 8     4 " +
                "4  5  7  " +
                "  5  2  4" +
                " 3  1  7 " +
                "6  8  3  ";
        String sudokuString4 = "                                                                                 ";

        Sudoku sudoku = new Sudoku(sudokuString4);
        sudoku.solve();
    }
}
