package web.dao;

import web.model.Car;

import java.util.List;

public interface CarDAO {

    List<Car> getAllCars();

    List<Car> getSomeCars(Long size);
}
