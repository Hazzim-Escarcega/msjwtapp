package atos.upgrade.jwtexample.carservice.service;

import atos.upgrade.jwtexample.carservice.entity.Car;
import atos.upgrade.jwtexample.carservice.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    @Autowired
    CarRepository carRepository;

    public List<Car> getAll() {
        return carRepository.findAll();
    }

    public Car getCarById(Long id) {
        return carRepository.findById(id).orElse(null);
    }

    public Car saveCar(Car car) {
        return carRepository.save(car);
    }

    public List<Car> findByUserId(Long userId) {
        return carRepository.findByUserId(userId);
    }


}
