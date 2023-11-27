import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BillingManagerTest {
    @Test
    @DisplayName("Test default constructor and getter")
    public void defaultConstructorTest(){
        BillingManager aBillingManager = new BillingManager();
        assertEquals(0.2, aBillingManager.getVAT());
    }

    @Test
    @DisplayName("Test overloaded constructor and getter")
    public void overloadedConstructorTest(){
        BillingManager aBillingManager = new BillingManager(0.54);
        assertEquals(0.54, aBillingManager.getVAT());
    }

    @Test
    @DisplayName("Test computeBill1 for default constructor")
    void testComputeBill1() {
        BillingManager aBillingManager = new BillingManager();
        assertEquals(31.776, aBillingManager.computeBill(26.48));
    }

    @Test
    @DisplayName("Test computeBill2 for overloaded constructor")
    void testComputeBill2() {
        BillingManager aBillingManager = new BillingManager(0.26);
        assertEquals(497.7504, aBillingManager.computeBill(49.38, 8));
    }

    @Test
    @DisplayName("Test computeBill3 for default constructor")
    void testComputeBill3() {
        BillingManager aBillingManager = new BillingManager();
        assertEquals(126.852, aBillingManager.computeBill(38.99,4,50.25));
    }
}