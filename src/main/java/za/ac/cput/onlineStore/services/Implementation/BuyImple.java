package za.ac.cput.onlineStore.services.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.onlineStore.domain.Buy;
import za.ac.cput.onlineStore.domain.Car;
import za.ac.cput.onlineStore.repository.BuyRepo;
import za.ac.cput.onlineStore.repository.CarRepo;
import za.ac.cput.onlineStore.services.BuyService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2016/01/18.
 */
@Service
public class BuyImple  implements BuyService{

    @Autowired
    BuyRepo buyRepo;

    @Override
    public List<Buy>  getPrice()
    {
        java.util.List<Buy> price = new ArrayList<Buy>();

        Iterable<Buy> buys = buyRepo.findAll();

        for (Buy buyer : buys)
        {
            price.add(buyer);
        }

        return price;
    }
}
