package eu.chrost.streamgatherers.p05stateless;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Gatherer;
import java.util.stream.Gatherer.Integrator;

class S05MapNotNull {
    private static <T, R> Gatherer<T, Void, R> mapNotNullGatherer(Function<T, R> mapper) {
        return Gatherer.of(
                Integrator.ofGreedy((_, item, downstream) ->
                        item != null ? downstream.push(mapper.apply(item)) : true
                )
        );
    }

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(null);
        numbers.add(3);
        List<Integer> doubledNumbers = numbers.stream()
                .gather(mapNotNullGatherer(i -> i * 2))
                .toList();
        System.out.println(doubledNumbers);
    }
}
