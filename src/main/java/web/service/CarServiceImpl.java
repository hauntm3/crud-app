package web.service;

import web.models.Car;

import java.util.ArrayList;
import java.util.List;

public class CarServiceImpl implements CarService {
    public List<Car> getCars(List<Car> cars, int carsQuantity) {
        List<Car> carsList = new ArrayList<>();
        for (int i = 0; i < carsQuantity; i++) {
            carsList.add(cars.get(i));
        }
        return carsList;
    }
}
