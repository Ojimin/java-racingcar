package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO 구현 진행
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<Car> carList = inputCar();
        System.out.println("시도할 회수는 몇회인가요?");
        int attempts = inputAttempts();
        System.out.println("\n실행 결과");
        startRacing(carList, attempts);
    }

    public static List<Car> inputCar() {
        String str = Console.readLine();
        List<String> carNameList = Arrays.asList(str.split(","));
        List<Car> carList = new ArrayList<>();
        for (String carName : carNameList) {
            Car car = new Car(carName);
            carList.add(car);
        }
        return carList;
    }

    public static int inputAttempts() {
        String str = Console.readLine();
        int attempts = Integer.parseInt(str);
        return attempts;
    }

    public static void startRacing(List<Car> carList, int attempts) {
        for (int i = 0; i < attempts; i++) {
            startGameByAttempts(carList, attempts);
            printResult(carList);
            carList = makeNewCar(carList);
        }
    }

    public static void startGameByAttempts(List<Car> carList, int attempts) {
        for (int i = 0; i < attempts; i++) {
            for (Car car : carList) {
                checkRandomNum(car);
            }
        }
    }

    public static void checkRandomNum(Car car) {
        int randomNum = Randoms.pickNumberInRange(0, 9);
        if (randomNum >= 4) {
            car.moveCar();
        }
    }

    public static void printResult(List<Car> carList) {
        for (Car car : carList) {
            System.out.print(car.getName() + " : ");
            for (int i = 0; i < car.getPosition(); i++) {
                System.out.print("-");
            }
            System.out.print("\n");
        }
        System.out.println("");
    }

    public static List<Car> makeNewCar(List<Car> carList){
        List<Car> newCarList = new ArrayList<>();
        for(Car carIdx : carList){
            Car car = new Car(carIdx.getName());
            newCarList.add(car);
        }
        return newCarList;
    }
}
