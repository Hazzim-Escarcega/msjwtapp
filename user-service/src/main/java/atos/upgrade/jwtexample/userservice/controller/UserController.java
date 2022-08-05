package atos.upgrade.jwtexample.userservice.controller;

import atos.upgrade.jwtexample.userservice.entity.AppUser;
import atos.upgrade.jwtexample.userservice.model.Bike;
import atos.upgrade.jwtexample.userservice.model.Car;
import atos.upgrade.jwtexample.userservice.service.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/")
    ResponseEntity<List<AppUser>> getAllUsers() {
        List<AppUser> users = userService.getAll();
        if (users.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(users);
    }
    @GetMapping("/{id}")
    ResponseEntity<AppUser>getById(@PathVariable("id") Long id) {
        AppUser user = userService.getUserById(id);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }

    @PostMapping("/")
    ResponseEntity<AppUser> save(@RequestBody AppUser user) {
        AppUser userNew = userService.save(user);
        if (user == null) {
            return ResponseEntity.ok(userNew);
        }
        return ResponseEntity.ok(user);
    }
    @CircuitBreaker(name = "carsCB", fallbackMethod = "fallbackGetCars")
    @GetMapping("/cars/{userId}")
    public ResponseEntity<List<Car>> getCars(@PathVariable("userId") Long userId) {
        AppUser user = userService.getUserById(userId);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        List<Car> cars = userService.getCars(userId);
        return ResponseEntity.ok(cars);
    }@CircuitBreaker(name = "bikesCB", fallbackMethod = "fallbackGetBikes")
    @GetMapping("/bikes/{userId}")
    public ResponseEntity<List<Bike>> getBikes(@PathVariable("userId") Long userId) {
        AppUser user = userService.getUserById(userId);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        List<Bike> bikes = userService.getBikes(userId);
        return ResponseEntity.ok(bikes);
    }
    @CircuitBreaker(name = "carsCB", fallbackMethod = "fallbackSaveCars")
    @PostMapping("/savecar/{userId}")
    public ResponseEntity<Car> saveCar(@PathVariable("userId") Long userId, @RequestBody Car car) {
        if (userService.getUserById(userId) == null) {
            return ResponseEntity.notFound().build();
        }
        Car carNew = userService.saveCar(userId, car);
        return ResponseEntity.ok(car);
    }
    @CircuitBreaker(name = "bikesCB", fallbackMethod = "fallbackSaveBikes")
    @PostMapping("/savebike/{userId}")
    public ResponseEntity<Bike> saveBike(@PathVariable("userId") Long userId, @RequestBody Bike bike) {
        if (userService.getUserById(userId) == null) {
            return ResponseEntity.notFound().build();
        }
        Bike bikeNew = userService.saveBike(userId, bike);
        return ResponseEntity.ok(bike);
    }
    @CircuitBreaker(name = "allCB", fallbackMethod = "fallbackGetAll")
    @GetMapping("/getAll/{userId}")
    public ResponseEntity<Map<String, Object>> getAllVehicles(@PathVariable("userId") int userId) {
        Map<String, Object> result = userService.getUserAndVehicles(userId);
        return ResponseEntity.ok(result);
    }

    private ResponseEntity<List<Car>> fallbackGetCars (@PathVariable("userId") Long userId) {
        return new ResponseEntity("El usuario "+userId+" tiene los coches en el taller", HttpStatus.OK);
    }
    private ResponseEntity<List<Bike>> fallbackGetBikes (@PathVariable("userId") Long userId) {
        return new ResponseEntity("El usuario "+userId+" tiene las motos en el taller", HttpStatus.OK);
    }
    private ResponseEntity<Car> fallbackSaveCar(@PathVariable("userId") Long userId, @RequestBody Car car, RuntimeException e) {
        return new ResponseEntity("El usuario "+userId+" no tiene dinero para autos", HttpStatus.OK);
    }
    private ResponseEntity<Car> fallbackSaveBike(@PathVariable("userId") Long userId, @RequestBody Bike bike, RuntimeException e) {
        return new ResponseEntity("El usuario "+userId+" no tiene dinero para motos", HttpStatus.OK);
    }
    private ResponseEntity<Map<String, Object>> fallbackGetAll(@PathVariable("userId") int userId, RuntimeException e) {
        return new ResponseEntity("El usuario "+userId+" tiene los vehiculos en el taller", HttpStatus.OK);
    }


}
