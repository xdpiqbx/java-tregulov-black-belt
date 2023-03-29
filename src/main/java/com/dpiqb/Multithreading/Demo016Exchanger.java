package com.dpiqb.Multithreading;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;

public class Demo016Exchanger {
    public static void main(String[] args) {
        Exchanger<Action> exchanger = new Exchanger<>();

        List<Action> player1Actions = new ArrayList<>();
        player1Actions.add(Action.SCISSORS);
        player1Actions.add(Action.PAPER);
        player1Actions.add(Action.SCISSORS);

        List<Action> player2Actions = new ArrayList<>();
        player2Actions.add(Action.PAPER);
        player2Actions.add(Action.ROCK);
        player2Actions.add(Action.ROCK);

        Thread thread1 = new Thread(new Player("Bill", player1Actions, exchanger));
        Thread thread2 = new Thread(new Player("John", player2Actions, exchanger));

        thread1.start();
        thread2.start();
    }
}

enum Action {
    ROCK, SCISSORS, PAPER
}

@AllArgsConstructor
class Player extends Thread {
    private String name;
    private List<Action> myActions;
    private Exchanger<Action> exchanger;

    private void whoWins(Action myAction, Action friendAction) {
        if ((myAction == Action.ROCK && friendAction == Action.SCISSORS)
                || (myAction == Action.SCISSORS && friendAction == Action.PAPER)
                || (myAction == Action.PAPER && friendAction == Action.ROCK)) {
            System.out.println(this.name + " WINS!");
        }
    }

    @Override
    public void run() {
        Action replay;
        for (Action action : myActions) {
            try {
                replay = exchanger.exchange(action);
                whoWins(action, replay);
                sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}