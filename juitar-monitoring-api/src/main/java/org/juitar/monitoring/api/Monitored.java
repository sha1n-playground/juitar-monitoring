package org.juitar.monitoring.api;

import java.lang.annotation.*;

/**
 * @author sha1n
 * Date: 1/4/13
 */
@Documented
@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = {ElementType.METHOD})
public @interface Monitored {

    Class<? extends MethodMonitor> metaType() default MethodTimeMonitor.class;

    String domain() default "CURRENT-PACKAGE-NAME";

    String category() default "CURRENT-CLASS-NAME";

    String operation() default "CURRENT-METHOD-NAME";

    long threshold() default 0L;
}
