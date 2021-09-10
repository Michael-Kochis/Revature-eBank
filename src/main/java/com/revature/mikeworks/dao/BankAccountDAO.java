package com.revature.mikeworks.dao;

import com.revature.mikeworks.components.BankAccount;
import com.revature.mikeworks.components.Customer;
import com.revature.mikeworks.dao.interfaces.iBankAccountDAO;
import com.revature.mikeworks.enums.BankAccountStatus;
import com.revature.mikeworks.enums.BankAccountType;
import com.revature.mikeworks.enums.BankSecurity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class BankAccountDAO implements iBankAccountDAO {
    public final String filePath = "./files/accounts.txt";
    private static final Connection conn = JDBCConnector.getConn();
    private static final Logger log = LogManager.getLogger(BankAccountDAO.class);

    @Override
    public void deleteAccount(BankAccount toDelete) {
        try {
            PreparedStatement st = conn.prepareStatement("DELETE FROM ACCOUNTS WHERE ACCOUNTID = ?");
            st.setLong(1, toDelete.getAccountNumber());

            st.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public HashMap<Long, BankAccount> readAccounts() {
        HashMap<Long, BankAccount> returnThis = new HashMap<Long, BankAccount>();

        try {
            PreparedStatement st = conn.prepareStatement("SELECT * FROM CUSTOMERS");
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                int neoID = rs.getInt("accountid");
                int neoType = rs.getInt("type");
                int neoStatus = rs.getInt("status");
                float neoBal = rs.getFloat("balance");
                BankAccount neoAcct = new BankAccount(
                        neoID,
                        BankAccountType.fromInt(neoType),
                        BankAccountStatus.fromInt(neoStatus),
                        (double)neoBal
                );
                returnThis.put(neoAcct.getAccountNumber(), neoAcct);
            }
            rs.close();
        } catch (SQLException e) {
            log.warn("Trial connection to database failed.", e);
        }

        return returnThis;
    }

    @Override
    public void updateAccount(Long accountNumber) {

    }

    @Override
    public void writeAccount(BankAccount input) {

    }

    public void writeAccounts(HashMap<Long, BankAccount> input) {
        for (BankAccount item: input.values()) {
            writeAccount(item);
        }
    }
}
