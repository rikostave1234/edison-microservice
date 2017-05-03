package de.otto.edison.dependencies.domain;

import java.util.List;

public class DatasourceDependencyBuilder {
    private String name;
    private String group;
    private String description;
    private String type;
    private String subType;
    private List<Datasource> datasources;

    public static DatasourceDependencyBuilder copyOf(final DatasourceDependency other) {
        return new DatasourceDependencyBuilder()
                .withName(other.name)
                .withGroup(other.group)
                .withDescription(other.description)
                .withType(other.type)
                .withSubType(other.subType)
                .withDataSources(other.datasources);
    }

    /**
     * Creates a ServiceDependencyBuilder with type="db" and subType="MongoDB".
     *
     * @param datasources the datasources of the accessed database.
     * @return builder used to configure MongoDB datasource dependencies
     */
    public static DatasourceDependencyBuilder mongoDataSourceDependency(final List<Datasource> datasources) {
        return new DatasourceDependencyBuilder()
                .withDataSources(datasources)
                .withType(DatasourceDependency.TYPE_DB)
                .withSubType(DatasourceDependency.SUBTYPE_MONGODB);
    }

    /**
     * Creates a ServiceDependencyBuilder with type="db" and subType="Redis".
     *
     * @param datasources the datasources of the accessed database.
     * @return builder used to configure Redis datasource dependencies
     */
    public static DatasourceDependencyBuilder redisDataSourceDependency(final List<Datasource> datasources) {
        return new DatasourceDependencyBuilder()
                .withDataSources(datasources)
                .withType(DatasourceDependency.TYPE_DB)
                .withSubType(DatasourceDependency.SUBTYPE_REDIS);
    }

    /**
     * Creates a ServiceDependencyBuilder with type="db" and subType="Cassandra".
     *
     * @param datasources the datasources of the accessed database.
     * @return builder used to configure Cassandra datasource dependencies
     */
    public static DatasourceDependencyBuilder cassandraDataSourceDependency(final List<Datasource> datasources) {
        return new DatasourceDependencyBuilder()
                .withDataSources(datasources)
                .withType(DatasourceDependency.TYPE_DB)
                .withSubType(DatasourceDependency.SUBTYPE_CASSANDRA);
    }

    /**
     * Creates a ServiceDependencyBuilder with type="queue" and subType="Kafka".
     *
     * @param datasources the datasources of the accessed queue.
     * @return builder used to configure Kafka datasource dependencies
     */
    public static DatasourceDependencyBuilder kafkaDataSourceDependency(final List<Datasource> datasources) {
        return new DatasourceDependencyBuilder()
                .withDataSources(datasources)
                .withType(DatasourceDependency.TYPE_QUEUE)
                .withSubType(DatasourceDependency.SUBTYPE_KAFKA);
    }

    /**
     * Creates a generic DataSourceDependencyBuilder.
     *
     * @param datasources the datasources of the accessed database.
     * @param type the type of the datasource
     * @param subType the subtype of the datasource
     * @return builder used to configure other datasource dependencies
     */
    public static DatasourceDependencyBuilder datasourceDependency(final List<Datasource> datasources,
                                                                   final String type,
                                                                   final String subType) {
        return new DatasourceDependencyBuilder()
                .withDataSources(datasources)
                .withType(type)
                .withSubType(subType);
    }

    /**
     * @param name The name of the dependent service.
     */
    public DatasourceDependencyBuilder withName(final String name) {
        this.name = name;
        return this;
    }

    /**
     * @param group The service group like, for example, the vertical aka SCS the service is belonging to.
     */
    public DatasourceDependencyBuilder withGroup(final String group) {
        this.group = group;
        return this;
    }

    /**
     * @param description A human readable description of the dependency.
     */
    public DatasourceDependencyBuilder withDescription(final String description) {
        this.description = description;
        return this;
    }

    /**
     * @param type The type of the dependency: db, queue, service, ...
     */
    public DatasourceDependencyBuilder withType(final String type) {
        this.type = type;
        return this;
    }

    /**
     * @param subType The sub-type of the dependency: Cassandra, MongoDB, Kafka, REST, ...
     */
    public DatasourceDependencyBuilder withSubType(final String subType) {
        this.subType = subType;
        return this;
    }

    /**
     * @param dataSources DataSource descriptors for databases or queues
     */
    public DatasourceDependencyBuilder withDataSources(final List<Datasource> dataSources) {
        this.datasources = dataSources;
        return this;
    }

    /**
     * Builds a ServiceDependency instance.
     *
     * @return service dependency
     */
    public DatasourceDependency build() {
        return new DatasourceDependency(name, group, description, type, subType, datasources);
    }
}