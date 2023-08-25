package com.example.tema2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private Long id;
    private Integer quantity;
    private Double totalPrice;
    private Long flowerId;
}
