package org.juitar.monitoring.api;

import org.juitar.monitoring.spi.Context;

/**
 * @author sha1n
 * Date: 1/4/13
 */
abstract class AbstractMethodMonitor implements MethodMonitor {

    protected abstract void internBefore(Monitored monitored, Context ctx);

    protected abstract void internAfter(Monitored monitored, Context ctx);

    @Override
    public final void before(Monitored monitored, Context context) {
//        System.out.println("Before " + context.getCorrelationId());

        internBefore(monitored, context);
    }

    @Override
    public final void after(Monitored monitored, Context context) {
        internAfter(monitored, context);

//        System.out.println("After " + context.getCorrelationId());
    }
}
