import java.util.Arrays;
import java.util.stream.Collectors;

public class Task3 {
    public static String sortedNumbers(String[] arrays) {
        String numbers = Arrays.stream(arrays)
                .flatMap(s -> Arrays.stream(s.split(", ")))
                .sorted()
                .collect(Collectors.joining(", "));
        return numbers;
    }
}
