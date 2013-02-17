package org.juitar.monitoring.api;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author sha1n
 * Date: 2/7/13
 */
public class MethodInvocationProbeTest {

    @Test
    public void testGetInvocationCount() throws InterruptedException {
        MethodInvocationProbe probe = new MethodInvocationProbe(1000);

        Assert.assertFalse(probe.hit());
        Assert.assertEquals(1, probe.getInvocationCount());

        Assert.assertFalse(probe.hit());
        Assert.assertEquals(2, probe.getInvocationCount());

        Thread.sleep(1000);

        Assert.assertTrue(probe.hit());
        Assert.assertEquals(1, probe.getInvocationCount());

        Assert.assertFalse(probe.hit());
        Assert.assertEquals(2, probe.getInvocationCount());


    }

    @Test
    public void testGetLastInvocationCount() throws InterruptedException {
        MethodInvocationProbe probe = new MethodInvocationProbe(1000);

        Assert.assertFalse(probe.hit());
        Assert.assertEquals(0, probe.getLastInvocationCount());

        Assert.assertFalse(probe.hit());
        Assert.assertEquals(0, probe.getLastInvocationCount());

        Thread.sleep(1000);

        Assert.assertTrue(probe.hit());
        Assert.assertEquals(2, probe.getLastInvocationCount());

        Assert.assertFalse(probe.hit());
        Assert.assertEquals(2, probe.getLastInvocationCount());


    }

}
