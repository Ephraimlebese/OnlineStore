package za.ac.cput.onlineStore.repositoryTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;
import za.ac.cput.onlineStore.OnlineStoreApplication;
import za.ac.cput.onlineStore.domain.Invoice;
import za.ac.cput.onlineStore.repository.EmployeeRepo;
import za.ac.cput.onlineStore.repository.InvoiceRepo;

/**
 * Created by student on 2016/01/18.
 */

@SpringApplicationConfiguration(classes = {OnlineStoreApplication.class})
@WebAppConfiguration

public class InvoiceCrudTest extends AbstractTestNGSpringContextTests {

    private Long id;

    @Autowired
    InvoiceRepo repository;


    @Test
    public void create() throws Exception {

        Invoice invoice = new Invoice.Builder("12000").AmountPayed("200").build();
        this.repository.save(invoice);
        this.id = invoice.getID();
        Assert.assertNotNull(invoice.getID());
    }

    @Test(dependsOnMethods = {"create"})
    public void read() throws Exception {

        Invoice invoice  = (Invoice)this.repository.findOne(this.id);
        Assert.assertNotNull(invoice);
        Assert.assertEquals("200", invoice.getAmountPayed());

    }

    @Test(dependsOnMethods = {"read"})
    public void update() throws Exception {

        Invoice invoice  = (Invoice)this.repository.findOne(this.id);
        Invoice invoice2 = new Invoice.Builder("12000").AmountPayed("400").build();

        this.repository.save(invoice2);
        Invoice invoice3  = (Invoice)this.repository.findOne(this.id);
        Assert.assertEquals("400", invoice2.getAmountPayed());
    }

    @Test(dependsOnMethods = {"update"})
    public void delete() throws Exception {
        Invoice invoice  = (Invoice)this.repository.findOne(this.id);
        this.repository.delete(invoice);
        Invoice deleteInvoice  = (Invoice)this.repository.findOne(this.id);
        Assert.assertNull(deleteInvoice);
    }


}
