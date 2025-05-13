package eu.chrost.streamgatherers.p04chaining;

import java.util.List;
import java.util.stream.Gatherers;

record IndexedValue(int index, int value) {}

public class S04PatternMatchingWithIndex {
    private static final List<Integer> PATTERN = List.of(1, 0, 1);

    public static void main(String[] args) {
        List.of(1, 0, 1, 1, 0, 1, 0, 0, 1).stream()
                .gather(Gatherers.scan(
                        () -> new IndexedValue(-1, 0),
                        (state, value) -> new IndexedValue(state.index() + 1, value)))
                .gather(Gatherers.windowSliding(3))
                .filter(window -> window.stream().map(IndexedValue::value).toList().equals(PATTERN))
                .forEach(pattern -> System.out.println("Pattern found at index: " + pattern.getFirst().index()));
    }
}
