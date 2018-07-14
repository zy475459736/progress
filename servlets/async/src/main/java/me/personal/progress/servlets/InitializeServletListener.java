//package me.personal.progress.servlets;
//
///**
// * Created by zhongyi on 2018/7/14.
// */
//
//import com.netflix.appinfo.*;
//import com.netflix.config.ConfigurationManager;
//import com.netflix.config.DynamicBooleanProperty;
//import com.netflix.config.DynamicPropertyFactory;
//import com.netflix.config.DynamicStringProperty;
//import com.netflix.discovery.DefaultEurekaClientConfig;
//import com.netflix.discovery.DiscoveryManager;
//import com.netflix.servo.util.ThreadCpuStats;
//import org.apache.commons.configuration.AbstractConfiguration;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import javax.servlet.ServletContextEvent;
//import javax.servlet.ServletContextListener;
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.Map;
//
//@SuppressWarnings("ALL")
//public class InitializeServletListener implements ServletContextListener {
//
//    private Logger LOGGER              = LoggerFactory.getLogger(InitializeServletListener.class);
//    // Constructor中的loadConfiguration()获取
//    private String          appName             = null;
////    // Constructor中的configLog()        获取
////    private LogConfigurator logConfigurator;
////    // contextInitialized()
////    private InfoBoard       internalsServer;
//
//    public InitializeServletListener() {
//        String applicationID = ConfigurationManager.getConfigInstance().getString(Constants.DeploymentApplicationID);
//        if (applicationID == null || applicationID.isEmpty()) {
//            LOGGER.warn("Using default config!");
////            System.setProperty(Constants.DeployConfigUrl        , "http://10.114.27.54:8083/configs/apollo/10010004");
////            System.setProperty(Constants.DeploymentApplicationID, "h5gate");
//        }
//        loadConfiguration();//appName
//        configLog();		//LogConfigurator
//        registerEureka();
//    }
//
//    @Override
//    public void contextInitialized(ServletContextEvent arg0) {
//        try {
//            internalsServer = new InfoBoard(appName,
//                    ConfigurationManager.getConfigInstance().getInt("server.internals.port", 8077));
//            internalsServer.start();
//            initMonitor();
//            initGateWay();
//
//            ApplicationInfoManager.getInstance().setInstanceStatus(InstanceInfo.InstanceStatus.UP);
//        } catch (Exception e) {
//            LOGGER.error("Error while initializing pgateway.", e);
//        }
//    }
//
//    @Override
//    public void contextDestroyed(ServletContextEvent arg0) {
//        FilterFileManager.getInstance().shutdown();
//    }
//
//    private void initMonitor() {
//        MetricReporter.getInstance().start();
//
//        LOGGER.info("Registering Servo Monitor");
//        MonitorRegistry.getInstance().setPublisher(new ServoMonitor());
//
//        LOGGER.info("Starting Poller");
//        MetricPoller.startPoller();
//
//        LOGGER.info("Registering Servo Tracer");
//        TracerFactory.initialize(new Tracer());
//
//        LOGGER.info("Registering Servo Counter");
//        CounterFactory.initialize(new Counter());
//
//        LOGGER.info("Starting CPU stats");
//        final ThreadCpuStats stats = ThreadCpuStats.getInstance();
//        stats.start();
//
//    }
//
//    private void initGateWay() throws Exception {
//        LOGGER.info("Starting Groovy Filter file manager");
//        final AbstractConfiguration config           = ConfigurationManager.getConfigInstance();
//
//        final String                preFiltersPath 	 = config.getString(Constants.GateFilterPrePath);
//        final String                postFiltersPath  = config.getString(Constants.GateFilterPostPath);
//        final String                routeFiltersPath = config.getString(Constants.GateFilterRoutePath);
//        final String                errorFiltersPath = config.getString(Constants.GateFilterErrorPath);
//        final String                customPath       = config.getString(Constants.GateFilterCustomPath);
//        /**
//         * FilterLoader
//         * */
//        //先加载本地filter文件
//        FilterLoader.getInstance().setCompiler(new GroovyCompiler());
//        FilterFileManager.setFilenameFilter(new GroovyFileFilter());
//        if (customPath == null) {
//            FilterFileManager.init(5, preFiltersPath, postFiltersPath, routeFiltersPath, errorFiltersPath);
//        } else {
//            FilterFileManager.init(5, preFiltersPath, postFiltersPath, routeFiltersPath, errorFiltersPath, customPath);
//        }
//        //加载数据库poller，定期获取最新配置
//        startGateFilterPoller();
//        LOGGER.info("Groovy Filter file manager started");
//    }
//
//    private void startGateFilterPoller() {
//        GateFilterPoller.start();
//        LOGGER.info("GateFilterPoller Started.");
//    }
//
//    private void loadConfiguration() {
//        System.setProperty(DynamicPropertyFactory.ENABLE_JMX, "true");
//
//        appName = ConfigurationManager.getDeploymentContext().getApplicationId();
//
//        // Loading properties via archaius.
//        if (null != appName) {
//            try {
//                LOGGER.info(String.format("Loading application properties with app id: %s and environment: %s", appName,
//                        ConfigurationManager.getDeploymentContext().getDeploymentEnvironment()));
//                ConfigurationManager.loadCascadedPropertiesFromResources(appName);
//            } catch (IOException e) {
//                LOGGER.error(String.format(
//                        "Failed to load properties for application id: %s and environment: %s. This is ok, if you do not have application level properties.",
//                        appName, ConfigurationManager.getDeploymentContext().getDeploymentEnvironment()), e);
//            }
//        } else {
//            LOGGER.warn(
//                    "Application identifier not defined, skipping application level properties loading. You must set a property 'archaius.deployment.applicationId' to be able to load application level properties.");
//        }
//
//    }
//
//    private void configLog() {
//        logConfigurator = new LogConfigurator(appName
//                ,ConfigurationManager.getDeploymentContext().getDeploymentEnvironment());
//        logConfigurator.config();
//    }
//
//    private void registerEureka() {
//        DynamicBooleanProperty eurekaEnabled = DynamicPropertyFactory.getInstance().getBooleanProperty("eureka.enabled",
//                true);
//        if (!eurekaEnabled.get())
//            return;
//
//        EurekaInstanceConfig eurekaInstanceConfig = new PropertiesInstanceConfig() {};
//        ConfigurationManager.getConfigInstance().setProperty("eureka.statusPageUrl","http://"+ getTurbineInstance());
//
//        DiscoveryManager.getInstance().initComponent(eurekaInstanceConfig, new DefaultEurekaClientConfig());
//
//        final DynamicStringProperty serverStatus = DynamicPropertyFactory.getInstance()
//                .getStringProperty("server." + IPUtil.getLocalIP() + ".status", "up");
//        DiscoveryManager.getInstance().getDiscoveryClient().registerHealthCheckCallback(new HealthCheckCallback() {
//            @Override
//            public boolean isHealthy() {
//                return serverStatus.get().toLowerCase().equals("up");
//            }
//        });
//
//        String version = String.valueOf(System.currentTimeMillis());
//        String group = ConfigurationManager.getConfigInstance().getString("server.group", "default");
//        String dataCenter = ConfigurationManager.getConfigInstance().getString("server.data-center", "default");
//
//        Map<String, String> metadata = new HashMap<String, String>();
//        metadata.put("version", version);
//        metadata.put("group", group);
//        metadata.put("dataCenter", dataCenter);
//
//        String turbineInstance = getTurbineInstance();
//        if (turbineInstance != null) {
//            metadata.put("turbine.instance", turbineInstance);
//        }
//
//        ApplicationInfoManager.getInstance().registerAppMetadata(metadata);
//    }
//
//    public String getTurbineInstance() {
//        String instance = null;
//        String ip = IPUtil.getLocalIP();
//        if (ip != null) {
//            instance = ip + ":" + ConfigurationManager.getConfigInstance().getString("server.internals.port", "8077");
//        } else {
//            LOGGER.warn("Can't build turbine instance as can't fetch the ip.");
//        }
//        return instance;
//    }
//}
