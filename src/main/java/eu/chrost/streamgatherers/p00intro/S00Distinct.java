package eu.chrost.streamgatherers.p00intro;

import java.util.List;

record Car(String model, Color color) {}

enum Color {
    RED,
    BLACK,
    WHITE;
}

class S00Distinct {
    public static void main(String[] args) {
        List<Car> cars = List.of(
                new Car("Polonez Caro", Color.RED),
                new Car("VW Passat", Color.BLACK),
                new Car("Fiat Punto", Color.WHITE),
                new Car("Fiat Seicento", Color.BLACK),
                new Car("Polonez Caro", Color.RED)
        );
        List<Car> carsWithDistinctColor = cars.stream()
                .distinct()
                .toList();
        System.out.println(carsWithDistinctColor);
    }
}
