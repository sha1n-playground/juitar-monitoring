package org.juitar.monitoring.api;

import org.juitar.monitoring.spi.config.MonitorConfiguration;
import org.juitar.monitoring.spi.context.Context;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author sha1n
 * Date: 1/4/13
 */
public class MethodHitMonitor extends AbstractMethodMonitor {

    public static final long FRAME = 1000L; // One second

    private static final Map<Monitored, MethodInvocationProbe> probes = new ConcurrentHashMap<>();

    static MethodInvocationProbe getProbe(Monitored monitored) {
        MethodInvocationProbe invocationProbe = probes.get(monitored);
        if (invocationProbe == null) {
            invocationProbe = new MethodInvocationProbe(FRAME);
            probes.put(monitored, invocationProbe);
        }

        return invocationProbe;
    }

    @Override
    protected void internBefore(Monitored monitored, MonitorConfiguration monitorConfiguration, Context ctx) {
        MethodInvocationProbe probe = getProbe(monitored);
        if (probe.hit()) {
            // TODO: Here the data should be accumulated or reported somehow.
            System.out.println(monitored.toString() + ":" + probe.getInvocationCount());
        }
    }

    @Override
    protected void internAfter(Monitored monitored, MonitorConfiguration monitorConfiguration, Context ctx) {
    }
}
