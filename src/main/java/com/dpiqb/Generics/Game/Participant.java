package com.dpiqb.Generics.Game;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public abstract class Participant {
    private String name;
    private int age;
}
