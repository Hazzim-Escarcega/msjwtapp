package atos.upgrade.jwtexample.userservice.feignclients;

import atos.upgrade.jwtexample.userservice.model.Car;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "car-service", url = "http://localhost:3334")
public interface CarFeignClient {
    @PostMapping("/car/")
    Car save (@RequestBody Car car);

    @GetMapping("/car/findbyuser/{userId}")
    List<Car> getCars(@PathVariable("userId") Long userId);
}

