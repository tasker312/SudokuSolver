import java.util.Set;
import java.util.stream.Collectors;

public class Cell implements Cloneable {
    public int value;
    Set<Integer> possibleNumbers;

    public Cell(int value, Set<Integer> possibleNumbers) {
        this.value = value;
        this.possibleNumbers = possibleNumbers;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Cell cloned = (Cell)super.clone();
        cloned.possibleNumbers = cloned.possibleNumbers.stream().map(Integer::new).collect(Collectors.toSet());
        return cloned;
    }
}
