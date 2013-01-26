package org.juitar.monitoring.aspects;

import org.easymock.EasyMock;
import org.juitar.monitoring.spi.Context;
import org.juitar.monitoring.spi.ContextAccess;

/**
 * @author sha1n
 * Date: 1/26/13
 */
public class ContextAccessMock implements ContextAccess {

    private final Context contextMock;

    public ContextAccessMock() {
        this.contextMock = EasyMock.createNiceMock(Context.class);
    }

    @Override
    public Context get() {
        return contextMock;
    }
}
