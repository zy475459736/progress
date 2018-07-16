package me.personal.progress.servlets;

/**
 * Created by zhongyi on 2018/7/14.
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

@SuppressWarnings("ALL")
public class InitializeServletListener implements ServletContextListener {

    private Logger LOGGER              = LoggerFactory.getLogger(InitializeServletListener.class);

    public InitializeServletListener() {
//        String applicationID = ConfigurationManager.getConfigInstance().getString(Constants.DeploymentApplicationID);
//        if (applicationID == null || applicationID.isEmpty()) {
//            LOGGER.warn("Using default config!");
////            System.setProperty(Constants.DeployConfigUrl        , "http://10.114.27.54:8083/configs/apollo/10010004");
////            System.setProperty(Constants.DeploymentApplicationID, "h5gate");
//        }
//        loadConfiguration();//appName
//        configLog();		//LogConfigurator
//        registerEureka();
    }

    @Override
    public void contextInitialized(ServletContextEvent arg0) {
        System.out.println("InitializeServletListener.contextInitialized()");
    }

    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
        System.out.println("InitializeServletListener.contextDestroyed()");
    }
}
