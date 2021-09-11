package com.revature.mikeworks.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class JDBCConnector {
    private static final Logger log = LogManager.getLogger(JDBCConnector.class);
    private static Connection conn;
    private static String url, root, passwd;

    public JDBCConnector() {
        super();
        init();
    }

    public static Connection getConn() {
        if (conn == null) {
            setConn();
        }
        return conn;
    }

    private static void setConn() {
        JDBCConnector.init();

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(url, root, passwd);
            log.trace("New connection to database established.");
        } catch (Exception e) {
            log.fatal("Error accessing database\n", e);
        }
    }

    public static void testDatabase() {
        try {
            JDBCConnector.init();
            Connection testConn = getConn();
            PreparedStatement st = testConn.prepareStatement("SELECT * FROM YIPYIP");
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                log.trace("Database connection established and tested");
                System.out.println(rs.getString("message"));
            }
            rs.close();
        } catch (SQLException e) {
            log.warn("Trial connection to database failed.", e);
        }
    }

    private static void init() {
        url = System.getenv("JavaBank_URL");
        root = System.getenv("JavaBank_Login");
        passwd = System.getenv("JavaBank_Password");
    }
}
