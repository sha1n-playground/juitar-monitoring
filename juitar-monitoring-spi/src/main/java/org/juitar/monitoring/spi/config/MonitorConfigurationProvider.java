package org.juitar.monitoring.spi.config;

/**
 * @author sha1n
 * Date: 1/28/13
 */
public interface MonitorConfigurationProvider {

    MonitorConfiguration getDomainConfiguration(String domain);

    MonitorConfiguration getCategoryConfiguration(String category);

    MonitorConfiguration getOperationConfiguration(String operation);

    MonitorConfiguration getDefaultConfiguration();

}
