package org.juitar.monitoring.aspects;

import org.juitar.monitoring.api.Monitored;

/**
 * @author sha1n
 * Date: 1/29/13
 */
public class MonitoredDummy {

    /**
     * This method should always timeout, since operation level configuration always have the highest priority.
     */
    @Monitored(
            threshold = 5,
            domain = MonitorConfigurationProviderMock.DOMAIN_NAME_DISABLED,
            category = MonitorConfigurationProviderMock.CATEGORY_NAME_DISABLED,
            operation = MonitorConfigurationProviderMock.OPERATION_NAME_ENABLED)
    public void domainCategoryDisabledOperationEnabled() throws InterruptedException {
        Thread.sleep(6);
    }

    /**
     * This method should always timeout, since category level configuration have higher priority than domain
     * level, and operation is not specified.
     */
    @Monitored(
            threshold = 5,
            domain = MonitorConfigurationProviderMock.DOMAIN_NAME_DISABLED,
            category = MonitorConfigurationProviderMock.CATEGORY_NAME_ENABLED)
    public void domainDisabledCategoryEnabled() throws InterruptedException {
        Thread.sleep(6);
    }

    /**
     * This method should always timeout, since operation level configuration have higher priority than category
     * level.
     */
    @Monitored(
            threshold = 5,
            category = MonitorConfigurationProviderMock.CATEGORY_NAME_DISABLED,
            operation = MonitorConfigurationProviderMock.OPERATION_NAME_ENABLED)
    public void categoryDisabledOperationEnabled() throws InterruptedException {
        Thread.sleep(6);
    }

    /**
     * This method never timeout, since the default monitor configuration is disabled.
     */
    @Monitored(threshold = 5)
    public void defaultDisabled() throws InterruptedException {
        Thread.sleep(6);
    }

    /**
     * This method never timeout, since the specified domain, category and operation are disabled.
     */
    @Monitored(
            threshold = 5,
            domain = MonitorConfigurationProviderMock.DOMAIN_NAME_DISABLED,
            category = MonitorConfigurationProviderMock.CATEGORY_NAME_DISABLED,
            operation = MonitorConfigurationProviderMock.OPERATION_NAME_DISABLED
    )
    public void allDisabled() throws InterruptedException {
        Thread.sleep(6);
    }
}
