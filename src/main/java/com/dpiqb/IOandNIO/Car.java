package com.dpiqb.IOandNIO;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@AllArgsConstructor
@ToString
public class Car implements Serializable {
    String model;
    String color;
}
