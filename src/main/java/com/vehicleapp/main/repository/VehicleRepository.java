package com.vehicleapp.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vehicleapp.main.controller.vehicle;
import com.vehicleapp.main.model.Vehicle;

@Repository
//public interface VehicleRepository extends JpaRepository<Vehicle, Integer>  {
public interface VehicleRepository extends CrudRepository<Vehicle, Integer>  {
	
//	@Query("SELECT id, year, make, model FROM Vehicle WHERE year = :year") 
//    List<Vehicle> findVehicleByYear(@Param("year") Integer year);
	List<Vehicle> findByYear(Integer year);
	
//	@Query("SELECT v.id, v.year, v.make, v.model FROM Vehicle v WHERE v.make = :make")
//	List<Vehicle> findByMake(@Param("make") String make);
	List<Vehicle> findByMake(String make);
	
	//find vehicle by specific year & make

}
