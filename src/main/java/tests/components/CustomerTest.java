package tests.components;

import com.revature.mikeworks.components.Customer;
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
    void customerIsNotEmployee() {
        assertFalse(person.isEmployee());
    }

    @Test
    void customerIsNotAdmin() {
        assertFalse(person.isAdmin());
    }

    @Test
    void employeeIsEmployee() {
        person.setSecurity(BankSecurity.EMPLOYEE);

        assertTrue(person.isEmployee());
    }

    @Test
    void employeeIsNotAdmin() {
        person.setSecurity(BankSecurity.EMPLOYEE);

        assertFalse(person.isAdmin());
    }

    @Test
    void adminIsEmployee() {
        person.setSecurity(BankSecurity.ADMIN);

        assertTrue(person.isEmployee());
    }

    @Test
    void adminIsAdmin() {
        person.setSecurity(BankSecurity.ADMIN);

        assertTrue(person.isAdmin());
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

    @Test
    void userHasFirstName() {
        assertNull(person.getFirstName());
    }

    @Test
    void firstNameCanBeSet() {
        String neoName = "Mayor";

        person.setFirstName(neoName);
        assertEquals(neoName, person.getFirstName());
    }

    @Test
    void userHasLastName() {
        assertNull(person.getLastName());
    }

    @Test
    void lastNameCanBeSet() {
        String neoName = "Miller";

        person.setLastName(neoName);
        assertEquals(neoName, person.getLastName());
    }

    @Test
    void hasEmail() {
        assertNull(person.getEmail());
    }

    @Test
    void emailCanBeSet() {
        String neoEmail = "nemo@nobody.com";

        person.setEmail(neoEmail);
        assertEquals(neoEmail, person.getEmail());
    }
}