package org.juitar.monitoring.aspects;

import org.juitar.monitoring.api.Monitored;

/**
 * @author sha1n
 * Date: 1/26/13
 */
public class MonitoredDummy {

    /**
     * This method will always fail when the monitoring aspect is applied on it.
     * @throws InterruptedException
     */
    @Monitored(threshold = 5)
    public void executeTimeoutMethod() throws InterruptedException {
        Thread.sleep(6);
    }
}
