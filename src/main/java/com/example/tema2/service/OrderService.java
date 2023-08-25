package com.example.tema2.service;

import com.example.tema2.model.Order;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Getter
@Service
public class OrderService {
    private final List<Order> orderList = new ArrayList<>();

    public void saveOrder(Order order) {
        orderList.add(order);
    }
}
