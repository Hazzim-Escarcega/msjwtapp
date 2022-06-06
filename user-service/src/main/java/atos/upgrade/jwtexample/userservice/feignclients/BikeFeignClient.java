package atos.upgrade.jwtexample.userservice.feignclients;

import atos.upgrade.jwtexample.userservice.model.Bike;
import atos.upgrade.jwtexample.userservice.model.Car;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "bike-service", url = "http://localhost:3335")
public interface BikeFeignClient {
    @PostMapping("/bike/")
    Bike save (@RequestBody Bike bike);

    @GetMapping("/bike/findbyuser/{userId}")
    List<Bike> getBikes(@PathVariable("userId") Long userId);
}
