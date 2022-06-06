package atos.upgrade.jwtexample.bikeservice.controller;

import atos.upgrade.jwtexample.bikeservice.entity.Bike;
import atos.upgrade.jwtexample.bikeservice.service.BikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bike")
public class BikeController {
    @Autowired
    private BikeService bikeService;

    @GetMapping("/")
    ResponseEntity<List<Bike>> getAllCars() {
        List<Bike> bikes = bikeService.getAll();
        if (bikes.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(bikes);
    }
    @GetMapping("/{id}")
    ResponseEntity<Bike> getCarById(@PathVariable("id") Long id) {
        Bike bike = bikeService.getBikeById(id);
        if (bike == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(bike);
    }
    @GetMapping("/findbyuser/{userId}")
    ResponseEntity<List<Bike>> getByUserId(@PathVariable("userId") Long userId) {
        List<Bike> bikes = bikeService.findByUserId(userId);
        return ResponseEntity.ok(bikes);
    }
    @PostMapping("/")
    ResponseEntity<Bike> saveCar(@RequestBody Bike bike) {
        Bike bikeNew = bikeService.saveBike(bike);
        if (bike == null) {
            return ResponseEntity.ok(bikeNew);
        }
        return ResponseEntity.ok(bikeNew);
    }

}
