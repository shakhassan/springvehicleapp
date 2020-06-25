package com.vehicleapp.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vehicleapp.main.model.Vehicle;
import com.vehicleapp.main.repository.VehicleRepository;

@Controller
public class vehicle {
	
	@Autowired 
	private VehicleRepository vehicleRepository;
	
	@RequestMapping(value = "/ex/foos", method = RequestMethod.GET)
	@ResponseBody
	public String getFoosBySimplePath() {
	    return "Get some Foos";
	}
	
	@GetMapping(path="/vehicles")
	public @ResponseBody List<Vehicle> getAllVehicles() {
		// This returns a JSON or XML with the users
		return vehicleRepository.findAll();
	}

}
