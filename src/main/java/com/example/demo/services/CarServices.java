package com.example.demo.services;

import com.example.demo.entities.Car;
import com.example.demo.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServices {

    @Autowired
    private CarRepository carRepository;


    public Car createNewCar(Car car){
        return carRepository.saveAndFlush(car);
    }

    public List<Car> getListOfCars(){
        return carRepository.findAll();
    }

    public Car getSingleCar(long id){
       return carRepository.getReferenceById(id);
    }

    public Car updateCar(long id,Car car) throws Exception{
        if (carRepository.existsById(id)){
            Car updatedCar = carRepository.getReferenceById(id);
            updatedCar.setType(car.getType());
            updatedCar.setModelName(car.getModelName());
            return carRepository.save(updatedCar);
        }
        else
            throw new IllegalArgumentException("Choose a car that already exists,this method " +
                    "will only update a car");

    }

    public void deleteById(long id){
        carRepository.deleteById(id);
    }
}
