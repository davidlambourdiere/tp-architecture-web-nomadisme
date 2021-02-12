package com.memda.object;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;

@Data
@Builder
@AllArgsConstructor
public class Bike {

    private String model;
    private Double price;
    private String identification;
    private String owner;

}
