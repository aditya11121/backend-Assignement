package com.assignment.irrigation.collections.subCollection;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Location {
    private String type;
    private ArrayList<Double> coordinates;
}
