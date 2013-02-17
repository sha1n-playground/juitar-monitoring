package org.juitar.monitoring.aspects;

import org.juitar.monitoring.spi.config.MonitorConfigurationProvider;

import java.util.List;

/**
 * @author Shai
 * Date: 1/28/13
 */
class SpiFactory {

    private final List<MonitorConfigurationProvider> MONITOR_CONFIGURATION_PROVIDERS;

    public SpiFactory() {
        MONITOR_CONFIGURATION_PROVIDERS = SpiLoadUtils.loadMonitorConfigurationProviders();
    }

    public MonitorConfigurationProvider getMonitorConfigurationProvider() {
        return MONITOR_CONFIGURATION_PROVIDERS.get(0); // TODO decide whether multiple providers are supported.
    }

}
