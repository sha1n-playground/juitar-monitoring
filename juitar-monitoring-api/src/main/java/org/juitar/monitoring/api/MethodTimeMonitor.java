package org.juitar.monitoring.api;

import org.juitar.monitoring.spi.context.Context;

/**
 * @author sha1n
 * Date: 1/4/13
 */
public class MethodTimeMonitor extends AbstractMethodMonitor {

    private long start = 0L;


    @Override
    protected void internBefore(Monitored monitored, Context ctx) {
        this.start = System.currentTimeMillis();
    }

    @Override
    protected void internAfter(Monitored monitored, Context ctx) {
        long elapsed = System.currentTimeMillis() - start;
        if (monitored.threshold() < elapsed) {
            throw new TimeoutException(
                    "Threshold '" + monitored.threshold() + "' exceeded. Elapsed=" + elapsed);
        }
    }

}
