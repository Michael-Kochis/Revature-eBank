package tests.components;

import com.revature.mikeworks.components.Admin;
import com.revature.mikeworks.components.Customer;
import com.revature.mikeworks.components.Employee;
import com.revature.mikeworks.enums.BankSecurity;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {
    private Customer person;

    @BeforeEach
    void setUp() {
        person = new Customer();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void instantiatePerson() {
        assertNotNull(person);
    }

    @Test
    void instantiateEmployee() {
        Employee worker = new Employee();

        assertNotNull(worker);
    }

    @Test
    void customerIsNotEmployee() {
        assertFalse(person.isEmployee());
    }

    @Test
    void customerIsNotAdmin() {
        assertFalse(person.isAdmin());
    }

    @Test
    void employeeIsEmployee() {
        Employee worker = new Employee();

        assertTrue(worker.isEmployee());
    }

    @Test
    void employeeIsNotAdmin() {
        Employee worker = new Employee();

        assertFalse(worker.isAdmin());
    }

    @Test
    void instantiateAdmin() {
        Admin boss = new Admin();

        assertNotNull(boss);
    }

    @Test
    void adminIsEmployee() {
        Admin boss = new Admin();

        assertTrue(boss.isEmployee());
    }

    @Test
    void adminIsAdmin() {
        Admin boss = new Admin();

        assertTrue(boss.isAdmin());
    }

    @Test
    void userHasUsername() {
        assertNull(person.getUsername());
    }

    @Test
    void usernameCanBeSet() {
        String neoName = "Mayud";

        person.setUsername(neoName);
        assertEquals(neoName, person.getUsername());
    }

    @Test
    void userHasPassword() {
        assertNull(person.getPassword());
    }

    @Test
    void passwordCanBeSet() {
        String neoPass = "BadPasswordChoice";

        person.setPassword(neoPass);
        assertEquals(neoPass, person.getPassword());
    }

    @Test
    void userHasSecurity() {
        assertEquals(BankSecurity.CUSTOMER, person.getSecurity());
    }

    @Test
    void securityCanBeSet() {
        assertFalse(person.isAdmin());
        person.setSecurity(BankSecurity.ADMIN);
        assertTrue(person.isAdmin());
    }
}