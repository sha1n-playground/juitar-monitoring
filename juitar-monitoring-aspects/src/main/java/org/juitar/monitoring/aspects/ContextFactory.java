package org.juitar.monitoring.aspects;

import org.juitar.monitoring.spi.Context;
import org.juitar.monitoring.spi.ContextAccess;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author sha1n
 * Date: 1/26/13
 */
public final class ContextFactory {

    private static final String CONTEXT_SPI_RESOURCE_NAME = "/META-INF/services/org.juitar.monitoring.spi.ContextAccess";
    private static final ContextAccess PROVIDED_CONTEXT_ACCESS;

    static {
        BufferedReader br = new BufferedReader(new InputStreamReader(ContextFactory.class.getResourceAsStream(CONTEXT_SPI_RESOURCE_NAME)));

        try {
            String line = br.readLine();
            line = line.trim();
            PROVIDED_CONTEXT_ACCESS = (ContextAccess) Class.forName(line).newInstance();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("ContextAccess class could not be found", e);
        } catch (Exception e) {
            throw new RuntimeException("Failed create create ContextAccess instance. Read from resource '" + CONTEXT_SPI_RESOURCE_NAME + "'", e);
        }
    }

    public static Context get() {
        return PROVIDED_CONTEXT_ACCESS.get();
    }

    private ContextFactory() {
    }
}
