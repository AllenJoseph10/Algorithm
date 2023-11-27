import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BankAccountTest {

    @Test
    @DisplayName("Test getters")
    public void constructorTest(){
        BankAccount anAccount = new BankAccount("Kate Johnson",243456, 2325.67);

        assertAll(() -> assertEquals("Kate Johnson", anAccount.getName()),
                  () -> assertEquals(243456, anAccount.getID()),
                  () -> assertEquals(2325.67, anAccount.getBalance()),
                  () -> assertEquals(false, anAccount.getClosed()));
    }

    @Test
    @DisplayName("Test deposit")
    public void testDeposit() {
        BankAccount anAccount = new BankAccount("David Atkinson", 35643,1578.57);
        anAccount.deposit(248.64);
        assertEquals(1827.21, anAccount.getBalance());
    }

    @Test
    @DisplayName("Test withdraw")
    public void testWithdraw() {
        BankAccount anAccount = new BankAccount("John York", 658468, 1250.00);
        anAccount.withdraw(248.47);
        assertEquals(1001.53, anAccount.getBalance());
    }

    @Test
    @DisplayName("Test close account")
    public void  testCloseAccount() {
        BankAccount anAccount = new BankAccount("Peter Smith", 165845, 1111.02);
        anAccount.closeAccount();
        assertAll(() -> assertEquals(true, anAccount.getClosed()),
                  () -> assertEquals(0, anAccount.getBalance()));
    }

    @Test
    @DisplayName("Test transferTo")
    public void testTransferTo() {
        BankAccount fromAccount = new BankAccount("Harry Weasley", 358715, 53553.10);
        BankAccount toAccount = new BankAccount("Ron Potter", 963187, 1133.05);
        fromAccount.transferTo(toAccount, 1560d);
        assertAll(() -> assertEquals(51993.1, fromAccount.getBalance()),
                  () -> assertEquals(2693.05, toAccount.getBalance()));
    }
}