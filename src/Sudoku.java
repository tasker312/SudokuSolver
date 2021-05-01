import java.awt.Point;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Sudoku {
    private Cell[][] map;

    public Sudoku(String sudokuString) {
        map = getMapByString(sudokuString);
        System.out.println("Initial Sudoku:");
        System.out.println(this.toString());
    }

    public void solve() {
        fillPossibleNumbers();
        solver(map);
    }

    private boolean solver(Cell[][] map) {
        Point currentPoint = getFirstEmptyCell(map);
        if (currentPoint == null) {
            this.map = map;
            System.out.println("Solved Sudoku:");
            System.out.println(this.toString());
            return true;
        }
        Set<Integer> possibleNumbers = map[currentPoint.x][currentPoint.y].possibleNumbers;
        if (possibleNumbers.size() > 0 ) {
            for (int possibleNumber : possibleNumbers) {
                Cell[][] temp = copyArray(map);
                temp[currentPoint.x][currentPoint.y].value = possibleNumber;
                removePossibleNumber(temp, currentPoint);
                boolean b = solver(temp);
                if (b)
                    return true;
            }
        }
        return false;
    }

    private Cell[][] getMapByString(String sudokuString) {
        String[] data = sudokuString.split("\\s");
        int size = (int) Math.sqrt(data.length);
        Cell[][] sudokuMap = new Cell[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                sudokuMap[i][j] = new Cell(Integer.parseInt(data[i * size + j]), null);
            }
        }
        return sudokuMap;
    }

    private void fillPossibleNumbers() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                map[i][j].possibleNumbers = getPointPossibleNumbers(new Point(i, j));
            }
        }
    }

    private Point getFirstEmptyCell(Cell[][] map) {
        Point point = null;
        l1:for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                if (map[i][j].value == 0) {
                    point = new Point(i, j);
                    break l1;
                }
            }
        }
        if (point == null)
            return null;
        Cell cell = map[point.x][point.y];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                if (map[i][j].value == 0 && map[i][j].possibleNumbers.size() < cell.possibleNumbers.size()) {
                    point = new Point(i, j);
                    cell = map[i][j];
                }
            }
        }
        return point;
    }

    private void removePossibleNumber(Cell[][] map, Point point) {
        //row
        int value = map[point.x][point.y].value;
        for (int j = 0; j < map.length; j++) {
            map[point.x][j].possibleNumbers.remove(value);
        }
        //column
        for (int i = 0; i < map.length; i++) {
            map[i][point.y].possibleNumbers.remove(value);
        }
        //square
        int square = getSquareByPoint(point);
        int sqrtSize = (int) Math.sqrt(map.length);
        for (int i = square / sqrtSize * sqrtSize; i < square / sqrtSize * sqrtSize + sqrtSize; i++) {
            for (int j = square % sqrtSize * sqrtSize; j < square % sqrtSize * sqrtSize + sqrtSize; j++) {
                map[i][j].possibleNumbers.remove(value);
            }
        }

    }

    private Set<Integer> getPointPossibleNumbers(Point point) {
        if (map[point.x][point.y].value != 0)
            return new HashSet<>();
        Set<Integer> possibleNumbers = possibleNumbers();

        //get possible numbers by rules
        Set<Integer> rowPossibleNumbers = getRowPossibleNumbers(point);
        Set<Integer> columnPossibleNumbers = getColumnPossibleNumbers(point);
        Set<Integer> squarePossibleNumbers = getSquarePossibleNumbers(point);

        //intersect all 3 sets
        possibleNumbers.retainAll(rowPossibleNumbers);
        possibleNumbers.retainAll(columnPossibleNumbers);
        possibleNumbers.retainAll(squarePossibleNumbers);
        return possibleNumbers;
    }

    private Set<Integer> possibleNumbers() {
        Set<Integer> possibleNumbers = new HashSet<>();
        for (int i = 0; i < map.length; i++) {
            possibleNumbers.add(i + 1);
        }
        return possibleNumbers;
    }

    private Set<Integer> getRowPossibleNumbers(Point point) {
        Set<Integer> possibleNumbers = possibleNumbers();
        for (int j = 0; j < map.length; j++) {
            possibleNumbers.remove(map[point.x][j].value);
        }
        return possibleNumbers;
    }

    private Set<Integer> getColumnPossibleNumbers(Point point) {
        Set<Integer> possibleNumbers = possibleNumbers();
        for (int i = 0; i < map.length; i++) {
            possibleNumbers.remove(map[i][point.y].value);
        }
        return possibleNumbers;
    }

    private Set<Integer> getSquarePossibleNumbers(Point point) {
        Set<Integer> possibleNumbers = possibleNumbers();
        int square = getSquareByPoint(point);
        int sqrtSize = (int) Math.sqrt(map.length);
        for (int i = square / sqrtSize * sqrtSize; i < square / sqrtSize * sqrtSize + sqrtSize; i++) {
            for (int j = square % sqrtSize * sqrtSize; j < square % sqrtSize * sqrtSize + sqrtSize; j++) {
                possibleNumbers.remove(map[i][j].value);
            }
        }
        return possibleNumbers;
    }

    private int getSquareByPoint(Point point) {
        int rowSquare = point.x / (int) Math.sqrt(map.length);
        int columnSquare = point.y / (int) Math.sqrt(map.length);
        return rowSquare * (int) Math.sqrt(map.length) + columnSquare;
    }

    private static Cell[][] copyArray(Cell[][] map) {
        Cell[][] temp = new Cell[map.length][map.length];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                try {
                    temp[i][j] = (Cell) map[i][j].clone();
                } catch (CloneNotSupportedException e) {
                    e.printStackTrace();
                }
            }
        }
        return temp;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < map.length; i++) {
            sb.append(Arrays.toString(map[i]).replaceAll("[,\\[\\]]", "")).append("\n");
        }
        return sb.toString();
    }
}