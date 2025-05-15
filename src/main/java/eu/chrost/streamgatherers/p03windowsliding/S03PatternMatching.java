package eu.chrost.streamgatherers.p03windowsliding;

import java.util.List;
import java.util.stream.Gatherers;

public class S03PatternMatching {
    private static final List<Integer> PATTERN = List.of(1, 0, 1);

    public static void main(String[] args) {
        List.of(1, 0, 1, 1, 0, 1, 0, 0, 1).stream()
                .gather(Gatherers.windowSliding(3))
                .filter(window -> window.equals(PATTERN))
                .forEach(pattern -> System.out.println("Pattern found: " + pattern));
    }
}
