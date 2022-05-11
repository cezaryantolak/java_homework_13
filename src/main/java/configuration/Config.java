package configuration;

import configuration.model.BrowserModel;
import configuration.model.EnvironmentModel;
import configuration.model.EnvironmentsModel;

public class Config {
    public String activeEnvironmentName;
    public EnvironmentsModel environments;
    public BrowserModel browser;

    public EnvironmentsModel getEnvironments() {
        return environments;
    }

    public BrowserModel getBrowser() {

        return browser;
    }

    public EnvironmentModel getActiveEnvironment() {

        return environments.getEnvironments().get(activeEnvironmentName);
    }
}
