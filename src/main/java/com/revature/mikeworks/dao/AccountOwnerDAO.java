package com.revature.mikeworks.dao;

import com.revature.mikeworks.components.AccountOwner;
import com.revature.mikeworks.components.BankData;
import com.revature.mikeworks.dao.interfaces.iAccountOwnerDAO;
import com.revature.mikeworks.handlers.CustomerHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class AccountOwnerDAO implements iAccountOwnerDAO {
    private static long nextNumber;
    private static final Connection conn = JDBCConnector.getConn();
    private static final CustomerHandler cHandler = BankData.getCHandler();
    private static final Logger log = LogManager.getLogger(AccountOwnerDAO.class);

    @Override
    public void deleteAccountOwner(AccountOwner toDelete) {
        try {
            PreparedStatement st = conn.prepareStatement("DELETE FROM ACCOUNTOWNERS WHERE BANKID = ?");
            st.setLong(1, toDelete.getBankID());

            st.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static long getNextNumber() {
        AccountOwnerDAO.nextNumber += 1;
        return nextNumber;
    }

    @Override
    public HashMap<String, AccountOwner> readAccountOwners() {
        HashMap<String, AccountOwner> returnThis = new HashMap<>();

        try {
            PreparedStatement st = conn.prepareStatement("SELECT * FROM ACCOUNT_OWNERS");
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                long bankID = rs.getLong("bankid");
                long ownerID = rs.getLong("ownerid");
                long accountID = rs.getLong("accountid");

                AccountOwner neoAcct = new AccountOwner(
                        bankID, ownerID, accountID
                );
                returnThis.put(cHandler.getCustomerByID(ownerID).getUsername(), neoAcct);
                if (neoAcct.getBankID() > AccountOwnerDAO.nextNumber)
                    AccountOwnerDAO.nextNumber = neoAcct.getBankID();
            }
            rs.close();
        } catch (SQLException e) {
            log.warn("Trial connection to database failed.", e);
        }

        return returnThis;
    }

    @Override
    public void updateAccountOwner(AccountOwner updateMe) {
        try {
            PreparedStatement st = conn.prepareStatement("UPDATE ACCOUNT_OWNERS SET " +
                    "PERSONID = ?, ACCOUNTID = ?,  WHERE BANKID = ?");
            st.setLong(1, updateMe.getOwnerID() );
            st.setLong(2, updateMe.getAccountID() );
            st.setLong(3, updateMe.getBankID() );

            st.executeUpdate();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }

    }

    @Override
    public void writeAccountOwner(AccountOwner input) {
        try {
            PreparedStatement st = conn.prepareStatement("INSERT INTO ACCOUNT_OWNERS VALUES (?, ?, ?)");
            st.setLong(1, input.getOwnerID());
            st.setLong(2, input.getAccountID());
            st.setLong(3, input.getBankID());

            st.execute();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    public void writeAccountOwners(HashMap<Long, AccountOwner> input) {
        for (AccountOwner item : input.values()) {
            writeAccountOwner(item);
        }
    }
}
