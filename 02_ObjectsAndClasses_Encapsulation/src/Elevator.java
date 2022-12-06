public class Elevator {
    private int currentFloor = 1;
    private final int minFloor;
    private final int maxFloor;


    public Elevator(int minFloor, int maxFloor) {
        this.minFloor = minFloor;
        this.maxFloor = maxFloor;
    }


    public void getCurrentFloor() {
        System.out.println("лифт на " + currentFloor + " этаже");
    }


    public void moveDown(int floor) {
        if (currentFloor > floor) {
            for (int j = currentFloor; j > floor; j--) {
                currentFloor--;
                getCurrentFloor();
            }
        } else {
            System.out.println("лифту некуда двигаться");
        }
    }

    public void moveUp(int floor) {
        if (currentFloor < floor) {
            for (int j = currentFloor; j < floor; j++) {
                currentFloor++;
                getCurrentFloor();
            }
        } else {
            System.out.println("лифту некуда двигаться");
        }
    }

    public void move(int floor) {
        if (floor > maxFloor || floor < minFloor) {
            System.out.println("Этаж задан неверно!");
            return;
        }

        if (floor < currentFloor) {
            moveDown(floor);
            System.out.println("текущий этаж = " + currentFloor);
        }

        if (floor > currentFloor) {
            moveUp(floor);
            System.out.println(currentFloor);
        }
    }
}
