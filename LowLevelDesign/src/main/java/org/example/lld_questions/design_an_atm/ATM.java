package org.example.lld_questions.design_an_atm;

enum Button {
    ZERO, ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, ENTER, CANCEL, CLEAR
}

class KeyPad implements Runnable {
    @Override
    public void run() {

    }
}

class Display {
    void show(String msg) {
        System.out.println(msg);
    }
}

interface ATMState {
    void pressButton(Button button);
    void changeState(ATMState nextState);
    void showOnDisplay(String msg);
}

class RequestPin implements ATMState {

}

class IdealState implements ATMState {

}

class OptionState implements ATMState {

}

class DispenseCash implements ATMState {

}

class CashSlot {

    public void placeChequeInChequeHolder() {

    }

    public void placeCashInCashHolder() {

    }

    public void open() {
        System.out.println("Cash Slot Opened");
    }

    public void close() {
        System.out.println()
    }
}

class CardReader implements Runnable {
    public void run() {

    }
}

class ChequeReader {

}

class Printer {

}

class BankService {

}

public class ATM {
    public static void main(String[] args) {

    }
}
