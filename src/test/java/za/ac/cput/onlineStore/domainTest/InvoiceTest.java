package za.ac.cput.onlineStore.domainTest;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.onlineStore.config.InvoiceFactory;
import za.ac.cput.onlineStore.domain.Invoice;

/**
 * Created by student on 2015/10/15.
 */
public class InvoiceTest {

    @Before
    public void setUp() throws Exception {


    }

    @Test
    public void createinvoice() throws Exception {

        Invoice invoice = InvoiceFactory.createInvoicer("1000", "1500");

        Assert.assertEquals("1000", invoice.getAmountPayed());
    }

    @Test
    public void updateinvoice() throws Exception {

        Invoice invoice = InvoiceFactory.createInvoicer("15000000", "1500");

        Assert.assertEquals("15000000", invoice.getAmountPayed());
    }

    @After
    public void tearDown() throws Exception {


    }
}
