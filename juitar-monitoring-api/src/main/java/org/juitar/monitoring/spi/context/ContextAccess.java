package org.juitar.monitoring.spi.context;

/**
 * This interface is a factory interface from the Context interface. An instance of ContextAccess must be stateless,
 * since it will only be created once.
 *
 * @author sha1n
 * Date: 1/26/13
 */
public interface ContextAccess {

    /**
     * Returns the current Context object.
     *
     * @return a Context instance
     */
    Context get();
}
