package tests.handlers;

import com.revature.mikeworks.components.Customer;
import com.revature.mikeworks.handlers.CustomerHandler;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerHandlerTest {
    private CustomerHandler handler;

    @BeforeEach
    void setUp() {
        handler = new CustomerHandler();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void exists() {
        assertNotNull(handler);
    }

    @Test
    void containsListOfCustomers() {
        assertNotNull(handler.getCustomerList());
    }

    @Test
    void canAddCustomer() {
        Customer neoCust = new Customer();
        assertFalse(handler.contains(neoCust));
        handler.add(neoCust);
        assertTrue(handler.contains(neoCust));
    }

    @Test
    void cannotAddSameCustomerTwice() {
        Customer neoCust = new Customer();
        handler.add(neoCust);
        int expect = handler.size();
        handler.add(neoCust);

        assertEquals(expect, handler.size());
    }

    @Test
    void canAddUsersWithDifferentNames() {
        Customer neoCust = new Customer();
        handler.add(neoCust);
        int expect = handler.size() + 1;
        neoCust.setUsername("Neo");
        handler.add(neoCust);

        assertEquals(expect, handler.size());
    }
}