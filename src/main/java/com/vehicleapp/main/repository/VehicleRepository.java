package com.vehicleapp.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vehicleapp.main.model.Vehicle;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Integer>  {

}
