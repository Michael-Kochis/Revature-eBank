package com.revature.mikeworks.dao;

import com.revature.mikeworks.dao.interfaces.iLogDAO;
import com.revature.mikeworks.enums.BankAccountStatus;
import com.revature.mikeworks.enums.BankAccountType;

import java.sql.*;

public class LogDAO implements iLogDAO {
    private static final Connection conn = JDBCConnector.getConn();
    private static Long maxNumber = 0L;

    @Override
    public void createLogEntry(Long nWho, Integer nWhat, Long nWhere, Long nOther, Double nAmount, String nNotes) {
        try {
            PreparedStatement st = conn.prepareStatement("INSERT INTO LOGS VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
            st.setLong(1, getNextMaxNumber());
            st.setLong(2, nWho);
            st.setInt(3, nWhat );
            st.setTimestamp(4, new Timestamp(System.currentTimeMillis()) );
            st.setLong(5, nWhere );
            st.setLong(6, nOther);
            st.setDouble(7, nAmount);
            st.setString(8, nNotes);

            st.execute();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    private long getNextMaxNumber() {
        if (maxNumber == 0L) {
            try {
                PreparedStatement st = conn.prepareStatement("SELECT MAX(LOGID) AS MAX FROM LOGS");

                ResultSet rs =st.executeQuery();
                if (rs.next()) {
                    System.out.println(rs.getLong("MAX"));
                    maxNumber = rs.getLong("MAX");
                }
            } catch (SQLException throwable) {
                throwable.printStackTrace();
            }

        }
        maxNumber += 1;

        return maxNumber;
    }

    @Override
    public void createLogEntry(Long nWho, Integer nWhat, Long nWhere, Long nOther, Double nAmount) {
        createLogEntry(nWho, nWhat, nWhere, nOther, nAmount, "");
    }

    @Override
    public void createLogEntry(Long nWho, Integer nWhat, Long nWhere, Double nAmount) {
        createLogEntry(nWho, nWhat, nWhere, 0L, nAmount, "");
    }
}
