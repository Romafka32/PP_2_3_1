package web.service;

import org.springframework.stereotype.Component;
import web.model.Car;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Component
public class CarServiceImpl implements CarService{

    private static List<Car> carList;

    {
        carList = new ArrayList<>();
        carList.add(new Car("Audi", 123, "coupe"));
        carList.add(new Car("Alfa Romeo", 321, "sedan"));
        carList.add(new Car("Mercedes", 771, "cabriolet"));
        carList.add(new Car("VW", 587, "van"));
        carList.add(new Car("Delage", 777, "retro-car"));
    }

    @Override
    public List<Car> getAllCars() {
        return carList;
    }

    @Override
    public List<Car> getSomeCars(Long size) {
        return carList.stream().limit(size).collect(Collectors.toList());
    }
}
