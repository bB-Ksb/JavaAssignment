class Car {
    private final int speed;          // 차량의 속도
    private final int batteryDrain;   // 차량의 방전율
    private int metersDriven = 0;     // 주행거리
    private int batteryLevel = 100;   // 배터리 레벨
    // private 한 상태이기 때문에 외부에선 해당 변수 참조 불가

    // 객체'차'에 대해 정의
    public Car(int speed, int batteryDrain) {
        // 주행거리를 알기 위해선 시간, 속도를 알아야함 -> 처음엔 시간도 정의했으나 사용하지 않았기 때문에 뺏습니다!
        // 차량의 배터리가 일정 조건을 달성하면 차량은 더이상 주행하지 못함 -> 차량의 방전률을 계산해야함
        this.speed = speed;
        this.batteryDrain = batteryDrain;
        // this 사용으로 인스턴스 변수와 로컬 변수의 의미를 하나로 통일
    }

    public boolean batteryDrained() { // True-false 판별
        // 배터리 레벨이 방전률 이하일 경우 더이상 주행 불가
        return batteryLevel <= batteryDrain;
    }

    public int distanceDriven() {
        // 초기값 0은 이미 선언되었으며, 얼마나 주행할 것인지는 drive 메서드에서 계산함
        return metersDriven;
    }

    public void drive() {
        // 운전이 가능한 상태인지 먼저 판별: batteryDrained() 메서드 결과가 Flase(베터리가 남아있음)일 때만 주행 가능
        if (!batteryDrained()) {
            // 속도만큼 주행함 (+= 사용)
            metersDriven += speed;
            // 주행할때마다 베터리 레벨은 낮아짐( -= 사용)
            batteryLevel -= batteryDrain;
        }
    }
}

class RaceTrack {
    private final int distance;        // 트랙의 길이

    public RaceTrack(int distance) {
        // 입력되는 길이로 경주 트랙 생성
        this.distance = distance;
    }

    // 자동차가 트랙을 완주할 수 있는지 확인하는 메서드
    public boolean tryFinishTrack(Car car) {
        // 자동차의 주행거리가 트랙보다 짧고, 배터리 용량이 남아있을 경우에만 주행 반복
        while (car.distanceDriven() < distance && !car.batteryDrained()) {
            // class 에서 이미 정의한 drive 메서드를 사용함
            car.drive();
        }
        // 주어진 자동차가 트랙을 완주했는지 여부를 확인하고,
        // 트랙을 완주하면 true, 완주하지 못했다면 false 를 반환
        return car.distanceDriven() >= distance;
    }
}

public class RaceDemo {
    public static void main(String[] args) {
        int speed = 5;
        int batteryDrain = 2;
        var yellowcar = new Car(speed, batteryDrain);
        yellowcar.drive();
        //속도 3, 베터리 레벨이 2인 노란 자동차
        System.out.println(yellowcar.distanceDriven());
        System.out.println(yellowcar.batteryDrained());

        int distance = 100;
        var greencar = new Car(speed, batteryDrain);
        var race = new RaceTrack(distance);
        System.out.println(greencar.distanceDriven());
        System.out.println(race.tryFinishTrack(greencar));
        System.out.println(greencar.distanceDriven());
    }
}

