package tests.enums;

import com.revature.mikeworks.enums.BankSecurity;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankSecurityTest {
    static BankSecurity secLevel;

    @BeforeAll
    static void beforeAll() {
    }

    @BeforeEach
    void setUp() {
        secLevel = BankSecurity.CUSTOMER;
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void exists() {
        assertNotNull(secLevel);
    }

    @Test
    void canBeAssigned() {
        secLevel = BankSecurity.ADMIN;

        assertEquals(BankSecurity.ADMIN, secLevel);
    }

    @Test
    void convertsToInt() {
        int answer = secLevel.toInt(BankSecurity.CUSTOMER);

        assertEquals(1, answer);
    }

    @Test
    void convertsFromInt() {
        int expected = 3;
        BankSecurity answer = secLevel.fromInt(expected);

        assertEquals(BankSecurity.ADMIN, answer);
    }

}