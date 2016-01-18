package za.ac.cput.onlineStore.services;

import za.ac.cput.onlineStore.domain.Car;

import java.util.List;

/**
 * Created by student on 2016/01/18.
 */
public interface CarService  extends ServiceTester<Car,Long>{

    public List<Car> getCar();
}
