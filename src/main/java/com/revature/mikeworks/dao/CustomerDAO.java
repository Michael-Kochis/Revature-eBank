package com.revature.mikeworks.dao;

import com.revature.mikeworks.components.BankData;
import com.revature.mikeworks.components.Customer;
import com.revature.mikeworks.dao.interfaces.iCustomerDAO;
import com.revature.mikeworks.enums.BankSecurity;
import com.revature.mikeworks.handlers.CustomerHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class CustomerDAO implements iCustomerDAO {
    private static Connection conn = JDBCConnector.getConn();
    private static final Logger log = LogManager.getLogger(CustomerDAO.class);

    public void deleteCustomer(Customer toDelete) {
        try {
            PreparedStatement st = conn.prepareStatement("DELETE FROM CUSTOMERS WHERE PERSONID = ?");
            st.setInt(1, toDelete.getPersonID());

            st.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public HashMap<String, Customer> readCustomers() {
        HashMap<String, Customer> returnThis = new HashMap<String, Customer>();

        try {
            PreparedStatement st = conn.prepareStatement("SELECT * FROM CUSTOMERS");
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                int neoID = rs.getInt("personid");
                String neoName = rs.getString("username");
                String neoPass = rs.getString("password");
                String neoFirst = rs.getString("firstname");
                String neoLast = rs.getString("lastname");
                String neoEmail = rs.getString("email");
                int neoAccess = rs.getInt("access_level");
                Customer neoCust = new Customer(
                        neoID, neoName,
                        neoFirst, neoLast,
                        neoEmail,
                        BankSecurity.fromInt(neoAccess)
                );
                neoCust.setHash(neoPass);
                returnThis.put(neoCust.getUsername(), neoCust);
            }
            rs.close();
        } catch (SQLException e) {
            log.warn("Trial connection to database failed.", e);
        }
        return returnThis;
    }

    public void updateCustomer(String username) {
        CustomerHandler cHandler = BankData.getCHandler();
        Customer saveMe = cHandler.getCustomerByUsername(username);

        try {
                PreparedStatement st = conn.prepareStatement("UPDATE CUSTOMERS SET " +
                        "USERNAME = ?, PASSWORD = ?, FIRSTNAME = ?, LASTNAME = ?, EMAIL = ?, " +
                        "ACCESS_LEVEL = ? WHERE PERSONID = ?");
                st.setString(1, saveMe.getUsername());
                st.setString(2, saveMe.getPassword().getHash());
                st.setString(3, saveMe.getFirstName());
                st.setString(4, saveMe.getLastName());
                st.setString(5, saveMe.getEmail());
                st.setInt(6, saveMe.getSecurity().toInt());
                st.setInt(7, saveMe.getPersonID());

            int i = st.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void writeCustomer(Customer input) {
        try {
                PreparedStatement st = conn.prepareStatement("INSERT INTO CUSTOMERS VALUES (?, ?, ?, ?, ?, ?, ?)");
                st.setInt(1, input.getPersonID());
                st.setString(2, input.getUsername());
                st.setString(3, input.getPassword().getHash());
                st.setString(4, input.getFirstName());
                st.setString(5, input.getLastName());
                st.setString(6, input.getEmail());
                st.setInt(7, input.getSecurity().toInt());

                boolean i = st.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
