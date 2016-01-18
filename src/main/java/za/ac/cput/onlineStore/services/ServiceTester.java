package za.ac.cput.onlineStore.services;

import java.util.List;

/**
 * Created by student on 2016/01/18.
 */
public interface ServiceTester <S, ID> {


    public S findById(ID id);

    public S save(S entity);

    public S update(S entity);

    public void delete(S entity);

    public List<S> findAll();
}




