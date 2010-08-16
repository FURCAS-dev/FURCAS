package com.sap.runlet.abstractinterpreter.operationaltransformation;

import org.eclipse.emf.ecore.EObject;

import com.sap.runlet.abstractinterpreter.repository.RepositoryChange;

public interface Change<LinkMetaObject extends EObject, LinkEndMetaObject extends EObject,
MetaClass extends EObject, TypeUsage extends EObject, ClassUsage extends TypeUsage>
extends Iterable<RepositoryChange<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>> {
    /**
     * The total number of {@link RepositoryChange} objects the iterator
     * will produce
     */
    int totalSize();
}
