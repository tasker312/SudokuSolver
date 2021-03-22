import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Sudoku {
    private final int[][] map;

    public Sudoku(String sudokuString) {
        map = getMapByString(sudokuString);
        System.out.println("Initial Sudoku:");
        System.out.println(this.toString());
    }

    public void solve() {
        if (getFirstEmptyCell() == null) {
            System.out.println("Solved Sudoku:");
            System.out.println(this.toString());
            return;
        }
        Point currentPoint = getFirstEmptyCell();
        int[] possibleNumbers = getPointPossibleNumbers(currentPoint);
        if (possibleNumbers.length > 0) {
            for (int possibleNumber : possibleNumbers) {
                map[currentPoint.getX()][currentPoint.getY()] = possibleNumber;
                solve();
                if (getFirstEmptyCell() == null)
                    return;
            }
            map[currentPoint.getX()][currentPoint.getY()] = 0;
        }
    }

    private int[][] getMapByString(String sudokuString) {
        String[] data = sudokuString.split("\\s");
        int size = (int) Math.sqrt(data.length);
        int[][] sudokuMap = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                sudokuMap[i][j] = Integer.parseInt(data[i * size + j]);
            }
        }
        return sudokuMap;
    }

    private Point getFirstEmptyCell() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                if (map[i][j] == 0)
                    return new Point(i, j);
            }
        }
        return null;
    }

    private int[] getPointPossibleNumbers (Point point) {
        if (map[point.getX()][point.getY()] != 0)
            return new int[0];
        Set<Integer> possibleNumbers = possibleNumbers();

        //get possible numbers by rules
        Set<Integer> rowPossibleNumbers = getRowPossibleNumbers(point);
        Set<Integer> columnPossibleNumbers = getColumnPossibleNumbers(point);
        Set<Integer> squarePossibleNumbers = getSquarePossibleNumbers(point);

        //intersect all 3 sets
        possibleNumbers.retainAll(rowPossibleNumbers);
        possibleNumbers.retainAll(columnPossibleNumbers);
        possibleNumbers.retainAll(squarePossibleNumbers);
        return possibleNumbers.stream().mapToInt(Integer::intValue).toArray();
    }

    private Set<Integer> possibleNumbers () {
        Set<Integer> possibleNumbers = new HashSet<>();
        for (int i = 0; i < map.length; i++) {
            possibleNumbers.add(i + 1);
        }
        return possibleNumbers;
    }

    private Set<Integer> getRowPossibleNumbers(Point point) {
        Set<Integer> possibleNumbers = possibleNumbers();
        for (int j = 0; j < map.length; j++) {
            possibleNumbers.remove(map[point.getX()][j]);
        }
        return possibleNumbers;
    }

    private Set<Integer> getColumnPossibleNumbers(Point point) {
        Set<Integer> possibleNumbers = possibleNumbers();
        for (int i = 0; i < map.length; i++) {
            possibleNumbers.remove(map[i][point.getY()]);
        }
        return possibleNumbers;
    }

    private Set<Integer> getSquarePossibleNumbers(Point point) {
        Set<Integer> possibleNumbers = possibleNumbers();
        int square = getSquareByPoint(point);
        int sqrtSize = (int) Math.sqrt(map.length);
        for (int i = square / sqrtSize * sqrtSize; i < square / sqrtSize * sqrtSize + sqrtSize; i++) {
            for (int j = square % sqrtSize * sqrtSize; j < square % sqrtSize * sqrtSize + sqrtSize; j++) {
                possibleNumbers.remove(map[i][j]);
            }
        }
        return possibleNumbers;
    }

    private int getSquareByPoint(Point point) {
        int rowSquare = point.getX() / (int) Math.sqrt(map.length);
        int columnSquare = point.getY() / (int) Math.sqrt(map.length);
        return rowSquare * (int) Math.sqrt(map.length) + columnSquare;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < map.length; i++) {
            sb.append(Arrays.toString(map[i])).append("\n");
        }
        return sb.toString();
    }
}