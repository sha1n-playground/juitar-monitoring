package org.juitar.monitoring.aspects;

import org.juitar.monitoring.spi.config.MonitorConfigurationProvider;
import org.juitar.monitoring.spi.context.Context;
import org.juitar.monitoring.spi.context.ContextAccess;

import java.util.List;

/**
 * @author Shai
 * Date: 1/28/13
 */
class SpiFactory {

    private final ContextAccess CONTEXT_ACCESS;
    private final List<MonitorConfigurationProvider> MONITOR_CONFIGURATION_PROVIDERS;

    public SpiFactory() {
        CONTEXT_ACCESS = SpiLoadUtils.loadContextAccess();
        MONITOR_CONFIGURATION_PROVIDERS = SpiLoadUtils.loadMonitorConfigurationProviders();
    }

    public Context getContext() {
        return CONTEXT_ACCESS.get();
    }

    public MonitorConfigurationProvider getMonitorConfigurationProvider() {
        return MONITOR_CONFIGURATION_PROVIDERS.get(0); // TODO decide whether multiple providers are supported.
    }

}
