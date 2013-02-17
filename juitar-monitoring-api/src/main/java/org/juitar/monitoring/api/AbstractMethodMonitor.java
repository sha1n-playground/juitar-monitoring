package org.juitar.monitoring.api;

import org.juitar.monitoring.spi.config.MonitorConfiguration;

/**
 * @author sha1n
 * Date: 1/4/13
 */
abstract class AbstractMethodMonitor implements MethodMonitor {

    protected abstract void internBefore(Monitored monitored, MonitorConfiguration monitorConfiguration);

    protected abstract void internAfter(Monitored monitored, MonitorConfiguration monitorConfiguration);

    @Override
    public final void before(Monitored monitored, MonitorConfiguration monitorConfiguration) {
        internBefore(monitored, monitorConfiguration);
    }

    @Override
    public final void after(Monitored monitored, MonitorConfiguration monitorConfiguration) {
        internAfter(monitored, monitorConfiguration);
    }

    protected final long getFinalThreshold(Monitored monitored, MonitorConfiguration monitorConfiguration) {
        long threshold = monitorConfiguration.getThreshold();
        return threshold == 0 ? monitored.threshold() : threshold;
    }

}
