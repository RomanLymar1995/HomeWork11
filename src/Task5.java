import java.util.stream.Stream;

public class Task5 {
    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        return Stream.concat(
                        first.map(e -> Stream.of(e, null)),
                        second.map(e -> Stream.of(null, e))
                )
                .flatMap(s -> s.filter(x -> x != null));
    }
}