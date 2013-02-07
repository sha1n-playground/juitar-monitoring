package org.juitar.monitoring.api;

import org.juitar.monitoring.spi.config.MonitorConfiguration;
import org.juitar.monitoring.spi.context.Context;

/**
 * @author sha1n
 * Date: 1/4/13
 */
public interface MethodMonitor {

    void before(Monitored monitored, MonitorConfiguration monitorConfiguration, Context context);

    void after(Monitored monitored, MonitorConfiguration monitorConfiguration, Context context);
}
