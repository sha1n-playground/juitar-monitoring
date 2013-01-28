package org.juitar.monitoring.aspects;

import org.juitar.monitoring.spi.config.MonitorConfiguration;
import org.juitar.monitoring.spi.config.MonitorConfigurationProvider;
import org.juitar.monitoring.spi.context.Context;
import org.juitar.monitoring.spi.context.ContextAccess;

import java.util.ServiceLoader;

/**
 * @author Shai
 * Date: 1/28/13
 */
public class SpiFactory {

    private static final ContextAccess CONTEXT_ACCESS;
    private static final MonitorConfigurationProvider MONITOR_CONFIGURATION_PROVIDER;

    static {
        ServiceLoader<MonitorConfigurationProvider> monitorConfigurationProviderServiceLoader = ServiceLoader.load(MonitorConfigurationProvider.class, SpiFactory.class.getClassLoader());
        ServiceLoader<ContextAccess> contextAccessServiceLoader = ServiceLoader.load(ContextAccess.class, SpiFactory.class.getClassLoader());

        CONTEXT_ACCESS = contextAccessServiceLoader.iterator().next();
        MONITOR_CONFIGURATION_PROVIDER = monitorConfigurationProviderServiceLoader.iterator().next();
    }

    private SpiFactory() {
    }

    public static Context getContext() {
        return CONTEXT_ACCESS.get();
    }

    public static MonitorConfiguration getMonitorConfiguration(String category) {
        return MONITOR_CONFIGURATION_PROVIDER.getMonitorConfiguration(category);
    }

}
