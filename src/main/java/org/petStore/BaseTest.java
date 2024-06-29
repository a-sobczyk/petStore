package org.petStore;

import org.junit.jupiter.api.BeforeAll;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {

    public static Properties PROPERTIES;
    public static Properties ENDPOINTS;

    @BeforeAll
    public static void testDataSetup() {
        try {
            File config = new File("configuration.properties");
            FileInputStream configStream = new FileInputStream(config);
            PROPERTIES = new Properties();
            PROPERTIES.load(configStream);
            File endpoints = new File("endpoints.properties");
            FileInputStream endpointsStream = new FileInputStream(endpoints);
            ENDPOINTS = new Properties();
            ENDPOINTS.load(endpointsStream);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
