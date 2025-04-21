package org.example.lld_questions.design_a_parking_lot.domain.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Floor {
    int id;
    int capacity;
    List<Spot> spots;
}
