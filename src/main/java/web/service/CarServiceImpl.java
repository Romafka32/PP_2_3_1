package web.service;


import org.springframework.stereotype.Service;
import web.dao.CarDAO;
import web.model.Car;
import java.util.List;


@Service
public class CarServiceImpl implements CarService{

    CarDAO carDAO;

    public CarServiceImpl(CarDAO carDAO) {
        this.carDAO = carDAO;
    }

    @Override
    public List<Car> getAllCars() {
        return carDAO.getAllCars();
    }

    @Override
    public List<Car> getSomeCars(Long size) {
        return carDAO.getSomeCars(size);
    }
}
