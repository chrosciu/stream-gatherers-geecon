package eu.chrost.streamgatherers.p01problem;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

record Car(String model, Color color) {}

enum Color {
    RED,
    BLACK,
    WHITE;
}

public class S01DistinctBySelector {
    public static void main(String[] args) {
        List<Car> cars = List.of(
                new Car("Polonez Caro", Color.RED),
                new Car("VW Passat", Color.BLACK),
                new Car("Fiat Punto", Color.WHITE),
                new Car("Fiat Seicento", Color.BLACK)
        );
        Map<Color, Car> carMap = cars.stream()
                .collect(Collectors.toMap(
                        Car::color,
                        car -> car,
                        (car, _) -> car
                ));

        List<Car> carsWithDistinctColor = carMap.values().stream().toList();
        System.out.println(carsWithDistinctColor);
    }
}
