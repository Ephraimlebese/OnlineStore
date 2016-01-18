package za.ac.cput.onlineStore.repository;

import org.springframework.data.repository.CrudRepository;
import za.ac.cput.onlineStore.domain.Invoice;

/**
 * Created by student on 2016/01/18.
 */
public interface InvoiceRepo extends CrudRepository<Invoice, Long> {
}
