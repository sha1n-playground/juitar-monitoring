package org.juitar.monitoring.spi.config;

/**
 * @author Shai
 * Date: 1/28/13
 */
public interface MonitorConfigurationProvider {

    MonitorConfiguration getMonitorConfiguration(String category);
}
