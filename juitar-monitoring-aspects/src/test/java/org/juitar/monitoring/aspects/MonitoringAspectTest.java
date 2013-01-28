package org.juitar.monitoring.aspects;

import org.juitar.monitoring.api.TimeoutException;
import org.junit.Test;

/**
 * @author sha1n
 * Date: 1/26/13
 */
public class MonitoringAspectTest {

    @Test(expected = TimeoutException.class)
    public void testMethodTimeout() throws InterruptedException {
        new MonitoredDummy().executeTimeoutMethod();
    }

    @Test
    public void testNiceMethod() throws InterruptedException {
        new MonitoredDummy().executeNiceMethod();
    }

    @Test
    public void testMethodDisabledMonitor() throws InterruptedException {
        new MonitoredDummy().executeTimeoutMethodWithDisabledCategory();
    }

}
