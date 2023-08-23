package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import web.service.CarService;

@Controller
@RequestMapping("/cars")
public class CarsController {
    private final CarService carService;

    public CarsController(CarService carService) {
        this.carService = carService;
    }

    /*@GetMapping
    public String getAllCars(ModelMap model) {
        model.addAttribute("carlist", carService.getAllCars());
        return "cars/cars";
    }*/

    @GetMapping
    public String getCars(@RequestParam(name = "count", required = false) String count,  ModelMap model) {
        if (count != null) {
            model.addAttribute("carlist", carService.getSomeCars(Long.parseLong(count)));
        } else model.addAttribute("carlist", carService.getAllCars());
        return "cars/cars";
    }
}
