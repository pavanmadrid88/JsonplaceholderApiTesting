package StepDefinitions.services.base;

import Utils.RestDriver;

import java.util.Properties;

public class BaseService {

    protected static RestDriver restDriver;
    protected static Properties properties;

    public static Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        BaseService.properties = properties;
    }

    public static RestDriver getRestDriver() {
        return restDriver;
    }

    public void setRestDriver(RestDriver restDriver) {
        BaseService.restDriver = restDriver;
    }


}
