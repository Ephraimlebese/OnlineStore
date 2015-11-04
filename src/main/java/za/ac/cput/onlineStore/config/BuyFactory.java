package za.ac.cput.onlineStore.config;

import za.ac.cput.onlineStore.domain.Buy;
import za.ac.cput.onlineStore.domain.Car;

import java.util.List;

/**
 * Created by student on 2015/10/15.
 */
public class BuyFactory {
    public static Buy createBuy(String price, List<Car> cars){
        Buy buy = new Buy
                .Builder(price)
                .cars(cars)
                .build();
        return buy;
    }
}
