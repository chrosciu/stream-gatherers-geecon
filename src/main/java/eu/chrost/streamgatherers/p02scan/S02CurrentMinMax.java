package eu.chrost.streamgatherers.p02scan;

import java.util.stream.Gatherers;
import java.util.stream.Stream;

record MinMax(int min, int max) {}

public class S02CurrentMinMax {
    public static void main(String[] args) {
        Stream.of(3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5)
                .gather(Gatherers.scan(
                        () -> new MinMax(Integer.MAX_VALUE, Integer.MIN_VALUE),
                        (state, value) -> {
                            int min = Math.min(state.min(), value);
                            int max = Math.max(state.max(), value);
                            return new MinMax(min, max);
                        }
                ))
                .forEach(state -> System.out.println("Min: " + state.min() + ", Max: " + state.max()));
    }
}
