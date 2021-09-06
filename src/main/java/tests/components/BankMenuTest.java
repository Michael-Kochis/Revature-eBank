package tests.components;

import com.revature.mikeworks.components.BankMenu;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankMenuTest {
    BankMenu menu;

    @BeforeEach
    void setUp() {
        menu = new BankMenu();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void instantiates() {
        assertNotNull(menu);
    }

    @Test
    void hasAValidToStringMethod() {
        assertNotNull(menu.toString());
    }

    @Test
    void menuHasSize() {
        assertTrue(menu.getSize() > 0);
    }

    @Test
    void hasShowMenu() {
        menu.showMenu();
        assertTrue(true);
    }

    @Test
    void hasAddMenuItem() {
        menu.addMenuItem(1, "qwerty");
        assertTrue(true);
    }
}