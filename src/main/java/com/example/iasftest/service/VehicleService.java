package com.example.iasftest.service;

import com.example.iasftest.entity.Vehicle;
import com.example.iasftest.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    public Vehicle getVehicleById(long id) {
        return vehicleRepository.findById(id).orElse(null);
    }
    public void saveVehicle(Vehicle vehicle) {vehicleRepository.save(vehicle);}

    public void deleteVehicle(long id) {vehicleRepository.deleteById(id);}
}

