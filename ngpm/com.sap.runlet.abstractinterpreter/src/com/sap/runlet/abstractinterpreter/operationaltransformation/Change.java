package com.sap.runlet.abstractinterpreter.operationaltransformation;

import com.sap.runlet.abstractinterpreter.repository.RepositoryChange;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

public interface Change<LinkMetaObject extends RefObject, LinkEndMetaObject extends RefObject,
MetaClass extends RefObject, TypeUsage extends RefObject, ClassUsage extends TypeUsage>
extends Iterable<RepositoryChange<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>> {
    /**
     * The total number of {@link RepositoryChange} objects the iterator
     * will produce
     */
    int totalSize();
}
