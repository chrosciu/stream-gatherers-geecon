package eu.chrost.streamgatherers.p06notgreedy;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Gatherer;

@RequiredArgsConstructor
class FindFirstGatherer<T> implements Gatherer<T, Void, T> {
    private final Predicate<T> predicate;

    @Override
    public Integrator<Void, T, T> integrator() {
        return Integrator.of((_, item, downstream) -> {
            if (predicate.test(item)) {
                downstream.push(item);
                return false;
            }
            return true;
        });
    }
}

class S06FindFirst {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 4, 5);
        var firstEvenNumber = numbers.stream()
                .gather(new FindFirstGatherer<>(i -> i % 2 == 0))
                .toList();
        System.out.println(firstEvenNumber);
    }
}
