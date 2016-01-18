package za.ac.cput.onlineStore.services.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.onlineStore.domain.Car;
import za.ac.cput.onlineStore.repository.CarRepo;
import za.ac.cput.onlineStore.services.CarService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2016/01/18.
 */
@Service
public class CarImpl implements CarService {

    @Autowired
    CarRepo carRepo;


    private Long id;

    @Override
    public Car findById(Long id) {
        return carRepo.findOne(id);
    }

    @Override
    public Car save(Car entity) {return carRepo.save(entity);}

    @Override
    public Car update(Car entity) {
        return carRepo.save(entity);
    }

    @Override
    public void delete(Car entity) {carRepo.delete(entity);}

    @Override
    public List<Car> findAll() {
        return null;
    }


    @Override
    public List<Car> getCar()
    {
        java.util.List<Car> allCars = new ArrayList<Car>();

        Iterable<Car> cars = carRepo.findAll();

        for (Car car : cars)
        {
            allCars.add(car);
        }

        return allCars;
    }

}

