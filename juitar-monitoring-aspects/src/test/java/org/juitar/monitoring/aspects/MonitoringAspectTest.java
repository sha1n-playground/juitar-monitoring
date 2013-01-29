package org.juitar.monitoring.aspects;

import org.juitar.monitoring.api.TimeoutException;
import org.junit.Test;

/**
 * @author sha1n
 * Date: 1/26/13
 */
public class MonitoringAspectTest {


    @Test(expected = TimeoutException.class)
    public void testCategoryDisabledOperationEnabled() throws InterruptedException {
        new MonitoredDummy().categoryDisabledOperationEnabled();
    }

    @Test(expected = TimeoutException.class)
    public void testDomainCategoryDisabledOperationEnabled() throws InterruptedException {
        new MonitoredDummy().domainCategoryDisabledOperationEnabled();
    }

    @Test(expected = TimeoutException.class)
    public void testDomainDisabledCategoryEnabled() throws InterruptedException {
        new MonitoredDummy().domainDisabledCategoryEnabled();
    }

    @Test
    public void testDefaultDisabled() throws InterruptedException {
        new MonitoredDummy().defaultDisabled();
    }

    @Test
    public void testAllDisabled() throws InterruptedException {
        new MonitoredDummy().allDisabled();
    }
}
