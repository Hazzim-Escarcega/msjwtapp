package atos.upgrade.jwtexample.carservice.repository;

import atos.upgrade.jwtexample.carservice.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findByUserId(Long userid);
}
