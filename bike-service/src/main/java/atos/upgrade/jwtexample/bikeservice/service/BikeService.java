package atos.upgrade.jwtexample.bikeservice.service;

import atos.upgrade.jwtexample.bikeservice.entity.Bike;
import atos.upgrade.jwtexample.bikeservice.repository.BikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BikeService {
    @Autowired
    BikeRepository bikeRepository;

    public List<Bike> getAll() {
        return bikeRepository.findAll();
    }

    public Bike getBikeById(Long id) {
        return bikeRepository.findById(id).orElse(null);
    }

    public Bike saveBike(Bike bike) {
        return bikeRepository.save(bike);
    }

    public List<Bike> findByUserId(Long userId) {
        return bikeRepository.findByUserId(userId);
    }


}
