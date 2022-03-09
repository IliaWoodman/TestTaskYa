import delivery.OrderInvalidException;
import org.junit.Test;

import static delivery.DeliveryService.deliveryCalculate;
import static delivery.Size.BIG;
import static delivery.Size.SMALL;
import static delivery.Workload.*;
import static delivery.Workload.NORMAL;
import static org.junit.Assert.assertEquals;

public class DeliveryTests {

    @Test(expected = OrderInvalidException.class)
    public void distanceAndFragilityExceptionTest() {
        deliveryCalculate(31, BIG, true, VERY_HIGH);
    }

    @Test
    public void maxPriceTest() {
        assertEquals(1120, deliveryCalculate(30, BIG, true, VERY_HIGH));
    }

    @Test
    public void avgTest() {
        assertEquals(700, deliveryCalculate(31, BIG, false, HIGH));
    }

    @Test
    public void minPriceTest() {
        assertEquals(400, deliveryCalculate(2, SMALL, false, NORMAL));
    }

    @Test(expected = OrderInvalidException.class)
    public void negativeDistanceExceptionTest() {
        deliveryCalculate(0, SMALL, false, NORMAL);
    }

    @Test
    public void maxDistanceAndFragilityTest() {
        assertEquals(840, deliveryCalculate(30, BIG, true, INCREASED));
    }

    @Test
    public void minAllowPriceTest() {
        assertEquals(500, deliveryCalculate(3, SMALL, true, NORMAL));
    }
}