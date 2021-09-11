package com.revature.mikeworks.dao;

import com.revature.mikeworks.components.AccountOwner;
import com.revature.mikeworks.components.BankAccount;
import com.revature.mikeworks.components.BankData;
import com.revature.mikeworks.dao.interfaces.iBankAccountDAO;
import com.revature.mikeworks.enums.BankAccountStatus;
import com.revature.mikeworks.enums.BankAccountType;
import com.revature.mikeworks.handlers.BankAccountHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class BankAccountDAO implements iBankAccountDAO {
    private static final Connection conn = JDBCConnector.getConn();
    private static final Logger log = LogManager.getLogger(BankAccountDAO.class);
    private static final BankAccountHandler baHandler = BankData.getBaHandler();

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

    public HashMap<String, AccountOwner> readAccountOwners() {
        AccountOwnerDAO aoDAO = new AccountOwnerDAO();
        return aoDAO.readAccountOwners();
    }

    private void assignAccountOwners() {
        HashMap<String, AccountOwner> tempAO = readAccountOwners();

        for (Map.Entry<String, AccountOwner> ao: tempAO.entrySet()) {
            BankAccount target = baHandler.findAccountByID(ao.getValue().getAccountID());
            target.addOwner(ao.getKey(), ao.getValue());
        }
    }

    public HashMap<Long, BankAccount> readAccounts() {
        HashMap<Long, BankAccount> returnThis = new HashMap<>();

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
                        neoBal
                );
                assignAccountOwners();

                returnThis.put(neoAcct.getAccountNumber(), neoAcct);
            }
            rs.close();
        } catch (SQLException e) {
            log.warn("Trial connection to database failed.", e);
        }

        return returnThis;
    }

    public void updateAccount(BankAccount updateMe) {
        try {
            PreparedStatement st = conn.prepareStatement("UPDATE ACCOUNTS SET " +
                    "TYPE = ?, STATUS = ?, BALANCE = ? WHERE ACCOUNTID = ?");
            st.setInt(1, BankAccountType.toInt(updateMe.getType()) );
            st.setInt(2, BankAccountStatus.toInt(updateMe.getStatus()) );
            st.setDouble(3, updateMe.getBalance() );
            st.setLong(4, updateMe.getAccountNumber());

            st.executeUpdate();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    @Override
    public void updateAccount(Long accountID) {
        this.updateAccount(baHandler.getAccountByNumber(accountID) );
    }

    @Override
    public void writeAccount(BankAccount input) {
        try {
            PreparedStatement st = conn.prepareStatement("INSERT INTO ACCOUNTS VALUES (?, ?, ?, ?)");
            st.setLong(1, input.getAccountNumber());
            st.setInt(2, BankAccountType.toInt(input.getType()) );
            st.setInt(3, BankAccountStatus.toInt(input.getStatus()) );
            st.setDouble(4, input.getBalance());

            st.execute();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    public void writeAccounts(HashMap<Long, BankAccount> input) {
        for (BankAccount item: input.values()) {
            writeAccount(item);
        }
    }
}
