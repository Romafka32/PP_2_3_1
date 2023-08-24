package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import web.service.CarService;

import java.util.Optional;

@Controller
@RequestMapping("/cars")
public class CarsController {
    private final CarService carService;

    public CarsController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public String getCars(@RequestParam("count") Optional<Long> id, ModelMap model) {
        if (id.isEmpty()) {
            model.addAttribute("carlist", carService.getAllCars());
        } else model.addAttribute("carlist", carService.getSomeCars(id.orElse(5L)));
        return "cars/cars";
    }
}
