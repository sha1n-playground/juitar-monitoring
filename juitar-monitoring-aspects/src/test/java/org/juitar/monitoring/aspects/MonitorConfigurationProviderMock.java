package org.juitar.monitoring.aspects;

import org.easymock.EasyMock;
import org.juitar.monitoring.spi.config.MonitorConfiguration;
import org.juitar.monitoring.spi.config.MonitorConfigurationProvider;

/**
 * @author Shai
 * Date: 1/28/13
 */
public class MonitorConfigurationProviderMock implements MonitorConfigurationProvider {

    public static final String CATEGORY_NAME_ENABLED = "enabled-category";
    public static final String CATEGORY_NAME_DISABLED = "disabled-category";

    @Override
    public MonitorConfiguration getMonitorConfiguration(String category) {
        MonitorConfiguration monitorConfiguration = EasyMock.createMock(MonitorConfiguration.class);
        switch (category) {
            case CATEGORY_NAME_ENABLED:
                EasyMock.expect(monitorConfiguration.isEnabled()).andReturn(true);
                break;
            case CATEGORY_NAME_DISABLED:
                EasyMock.expect(monitorConfiguration.isEnabled()).andReturn(false);
                break;

            default:
                throw new IllegalArgumentException("Category '" + category + "' is not expected.");
        }
        EasyMock.replay(monitorConfiguration);

        return monitorConfiguration;
    }
}
