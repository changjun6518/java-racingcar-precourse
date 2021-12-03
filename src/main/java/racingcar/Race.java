package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;

public class Race {
    private static ArrayList<Car> cars = new ArrayList<>();
    private static ArrayList<Car> winnerCars = new ArrayList<>();
    private static int moveCount;
    public static int maxDistance;


    public static String getUserInput() {
        return Console.readLine();
    }

    public static void getCarByName() {
        String userInput = getUserInput();
        String[] carNames = userInput.split(",");
        for (String carName : carNames) {
            Car car = new Car(carName);
            cars.add(car);
        }
    }

    public static void getMoveCount() {
        String userInput = getUserInput();
        moveCount = Integer.parseInt(userInput);
    }

    public void run() {
        getCarByName();
        getMoveCount();
        while (moveCount > 0) {
            for (Car car : cars) {
                car.move();
                car.printPosition();
            }
            moveCount--;
        }
        calculateMaxDistance();
        decideWinner();
        printWinner();
    }

    public void calculateMaxDistance() {
        for (Car car : cars) {
            maxDistance = Math.max(maxDistance, car.getPosition());
        }
    }

    public void decideWinner() {
        for (Car car : cars) {
            if (car.getPosition() == maxDistance) {
                winnerCars.add(car);
            }
        }
    }

    public void printWinner() {
        int winnerCount = winnerCars.size();
        String[] winnerCarNames = new String[winnerCount];
        for (int i = 0; i < winnerCount; i++) {
            winnerCarNames[i] = winnerCars.get(i).getName();
        }
        System.out.println("최종 우승자 : " + String.join(",", winnerCarNames));
    }

}
