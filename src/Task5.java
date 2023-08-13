import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Task5 {
    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        Spliterator<T> spliterator1 = first.spliterator();
        Spliterator<T> spliterator2 = second.spliterator();

        return StreamSupport.stream(new ZipSpliterator<>(spliterator1, spliterator2), false);
    }
}

class ZipSpliterator<T> implements Spliterator<T> {
    private final Spliterator<T> spliterator1;
    private final Spliterator<T> spliterator2;
    private boolean fromSpliterator1 = true;

    public ZipSpliterator(Spliterator<T> spliterator1, Spliterator<T> spliterator2) {
        this.spliterator1 = spliterator1;
        this.spliterator2 = spliterator2;
    }

    @Override
    public boolean tryAdvance(Consumer<? super T> action) {
        if (fromSpliterator1) {
            boolean hadNext = spliterator1.tryAdvance(action);
            if (!hadNext) {
                fromSpliterator1 = false;
                return spliterator2.tryAdvance(action);
            }
            return true;
        } else {
            return spliterator2.tryAdvance(action);
        }
    }

    @Override
    public Spliterator<T> trySplit() {
        return null;  // Not supported for simplicity
    }

    @Override
    public long estimateSize() {
        long size1 = spliterator1.estimateSize();
        long size2 = spliterator2.estimateSize();
        return Math.min(size1, size2);
    }

    @Override
    public int characteristics() {
        return spliterator1.characteristics() & spliterator2.characteristics() &
                ~(Spliterator.DISTINCT | Spliterator.SORTED);
    }
}
