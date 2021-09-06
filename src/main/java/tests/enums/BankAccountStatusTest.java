package tests.enums;

import com.revature.mikeworks.enums.BankAccountStatus;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountStatusTest {
    private BankAccountStatus status;


    @BeforeAll
    static void beforeAll() {
    }

    @BeforeEach
    void setUp() {
        status = BankAccountStatus.APPLIED;
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void initializes() {
        assertNotNull(status);
    }

    @Test
    void canBeAssigned() {
        status = BankAccountStatus.APPROVED;

        assertEquals(BankAccountStatus.APPROVED, status);
    }

    @Test
    void convertsToInt() {
        int answer = status.toInt(BankAccountStatus.APPLIED);

        assertEquals(1, answer);
    }

    @Test
    void convertsFromInt() {
        int expected = 3;
        BankAccountStatus answer = status.fromInt(expected);

        assertEquals(BankAccountStatus.REJECTED, answer);
    }


}