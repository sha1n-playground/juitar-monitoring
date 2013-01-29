package org.juitar.monitoring.aspects;

import org.juitar.monitoring.spi.config.MonitorConfigurationProvider;
import org.juitar.monitoring.spi.context.ContextAccess;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;

/**
 * @author sha1n
 * Date: 1/29/13
 */
final class SpiLoadUtils {

    static ContextAccess loadContextAccess() {
        ServiceLoader<ContextAccess> contextAccessServiceLoader = ServiceLoader.load(ContextAccess.class, SpiFactory.class.getClassLoader());

        Iterator<ContextAccess> iterator = contextAccessServiceLoader.iterator();
        ContextAccess contextAccess = iterator.next();

        if (iterator.hasNext()) {
            throw new UnsupportedOperationException(); // TODO declare exception type.
        }

        return contextAccess;
    }

    static List<MonitorConfigurationProvider> loadMonitorConfigurationProviders() {
        ServiceLoader<MonitorConfigurationProvider> monitorConfigurationProviderServiceLoader = ServiceLoader.load(MonitorConfigurationProvider.class, SpiFactory.class.getClassLoader());

        List<MonitorConfigurationProvider> providers = new ArrayList<>();
        for (MonitorConfigurationProvider provider : monitorConfigurationProviderServiceLoader) {
            providers.add(provider);
        }

        if (providers.isEmpty()) {
            throw new UnsupportedOperationException(); // TODO declare exception type.
        }

        return providers;

    }

    private SpiLoadUtils() {
    }
}
