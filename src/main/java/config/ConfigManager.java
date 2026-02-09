package config;

import java.io.InputStream;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConfigManager {
    private static final Properties properties = new Properties();
    private static final Logger logger = LoggerFactory.getLogger(ConfigManager.class);

    static {
        try {
            InputStream input = ConfigManager.class.getClassLoader().getResourceAsStream("config.properties");
            if (input == null) {
                // Fallback to file path if not found in classpath
                input = new java.io.FileInputStream("src/test/resources/config.properties");
            }
            logger.info("Loading config.properties...");
            if (input == null) {
                throw new RuntimeException("config.properties not found in classpath or file path");
            }
            properties.load(input);
            String defaultEnv = properties.getProperty("default.env");
            if (defaultEnv == null || defaultEnv.isEmpty()) {
                throw new RuntimeException("Missing 'default.env' in config.properties");
            }
            logger.info("Loaded environment: {}", defaultEnv);
            logger.info("All properties: {}", properties);
        } catch (Exception e) {
            throw new RuntimeException("Configuration Error", e);
        }
    }

    /**
     * Returns the base UI URL for the current environment (e.g., events-master.dudesoln.com)
     */
    public static String getBaseUrl() {
        String env = System.getProperty("env", properties.getProperty("default.env"));
        String urlKey = env + ".base.url";
        String url = properties.getProperty(urlKey);
        if (url == null) {
            throw new RuntimeException("Missing URL for environment: " + env);
        }
        return url;
    }

    /**
     * Returns the base API URL for the current environment (e.g., v2-events-master.dudesoln.com)
     */
    public static String getBaseApiUrl() {
        String env = System.getProperty("env", properties.getProperty("default.env"));
        String apiKey = env + ".base.api";
        String apiUrl = properties.getProperty(apiKey);
        if (apiUrl == null) {
            throw new RuntimeException("Missing API URL for environment: " + env);
        }
        return apiUrl;
    }

    /**
     * Returns the bearer token if present in config (placeholder for future logic)
     */
    public static String getBearerToken() {
        return properties.getProperty("bearer.token", "");
    }

    /**
     * Returns the email for the current environment
     */
    public static String getEmail() {
        String env = System.getProperty("env", properties.getProperty("default.env"));
        String emailKey = env + ".email";
        String email = properties.getProperty(emailKey);
        if (email == null) {
            throw new RuntimeException("Missing email for environment: " + env);
        }
        return email;
    }

    /**
     * Returns the password for the current environment
     */
    public static String getPassword() {
        String env = System.getProperty("env", properties.getProperty("default.env"));
        String passwordKey = env + ".password";
        String password = properties.getProperty(passwordKey);
        if (password == null) {
            throw new RuntimeException("Missing password for environment: " + env);
        }
        return password;
    }

    /**
     * Returns the portal for the current environment
     */
    public static String getPortal() {
        String env = System.getProperty("env", properties.getProperty("default.env"));
        String portalKey = env + ".portal";
        String portal = properties.getProperty(portalKey);
        if (portal == null) {
            throw new RuntimeException("Missing portal for environment: " + env);
        }
        return portal;
    }

    /**
     * Returns the route for the current environment
     */
    public static String getRoute() {
        String env = System.getProperty("env", properties.getProperty("default.env"));
        String routeKey = env + ".route";
        String route = properties.getProperty(routeKey);
        if (route == null) {
            throw new RuntimeException("Missing route for environment: " + env);
        }
        return route;
    }

    /**
     * Returns any property by key
     */
    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}


