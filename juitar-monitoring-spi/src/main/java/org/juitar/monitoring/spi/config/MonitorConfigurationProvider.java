package org.juitar.monitoring.spi.config;

/**
 * @author sha1n
 * Date: 1/28/13
 */
public interface MonitorConfigurationProvider {

    MonitorConfiguration getMonitorConfiguration(String category);
}
