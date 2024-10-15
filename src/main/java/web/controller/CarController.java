package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.models.Car;
import web.service.CarServiceImpl;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController {
    @GetMapping(value = "/cars")
    public String printCars(ModelMap model, @RequestParam(required = false) Integer count) {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Audi", 1999, "yellow"));
        cars.add(new Car("Toyota", 1976, "white"));
        cars.add(new Car("Mazda", 2015, "black"));
        cars.add(new Car("BMW", 1999, "white"));
        cars.add(new Car("Lada", 2000, "red"));

        if (count == null || count >= cars.size()) {
            model.addAttribute("cars", cars);
        } else {
            CarServiceImpl carService = new CarServiceImpl();
            List<Car> result = carService.getCars(cars, count);

            model.addAttribute("cars", result);
        }

        return "cars";
    }
}
