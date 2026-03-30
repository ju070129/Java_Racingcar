package racingcar;

import java.util.Random;

public class Car {
    private static final int MOVE_THRESHOLD = 4;
    private static final int MAX_NAME_LENGTH = 5;

    private final String name;
    private int position;

    public Car(String name) {
        validateName(name);
        this.name = name;
        this.position = 0;
    }

    private void validateName(String name) {
        if (name == null || name.trim().isEmpty() || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 1자 이상 5자 이하만 가능합니다.");
        }
    }

    public void move(int randomNumber) {
        if (randomNumber >= MOVE_THRESHOLD) {
            position++;
        }
    }

    public String getStatusString() {
        return String.format("%-5s : %s", name, "-".repeat(position));
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
