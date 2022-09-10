package com.example.demo.controllers;

import com.example.demo.entities.Car;
import com.example.demo.repository.CarRepository;
import com.example.demo.services.CarServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class Controllers {

    @Autowired
    private CarServices carServices;
    @Autowired
    private CarRepository carRepository;

    @PostMapping("/create-car")
    public Car createCar(@RequestBody Car car){
        return carServices.createNewCar(car);
    }
    @GetMapping("/car-list")
    public List<Car> listOfcars(){
        return carServices.getListOfCars();
    }

    @GetMapping("/single-car")
    public Car getSingleCar(@RequestParam(value = "id") long id){
        return carServices.getSingleCar(id);
    }

    @PutMapping("/update-car/{id}")
    public Car carUpdate(@PathVariable long id ,@RequestBody Car car) throws Exception{
        return carServices.updateCar(id,car);
    }

    @DeleteMapping("/delete-car/{id}")
    public void  delete(@PathVariable long id){
        carServices.deleteById(id);
    }


}
