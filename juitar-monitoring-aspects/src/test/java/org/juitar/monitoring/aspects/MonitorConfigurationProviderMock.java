package org.juitar.monitoring.aspects;

import org.easymock.EasyMock;
import org.juitar.monitoring.spi.config.MonitorConfiguration;
import org.juitar.monitoring.spi.config.MonitorConfigurationProvider;

/**
 * @author Shai
 * Date: 1/28/13
 */
public class MonitorConfigurationProviderMock implements MonitorConfigurationProvider {

    public static final String DOMAIN_NAME_ENABLED = "enabled-domain";
    public static final String DOMAIN_NAME_DISABLED = "disabled-domain";
    public static final String CATEGORY_NAME_ENABLED = "enabled-category";
    public static final String CATEGORY_NAME_DISABLED = "disabled-category";
    public static final String OPERATION_NAME_ENABLED = "enabled-operation";
    public static final String OPERATION_NAME_DISABLED = "disabled-operation";


    @Override
    public MonitorConfiguration getDomainConfiguration(String domain) {
        MonitorConfiguration monitorConfiguration = null;
        switch (domain) {
            case DOMAIN_NAME_ENABLED:
                monitorConfiguration = createMock();
                EasyMock.expect(monitorConfiguration.isEnabled()).andReturn(true);
                break;
            case DOMAIN_NAME_DISABLED:
                monitorConfiguration = createMock();
                EasyMock.expect(monitorConfiguration.isEnabled()).andReturn(false);
                break;
        }
        return prepareMock(monitorConfiguration);

    }

    @Override
    public MonitorConfiguration getCategoryConfiguration(String category) {
        MonitorConfiguration monitorConfiguration = null;
        switch (category) {
            case CATEGORY_NAME_ENABLED:
                monitorConfiguration = createMock();
                EasyMock.expect(monitorConfiguration.isEnabled()).andReturn(true);
                break;
            case CATEGORY_NAME_DISABLED:
                monitorConfiguration = createMock();
                EasyMock.expect(monitorConfiguration.isEnabled()).andReturn(false);
                break;
        }

        return prepareMock(monitorConfiguration);

    }

    @Override
    public MonitorConfiguration getOperationConfiguration(String operation) {
        MonitorConfiguration monitorConfiguration = null;
        switch (operation) {
            case OPERATION_NAME_ENABLED:
                monitorConfiguration = createMock();
                EasyMock.expect(monitorConfiguration.isEnabled()).andReturn(true);
                break;
            case OPERATION_NAME_DISABLED:
                monitorConfiguration = createMock();
                EasyMock.expect(monitorConfiguration.isEnabled()).andReturn(false);
                break;
        }
        return prepareMock(monitorConfiguration);

    }

    @Override
    public MonitorConfiguration getDefaultConfiguration() {
        MonitorConfiguration monitorConfiguration = createMock();
        EasyMock.expect(monitorConfiguration.isEnabled()).andReturn(false);
        return prepareMock(monitorConfiguration);
    }

    private MonitorConfiguration prepareMock(MonitorConfiguration monitorConfiguration) {
        if (monitorConfiguration != null) {
            EasyMock.replay(monitorConfiguration);
        }
        return monitorConfiguration;
    }

    private MonitorConfiguration createMock() {
        return EasyMock.createMock(MonitorConfiguration.class);
    }
}
