package org.juitar.monitoring.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.juitar.monitoring.api.MethodMonitor;
import org.juitar.monitoring.api.Monitored;
import org.juitar.monitoring.spi.config.MonitorConfiguration;
import org.juitar.monitoring.spi.config.MonitorConfigurationProvider;
import org.juitar.monitoring.spi.context.Context;

import java.lang.reflect.Method;

/**
 * @author sha1n
 * Date: 1/3/13
 */
@Aspect
public class MonitoringAspect {

    private static final SpiFactory spiFactory = new SpiFactory();

    private static boolean isGloballyDisabled() {
        return System.getProperties().containsKey("org.juitar.monitoring.aspects.Off");
    }

    @Pointcut(value = "execution(@org.juitar.monitoring.api.Monitored * *(..))")
    public void executeMonitored() {
    }

    @Around("executeMonitored()")
    public Object aroundMonitoredMethod(final ProceedingJoinPoint pjp) throws Throwable {

        Object returnObject;

        if (isGloballyDisabled()) {
            returnObject = pjp.proceed();
        } else {
            returnObject = executeMonitoredMethod(pjp);
        }
        return returnObject;
    }

    private Object executeMonitoredMethod(ProceedingJoinPoint pjp) throws Throwable {
        Object returnObject;

        MethodSignature signature = (MethodSignature) pjp.getSignature();
        Method method = signature.getMethod();
        Monitored monitored = method.getAnnotation(Monitored.class);
        MonitorConfiguration monitorConfiguration = getMonitorConfiguration(monitored);

        if (!monitorConfiguration.isEnabled()) {
            returnObject = pjp.proceed();
        } else {
            returnObject = executeWithMonitor(pjp, monitored);
        }
        return returnObject;
    }

    private Object executeWithMonitor(final ProceedingJoinPoint pjp, final Monitored monitored) throws Throwable {

        Object returnObject;

        Context context = spiFactory.getContext();
        MethodMonitor methodMonitor = monitored.metaType().newInstance();

        methodMonitor.before(monitored, context);

        try {
            returnObject = pjp.proceed();
        } finally {
            methodMonitor.after(monitored, context);
        }

        return returnObject;
    }

    private MonitorConfiguration getMonitorConfiguration(final Monitored monitored) {
        MonitorConfigurationProvider monitorConfigurationProvider = spiFactory.getMonitorConfigurationProvider();

        // Operation configuration has the highest priority.
        MonitorConfiguration monitorConfiguration = monitorConfigurationProvider.getOperationConfiguration(monitored.operation());

        // Try to fallback to category configuration.
        if (monitorConfiguration == null) {
            monitorConfiguration = monitorConfigurationProvider.getCategoryConfiguration(monitored.category());
        }

        // Try to fallback to domain configuration
        if (monitorConfiguration == null) {
            monitorConfiguration = monitorConfigurationProvider.getDomainConfiguration(monitored.domain());
        }

        // Fallback to default
        if (monitorConfiguration == null) {
            monitorConfiguration = monitorConfigurationProvider.getDefaultConfiguration();
        }

        return monitorConfiguration;
    }

}
