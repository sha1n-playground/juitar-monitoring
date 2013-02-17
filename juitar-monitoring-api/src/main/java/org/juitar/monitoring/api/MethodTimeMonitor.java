package org.juitar.monitoring.api;

import org.juitar.monitoring.spi.config.MonitorConfiguration;

/**
 * @author sha1n
 * Date: 1/4/13
 */
public class MethodTimeMonitor extends AbstractMethodMonitor {

    private long start = 0L;

    @Override
    protected void internBefore(Monitored monitored, MonitorConfiguration monitorConfiguration) {
        this.start = System.currentTimeMillis();
    }

    @Override
    protected void internAfter(Monitored monitored, MonitorConfiguration monitorConfiguration) {
        long elapsed = System.currentTimeMillis() - start;
        long threshold = getFinalThreshold(monitored, monitorConfiguration);
        if (threshold != 0L && (monitored.threshold() < elapsed)) {
            throw new TimeoutException(
                    "Threshold '" + monitored.threshold() + "' exceeded. Elapsed=" + elapsed);
        }
    }

}
