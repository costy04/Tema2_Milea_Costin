package com.example.tema2.service;

import com.example.tema2.model.Flower;
import lombok.Data;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Getter
public class FlowerService {

    public final List<Flower> flowerList = new ArrayList <>();

    public void saveFlower(Flower flower) {
        flower.setId((long) flowerList.size());
        flowerList.add(flower);
    }

    public void updateFlower (Flower flower) {
        Flower selectedFlower = null;
        for (Flower flowerItr : flowerList) {
            if (flowerItr.getId().equals(flower.getId())) {
                selectedFlower = flowerItr;
                break;
            }
        }
        if (selectedFlower == null) return;

        if (flower.getStock() != null) {
            selectedFlower.setStock(flower.getStock());
        }
        if (flower.getPrice() != null) {
            selectedFlower.setPrice(flower.getPrice());
        }
    }

    public boolean buyFlower (Long flowerId, Integer quantity) {
        Flower selectedFlower = null;
        for (Flower flowerItr : flowerList) {
            if (flowerItr.getId().equals(flowerId)) {
                selectedFlower = flowerItr;
                break;
            }
        }
        if (selectedFlower == null | selectedFlower.getStock() < quantity) return false;

        selectedFlower.setStock(selectedFlower.getStock() - quantity);
        return true;

    }

    public Flower findFlowerById (Long flowerId){
        Flower selectedFlower = null;
        for (Flower flowerItr : flowerList) {
            if (flowerItr.getId().equals(flowerId)) {
                selectedFlower = flowerItr;
                return flowerItr;
            }
        }
        return null;
    }
}
