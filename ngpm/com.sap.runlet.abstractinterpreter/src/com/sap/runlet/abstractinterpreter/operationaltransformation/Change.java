package com.sap.runlet.abstractinterpreter.operationaltransformation;

import com.sap.runlet.abstractinterpreter.repository.RepositoryChange;

public interface Change<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage extends TypeUsage>
extends Iterable<RepositoryChange<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>> {
    /**
     * The total number of {@link RepositoryChange} objects the iterator
     * will produce
     */
    int totalSize();
}
