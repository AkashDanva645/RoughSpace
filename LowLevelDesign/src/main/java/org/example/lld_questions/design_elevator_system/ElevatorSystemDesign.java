package org.example.lld_questions.design_elevator_system;
import java.util.TreeSet;


interface ElevatorState {
    boolean allowDoorOpen();
    void run();
}


class UpState implements ElevatorState, Runnable {

    Elevator elevator;

    UpState(Elevator elevator) {
        this.elevator = elevator;
    }

    @Override
    public boolean allowDoorOpen() {
        return false;
    }

    @Override
    public void run() {
        while (elevator.currFloor != elevator.destination) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " - Thread Interrupted");
            }
            elevator.currFloor++;
            System.out.println(this.elevator.name + " is at Floor -> " + elevator.currFloor);
        }
    }
}


class DownState implements ElevatorState, Runnable {

    Elevator elevator;

    DownState(Elevator elevator) {
        this.elevator = elevator;
    }

    @Override
    public boolean allowDoorOpen() {
        return false;
    }

    @Override
    public void run() {
        while (elevator.currFloor != elevator.destination) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " - Thread Interrupted");
            }
            elevator.currFloor--;
            System.out.println(this.elevator.name + " is at Floor -> " + elevator.currFloor);
        }
    }
}


class IdleState {

}


class Elevator {
    String name;
    TreeSet<Integer> destinations;
    int currFloor;
    int capacity;
    int passengerCount;
    int isDoorOpen;
    ElevatorState state;

    Elevator() {
        this.destinations = new TreeSet<>();
    }

    void changeState(ElevatorState state) {
        this.state = state;
        this.run();
    }

    void run() {
        this.state.run();
    }

    private boolean isWeightExceeded() {
        return passengerCount > capacity;
    }
}


class ElevatorSystemControl implements Runnable {

    boolean isStopRequested;

    @Override
    public void run() {
    }
}

public class ElevatorSystemDesign {
    public static void main(String[] args) {

    }
}
