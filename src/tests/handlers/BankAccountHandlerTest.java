package tests.handlers;

import com.revature.mikeworks.components.BankAccount;
import com.revature.mikeworks.handlers.BankAccountHandler;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountHandlerTest {
    private BankAccountHandler handler;

    @BeforeEach
    void setUp() {
        handler = new BankAccountHandler();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void exists() {
        assertNotNull(handler);
    }

    @Test
    void containsListOfAccounts() {
        assertNotNull(handler.getAccountList());
    }

    @Test
    void canAddAccount() {
        BankAccount neoAcct = new BankAccount();
        assertFalse(handler.contains(neoAcct));
        handler.add(neoAcct);
        assertTrue(handler.contains(neoAcct));
    }

    @Test
    void cannotAddSameAccountTwice() {
        BankAccount neoAcct = new BankAccount();
        handler.add(neoAcct);
        int expect = handler.size();
        handler.add(neoAcct);

        assertEquals(expect, handler.size());
    }

    @Test
    void canAddAccountsWithDifferentNumbers() {
        BankAccount neoAcct = new BankAccount();
        handler.add(neoAcct);
        int expect = handler.size() + 1;
        neoAcct.setAccountNumber(neoAcct.getAccountNumber()+1);
        handler.add(neoAcct);

        assertEquals(expect, handler.size());
    }
}