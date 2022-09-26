import java.util.Arrays;

public class NegativeException extends RuntimeException{
    private String m;
    int x;
    public NegativeException(String elements) {
        super("There are negative elements in array: " + elements);
    }
}


