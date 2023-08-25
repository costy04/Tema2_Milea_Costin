package com.example.tema2.controller;

import com.example.tema2.model.Flower;
import com.example.tema2.model.Order;
import com.example.tema2.service.OrderService;
import com.example.tema2.service.FlowerService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping ("api/flower")
public class FlowerController {

    private final FlowerService flowerService;
    private final OrderService orderService;

    @GetMapping()
    public List<Flower> getAllFlowers() {
        return flowerService.getFlowerList();
    }

    @PostMapping()
    public void createFlower(@RequestBody Flower flower) {
        flowerService.saveFlower(flower);
    }

    @PutMapping
    public void updateFlower(@RequestBody Flower flower) {
        flowerService.updateFlower(flower);
    }

    @PostMapping("buy")
    public void buyFlower (@RequestParam("flowerId") Long flowerId, @RequestParam("quantity") Integer quantity) {
        flowerService.buyFlower(flowerId, quantity);
        Flower flowerToAddInOrder = flowerService.findFlowerById(flowerId);
        Order order = new Order((long)orderService.getOrderList().size(),quantity,flowerToAddInOrder.getPrice()*quantity,flowerToAddInOrder);
        orderService.saveOrder(order);
    }
}
