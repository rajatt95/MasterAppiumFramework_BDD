package com.appium.manager;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.appium.utils.TestUtils;

public class PropertyManager {
    private static Properties props = new Properties();
    TestUtils utils = new TestUtils();

    public Properties getProps() throws IOException {
        InputStream is = null;
        String propsFileName = "config.properties";

        if(props.isEmpty()){
            try{
                utils.log().info("loading config properties");
                is = getClass().getClassLoader().getResourceAsStream(propsFileName);
                props.load(is);
            } catch (IOException e) {
                e.printStackTrace();
                utils.log().fatal("Failed to load config properties. ABORT!!" + e.toString());
                throw e;
            } finally {
                if(is != null){
                    is.close();
                }
            }
        }
        return props;
    }
}
