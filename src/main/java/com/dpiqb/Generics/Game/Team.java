package com.dpiqb.Generics.Game;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@AllArgsConstructor
public class Team <T extends Participant>{
    private String name;
    private final List<T> participants = new ArrayList<>();
    public void addNewParticipant(T newParticipant){
        participants.add(newParticipant);
        System.out.println(newParticipant.getName() + " was added to team: " + name);
    }
    public void playWith(Team<T> team){
        String winnerName;
        Random random = new Random();
        int i = random.nextInt(2);
        winnerName = i == 0 ? this.name : team.name;
        System.out.println(winnerName + " <- WINS !!!");
    }
}
