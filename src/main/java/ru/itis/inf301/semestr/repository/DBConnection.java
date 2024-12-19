package ru.itis.inf301.semestr.repository;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.flywaydb.core.Flyway;

import java.sql.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DBConnection {

    private static DBConnection instance;
    private static HikariDataSource dataSource;
    final static Logger logger = LogManager.getLogger(DBConnection.class);


    private DBConnection() {
        initDB();
    }

    public static DBConnection getInstance() {
        if (instance == null) {
            synchronized (DBConnection.class) {
                if (instance == null) {
                    instance = new DBConnection();
                }
            }
        }
        return instance;
    }

    private void initDB() {
        try {
            Class.forName("org.postgresql.Driver");

            HikariConfig config = new HikariConfig();
            config.setJdbcUrl("jdbc:postgresql://localhost:5432/pizza");
            config.setUsername("postgres");
            config.setPassword("passwd");
            config.setConnectionTimeout(50000);
            config.setMaximumPoolSize(10);
            dataSource = new HikariDataSource(config);

            Flyway flyway = Flyway.configure().dataSource(dataSource).load();
            logger.info("start migration");
            flyway.migrate();
            logger.info("migration done");
        } catch (ClassNotFoundException e) {
            logger.error("", e);
            e.printStackTrace();
        }
    }

    public synchronized Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public synchronized void releaseConnection(Connection connection) throws SQLException {
        connection.close();
    }

    public void destroy() {
        dataSource.close();
    }
}