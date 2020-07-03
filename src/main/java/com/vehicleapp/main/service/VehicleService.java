package com.vehicleapp.main.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vehicleapp.main.model.Vehicle;
import com.vehicleapp.main.repository.VehicleRepository;

@Service
public class VehicleService {
	
	@Autowired 
	private VehicleRepository vehicleRepository;
	
	public List<Vehicle> findAll() {

        return (List<Vehicle>) vehicleRepository.findAll();
    }
	
	public Optional<Vehicle> getById(Integer id) {

        return (Optional<Vehicle>) vehicleRepository.findById(id);
    }
	
	public List<Vehicle> getByYear(Integer year) {

        return (List<Vehicle>) vehicleRepository.findByYear(year);
    }
	
	public List<Vehicle> getByMake(String make) {

        return (List<Vehicle>) vehicleRepository.findByMake(make);
    }
	
	public Vehicle addVehicle(Vehicle vehicle) {
		
		Vehicle v = new Vehicle();
		v.setMake(vehicle.getMake());
		v.setModel(vehicle.getModel());
		v.setYear(vehicle.getYear());
		vehicleRepository.save(v);

        return v;
    }
	
	public String updateVehicleById(Integer id, Vehicle vehicle) {

		Optional<Vehicle> vehicleData = vehicleRepository.findById(id);
		
		Vehicle newVehicle = null;
		
		if (vehicleData != null) {			
			
			newVehicle.setModel(vehicle.getModel());
			vehicleRepository.save(newVehicle);
			return "Successfully update vehicle by ID = " + id;
			
		} else {
			return "Vehicle not exist";
		}			

		
	}
	
	public String deleteVehicle(Integer id) {
		
		vehicleRepository.deleteById(id);
		return "Successfully deleted vehicle with id = " + id;
		
	}

}
