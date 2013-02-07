package org.juitar.monitoring.api;

import org.juitar.monitoring.spi.config.MonitorConfiguration;
import org.juitar.monitoring.spi.context.Context;

/**
 * @author sha1n
 * Date: 1/4/13
 */
abstract class AbstractMethodMonitor implements MethodMonitor {

    protected abstract void internBefore(Monitored monitored, MonitorConfiguration monitorConfiguration, Context ctx);

    protected abstract void internAfter(Monitored monitored, MonitorConfiguration monitorConfiguration, Context ctx);

    @Override
    public final void before(Monitored monitored, MonitorConfiguration monitorConfiguration, Context context) {
        internBefore(monitored, monitorConfiguration, context);
    }

    @Override
    public final void after(Monitored monitored, MonitorConfiguration monitorConfiguration, Context context) {
        internAfter(monitored, monitorConfiguration, context);
    }

    protected final long getFinalThreshold(Monitored monitored, MonitorConfiguration monitorConfiguration) {
        long threshold = monitorConfiguration.getThreshold();
        return threshold == 0 ? monitored.threshold() : threshold;
    }

}
