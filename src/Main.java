import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        // Завдання 1
        List<String> names = Arrays.asList("Ivan", "Peter", "John", "Anna", "Mike");
        String resultTask1 = Task1.formatNames(names);
        System.out.println("Завдання 1: " + resultTask1);

        // Завдання 2
        List<String> strings = Arrays.asList("abc", "xyz", "def", "uvw");
        List<String> resultTask2 = Task2.sortAndToUpper(strings);
        System.out.println("Завдання 2: " + resultTask2);

        // Завдання 3
        String[] arrays = {"1, 2, 0", "4, 5"};
        String resultTask3 = Task3.sortedNumbers(arrays);
        System.out.println("Завдання 3: " + resultTask3);

        // Завдання 4
        long a = 25214903917L;
        long c = 11L;
        long m = (long) Math.pow(2, 48);
        long seed = 0L;
        List<Long> resultTask4 = Task4.linearCongruentialGenerator(a, c, m, seed).limit(10).collect(Collectors.toList());
        System.out.println("Завдання 4: " + resultTask4);

        // Завдання 5
        Stream<String> stream1 = Stream.of("A", "B", "C");
        Stream<String> stream2 = Stream.of("X", "Y", "Z", "W");
        List<String> resultTask5 = Task5.zip(stream1, stream2).collect(Collectors.toList());
        System.out.println("Завдання 5: " + resultTask5);
    }
}