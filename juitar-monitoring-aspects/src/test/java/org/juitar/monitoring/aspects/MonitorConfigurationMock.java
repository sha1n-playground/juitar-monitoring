package org.juitar.monitoring.aspects;

import org.juitar.monitoring.spi.config.MonitorConfiguration;

/**
 * @author Shai
 * Date: 1/28/13
 */
public class MonitorConfigurationMock implements MonitorConfiguration {

    @Override
    public boolean isEnabled() {
        return true;
    }
}
