package org.juitar.monitoring.spi.config;

/**
 * This interface is used by the monitoring framework to determine monitor configuration based on attributes set on
 * {@link org.juitar.monitoring.api.Monitored} instances.
 * <p>
 *     An instance of MonitorConfigurationProvider must be stateless, since it will only be created once.
 * </p>
 * <p>
 *     {@link MonitorConfiguration} is applied according to the following priority:
 * </p>
 * <ul>
 *  <li>operation</li>
 *  <li>category</li>
 *  <li>domain</li>
 * </ul>
 *
 * @author sha1n
 * Date: 1/28/13
 */
public interface MonitorConfigurationProvider {

    /**
     * Returns the MonitorConfiguration for the specified {@code domain} or {@code null} if none is specified.
     *
     * @param domain
     *      the domain name
     *
     * @return MonitorConfiguration instance or {@code null}
     */
    MonitorConfiguration getDomainConfiguration(String domain);

    /**
     * Returns the MonitorConfiguration for the specified {@code category} or {@code null} if none is specified.
     *
     * @param category
     *      the category name
     *
     * @return MonitorConfiguration instance or {@code null}
     */
    MonitorConfiguration getCategoryConfiguration(String category);

    /**
     * Returns the MonitorConfiguration for the specified {@code operation} or {@code null} if none is specified.
     *
     * @param operation
     *      the operation name
     *
     * @return MonitorConfiguration instance or {@code null}
     */
    MonitorConfiguration getOperationConfiguration(String operation);

    /**
     * Returns the default MonitorConfiguration. The default is used when no other configuration exist. This method
     * should never return {@code null}.
     *
     * @return MonitorConfiguration instance.
     */
    MonitorConfiguration getDefaultConfiguration();

}
