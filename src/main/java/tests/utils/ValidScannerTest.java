package tests.utils;

import com.revature.mikeworks.utils.ValidScanner;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ValidScannerTest {
    private static ValidScanner scan;
    @BeforeAll
    static void beforeAll() {
        scan = new ValidScanner();
    }

    @Test
    void instantiateScanner() {
        assertTrue(scan != null);
    }

}