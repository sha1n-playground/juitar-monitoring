package org.juitar.monitoring.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.juitar.monitoring.api.MethodMonitor;
import org.juitar.monitoring.api.Monitored;
import org.juitar.monitoring.spi.Context;

import java.lang.reflect.Method;

/**
 * @author sha1n
 * Date: 1/3/13
 */
@Aspect
public class MonitoringAspect {

    @Pointcut(value = "execution(@org.juitar.monitoring.api.Monitored * *(..))")
    public void executeMonitored() {
    }


    @Around("executeMonitored()")
    public Object aroundMonitoredMethod(final ProceedingJoinPoint pjp) throws Throwable {

        MethodSignature signature = (MethodSignature) pjp.getSignature();
        Method method = signature.getMethod();
        Monitored monitored = method.getAnnotation(Monitored.class);
        MethodMonitor methodMonitor = monitored.metaType().newInstance();

        Context context = ContextFactory.get();
        methodMonitor.before(monitored, context);

        Object returnObject = null;
        try {
            returnObject = pjp.proceed();
        } finally {
            methodMonitor.after(monitored, context);
        }

        return returnObject;

    }

}
