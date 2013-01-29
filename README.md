Juitar-Monitoring
=================
This repository plays with Java monitoring and flow tracking utilities based on aspects implemented using [AspectJ](http://www.eclipse.org/aspectj/).

If you are looking for something serious, this is not it. This repo is used mainly to play with ideas and learn technologies.
[Perf4J](https://github.com/perf4j/perf4j) is a project which contains a more serious implementation of similar concepts.

Usage example:
-------------

    @Monitored(
        threshold = 10,
        domain = "layer-name",
        category = "module-name",
        operation = "computation")
    public void doSomething() {
        // Do something here...
    }

Required SPI
------------

MonitorConfigurationProvider is used to get monitor configuration based on the @Monitored annotation attributes.

    public interface MonitorConfigurationProvider {

        /**
         * Returns the MonitorConfiguration for the specified {@code domain} or {@code null} if none is specified.
         *
         * @param domain
         *      the domain name
         *
         * @return MonitorConfiguration instance or {@code null}
         */
        MonitorConfiguration getDomainConfiguration(String domain);

        /**
         * Returns the MonitorConfiguration for the specified {@code category} or {@code null} if none is specified.
         *
         * @param category
         *      the category name
         *
         * @return MonitorConfiguration instance or {@code null}
         */
        MonitorConfiguration getCategoryConfiguration(String category);

        /**
         * Returns the MonitorConfiguration for the specified {@code operation} or {@code null} if none is specified.
         *
         * @param operation
         *      the operation name
         *
         * @return MonitorConfiguration instance or {@code null}
         */
        MonitorConfiguration getOperationConfiguration(String operation);

        /**
         * Returns the default MonitorConfiguration. The default is used when no other configuration exist. This method
         * should never return {@code null}.
         *
         * @return MonitorConfiguration instance.
         */
        MonitorConfiguration getDefaultConfiguration();

    }

    public interface MonitorConfiguration {

        /**
         * Returns {@code true} if the monitor is enabled, otherwise returns {@code false}.
         *
         * @return boolean
         */
        boolean isEnabled();
    }

ContextAccess is used to access context information, to allow the framework to provide valuable information when thresholds
are crossed.

    public interface ContextAccess {

        /**
         * Returns the current Context object.
         *
         * @return a Context instance
         */
        Context get();
    }

    public interface Context {
    }
