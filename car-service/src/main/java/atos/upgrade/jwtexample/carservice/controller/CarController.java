package atos.upgrade.jwtexample.carservice.controller;

import atos.upgrade.jwtexample.carservice.entity.Car;
import atos.upgrade.jwtexample.carservice.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car")
public class CarController {
    @Autowired
    private CarService carService;

    @GetMapping("/")
    ResponseEntity<List<Car>> getAllCars() {
        List<Car> cars = carService.getAll();
        if (cars.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(cars);
    }
    @GetMapping("/{id}")
    ResponseEntity<Car> getCarById(@PathVariable("id") Long id) {
        Car car = carService.getCarById(id);
        if (car == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(car);
    }
    @GetMapping("/findbyuser/{userId}")
    ResponseEntity<List<Car>> getByUserId(@PathVariable("userId") Long userId) {
        List<Car> cars = carService.findByUserId(userId);
        return ResponseEntity.ok(cars);
    }
    @PostMapping("/")
    ResponseEntity<Car> saveCar(@RequestBody Car car) {
        Car carNew = carService.saveCar(car);
        if (car == null) {
            return ResponseEntity.ok(carNew);
        }
        return ResponseEntity.ok(carNew);
    }

}
