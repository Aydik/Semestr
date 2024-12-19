package ru.itis.inf301.semestr.listener;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import ru.itis.inf301.semestr.repository.DBConnection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@WebListener
public class AppContextListener implements ServletContextListener {
    final static Logger logger = LogManager.getLogger(AppContextListener.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        logger.info("contextInitialized");
        DBConnection.getInstance();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        DBConnection.getInstance().destroy();
    }
}
