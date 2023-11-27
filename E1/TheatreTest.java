import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TheatreTest {

    @Test
    @DisplayName("Test capacity")
    void capacity() {
        assertAll(() -> assertEquals(660, Theatre.capacity(20, 33)),
                () -> assertEquals(375, Theatre.capacity(25, 15)),
                () -> assertEquals(1056, Theatre.capacity(48, 22)),
                () -> assertEquals(720, Theatre.capacity(18, 40)));
    }

    @Test
    @DisplayName("Test expenses")
    void expenses() {
        assertAll(() -> assertEquals(400, Theatre.expenses(3.2, 125)),
                () -> assertEquals(268.18, Theatre.expenses(5.06, 53)),
                () -> assertEquals(1250.0, Theatre.expenses(1.25, 1000)),
                () -> assertEquals(143.0, Theatre.expenses(2.75, 52)));
    }

    @Test
    @DisplayName("Test income")
    void income() {
        assertAll(() -> assertEquals(1214.4, Theatre.income(48, 25.3)),
                () -> assertEquals(14875.0, Theatre.income(425, 35.00)),
                () -> assertEquals(58856.42, Theatre.income(749, 78.58)),
                () -> assertEquals(8705.98, Theatre.income(146, 59.63)));
    }

    @Test
    @DisplayName("Test profit")
    void profit() {
        assertAll(() -> assertEquals(664.5, Theatre.profit(25, 28.58)),
                () -> assertEquals(3334.4, Theatre.profit(128, 28.05)),
                () -> assertEquals(56767.67999999999, Theatre.profit(857, 68.24)),
                () -> assertEquals(14961.42, Theatre.profit(258, 59.99)));
    }

    @Test
    @DisplayName("Test maxProfit")
    void maxProfit() {
        assertAll(() -> assertEquals(63091.2, Theatre.maxProfit( 100.58)),
                () -> assertEquals(30880.0, Theatre.maxProfit( 50.25)),
                () -> assertEquals(40640.0, Theatre.maxProfit(65.5)),
                () -> assertEquals(0.0, Theatre.maxProfit(2)));
    }

    @Test
    @DisplayName("Test lost profit")
    void lostProfit() {
        assertAll(() -> assertEquals(7241.42, Theatre.lostProfit(8500, 1258.58)),
                () -> assertEquals(0.0, Theatre.lostProfit(8654, 8654)),
                () -> assertEquals(76.5, Theatre.lostProfit(5200.5, 5124)),
                () -> assertEquals(2270.41, Theatre.lostProfit(2857.41, 587)));
    }

}