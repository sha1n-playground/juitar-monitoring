package org.juitar.monitoring.aspects;

import org.juitar.monitoring.spi.config.MonitorConfiguration;
import org.juitar.monitoring.spi.config.MonitorConfigurationProvider;

/**
 * @author Shai
 * Date: 1/28/13
 */
public class MonitorConfigurationProviderMock implements MonitorConfigurationProvider {

    private static final MonitorConfigurationMock CONFIGURATION_MOCK = new MonitorConfigurationMock();

    @Override
    public MonitorConfiguration getMonitorConfiguration(String category) {
        return CONFIGURATION_MOCK;
    }
}
