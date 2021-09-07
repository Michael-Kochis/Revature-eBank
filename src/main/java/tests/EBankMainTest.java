package tests;

import com.revature.mikeworks.EBankMain;
import org.junit.jupiter.api.BeforeAll;

import static org.junit.jupiter.api.Assertions.*;

class EBankMainTest {

    @BeforeAll
    static void beforeAll() {

    }

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void mainExists() {
        EBankMain bank = new EBankMain();
        assertTrue(bank != null);
    }
}