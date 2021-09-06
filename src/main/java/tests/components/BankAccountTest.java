package tests.components;

import com.revature.mikeworks.components.BankAccount;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {
    static BankAccount account;

    @BeforeAll
    static void beforeAll() {
    }

    @BeforeEach
    void setUp() {
        account = new BankAccount();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void instantiateAccount() {
        assertNotNull(account);
    }

    @Test
    void canGetType() {
        String result = account.getType();
        assertEquals("checking", result);
    }

    @Test
    void canSetTypeToSavings() {
        String neoType = "savings";
        account.setType(neoType);
        assertEquals(neoType, account.getType() );
    }

    @Test
    void hasABalance() {
        assertEquals(0, account.getBalance());
    }

    @Test
    void balanceCanBeSet() {
        double neoBal = 1000.0;
        account.setBalance(neoBal);
        assertEquals(neoBal, account.getBalance());
    }

    @Test
    void hasAccountNumber() {
        assertEquals(0, account.getAccountNumber());
    }
}