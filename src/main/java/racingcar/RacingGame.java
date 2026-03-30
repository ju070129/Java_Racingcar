package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class RacingGame {
    private final List<Car> cars;
    private final Random random = new Random();

    public RacingGame(String carNames) {
        this.cars = createCars(carNames);
    }

    private List<Car> createCars(String carNames) {
        return Arrays.stream(carNames.split(","))
                .map(String::trim)
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public void playRound() {
        cars.forEach(car -> car.move(random.nextInt(10)));
        printCurrentStatus();
    }

    private void printCurrentStatus() {
        cars.forEach(car -> System.out.println(car.getStatusString()));
        System.out.println();
    }

    public String getWinnerNames() {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.joining(", "));
    }
}
