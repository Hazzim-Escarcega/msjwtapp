package atos.upgrade.jwtexample.userservice.service;

import atos.upgrade.jwtexample.userservice.entity.AppUser;
import atos.upgrade.jwtexample.userservice.feignclients.BikeFeignClient;
import atos.upgrade.jwtexample.userservice.feignclients.CarFeignClient;
import atos.upgrade.jwtexample.userservice.model.Bike;
import atos.upgrade.jwtexample.userservice.model.Car;
import atos.upgrade.jwtexample.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    CarFeignClient carFeignClient;

    @Autowired
    BikeFeignClient bikeFeignClient;

    public List<AppUser> getAll() {
        return userRepository.findAll();
    }

    public AppUser getUserById(long id) {
        return userRepository.findById(id).orElse(null);
    }

    public AppUser save (AppUser user) {
        return userRepository.save(user);
    }

    public List<Car> getCars(long userId) {

        return restTemplate.getForObject("http://car-service/car/findbyuser/" + userId, List.class);
    }
    public List<Bike> getBikes(long userId) {

        return restTemplate.getForObject("http://bike-service/bike/findbyuser/" + userId, List.class);
    }
    public Car saveCar(long userId, Car car) {
        car.setUserId(userId);
        Car carNew = carFeignClient.save(car);
        return carNew;
    }
    public Bike saveBike(long userId, Bike bike) {
        bike.setUserId(userId);
        Bike bikeNew = bikeFeignClient.save(bike);
        return bikeNew;
    }
    public Map<String, Object> getUserAndVehicles(long userId) {
        Map<String, Object> result = new HashMap<>();
        AppUser user = userRepository.findById(userId).orElse(null);
        if(user == null) {
            result.put("Mensaje", "no existe el usuario");
            return result;
        }
        result.put("User", user);
        List<Car> cars = carFeignClient.getCars(userId);
        if(cars.isEmpty())
            result.put("Cars", "ese user no tiene coches");
        else
            result.put("Cars", cars);
        List<Bike> bikes = bikeFeignClient.getBikes(userId);
        if(bikes.isEmpty())
            result.put("Bikes", "ese user no tiene motos");
        else
            result.put("Bikes", bikes);
        return result;
    }
}


