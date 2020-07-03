package com.vehicleapp.main.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vehicleapp.main.model.Vehicle;
import com.vehicleapp.main.repository.VehicleRepository;
import com.vehicleapp.main.service.VehicleService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
@RequestMapping("/vehicles")
public class vehicle {
	
	final Logger logger = LoggerFactory.getLogger(vehicle.class);
	
	@Autowired
	private VehicleService vehicleService; 
	
	@Autowired 
	private VehicleRepository vehicleRepository;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ResponseBody
	public Iterable<Vehicle> getAllVehicles() {
		
		Iterable<Vehicle> vehicle = vehicleService.findAll();		
		return vehicle;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Optional<Vehicle> getVehicleById(@PathVariable("id") Integer id) {
		
	    logger.info("Get a specific vehicle with id = " + id);
	    return vehicleService.getById(id);
	    
	}
	
	//get vehicle by make
	
	@GetMapping("/make/{make}")
	@ResponseBody
	public List<Vehicle> getVehicleByMake(@PathVariable("make") String make) {
		
		logger.info("Get a specific vehicle by maker = " + make);
		List<Vehicle> vehicle = vehicleRepository.findByMake(make);
		
		return vehicle;
		
	}
	
	//get vehicle by year
	
	@RequestMapping(value = "/year/{year}", method = RequestMethod.GET)
	@ResponseBody
	public List<Vehicle> getVehicleByYear(@PathVariable("year") Integer year) {
		
		logger.info("Get a specific vehicle by year = " + year);
		List<Vehicle> vehicle = vehicleService.getByYear(year);
		
		return vehicle;
		
	}
	
	//Add new vehicle
	
	@PostMapping(path="") 
	public @ResponseBody Vehicle AddNewVehicle (@RequestBody Vehicle vehicle) {
		
		String make = vehicle.getMake();
		String model = vehicle.getModel();
		Integer year = vehicle.getYear();
		
		logger.info("Add new vehicle = " + make + " " + model + " " + year);

		return vehicleService.addVehicle(vehicle);
	}
	
	//Update vehicle by id
	
	@PutMapping("/{id}")
	@ResponseBody
//	Vehicle replaceEmployee(@RequestBody Vehicle newVehicle, @PathVariable Integer id) {
	public String replaceEmployee(@RequestBody Vehicle newVehicle, @PathVariable Integer id) {
		
		logger.info("UPDATE specific vehicle with id=" + id);

//		return vehicleRepository.findById(id)
//				.map(vehicle -> {
//					vehicle.setModel(newVehicle.getModel());
//					return vehicleRepository.save(vehicle);
//				})
//				.orElseGet(() -> {
//					newVehicle.setId(id);
//					return vehicleRepository.save(newVehicle);
//				});
		
		return vehicleService.updateVehicleById(id, newVehicle);
	}
	
	
	//Remove vehicle by id
	
	@DeleteMapping(path="") 
	public @ResponseBody String deleteVehicleById (@RequestParam Integer id) {

		logger.info("Delete vehicle by id = " + id);
		
		return vehicleService.deleteVehicle(id);
	}

}
