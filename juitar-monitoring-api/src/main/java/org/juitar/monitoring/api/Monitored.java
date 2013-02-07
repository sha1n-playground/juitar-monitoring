package org.juitar.monitoring.api;

import java.lang.annotation.*;

/**
 * Annotate methods to be advised by a monitoring aspect.
 *
 * @author sha1n
 * Date: 1/4/13
 */
@Documented
@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = {ElementType.METHOD})
public @interface Monitored {

    /**
     * Returns the logical domain name of the monitored method.
     *
     * @return a String
     */
    String domain() default "default.domain";

    /**
     * Returns the logical category name of the monitored method.
     *
     * @return a String
     */
    String category() default "default.category";

    /**
     * Returns the logical operation name of the monitored method.
     *
     * @return a String.
     */
    String operation() default "unknown";

    /**
     * Execution time threshold for the monitored method. If not set, the monitor will not be able to timeout.
     *
     * @return execution time threshold in milliseconds.
     */
    long threshold() default 0L;

    /**
     * Returns the class which implements the monitor. The default is {@link MethodTimeMonitor}.
     * <p>
     *     The specified class must have a zero arguments constructor.
     * </p>
     * @return a {@link MethodMonitor} implementation class.
     */
    Class<? extends MethodMonitor> metaType() default MethodTimeMonitor.class;

}
