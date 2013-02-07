package org.juitar.monitoring.spi.config;

/**
 * This interface represents a configuration of a monitor. It is used by the framework to determine how intercepted
 * monitored calls should be treated, if at all.
 *
 * @author sha1n
 * Date: 1/28/13
 *
 * @see MonitorConfigurationProvider
 */
public interface MonitorConfiguration {

    /**
     * Returns {@code true} if the monitor is enabled, otherwise returns {@code false}.
     *
     * @return boolean
     */
    boolean isEnabled();

    /**
     * Returns the threshold value for the a monitor.
     *
     * @return an execution threshold in milliseconds.
     */
    long getThreshold();
}
