package com.sap.runlet.abstractinterpreter.operationaltransformation;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import com.sap.runlet.abstractinterpreter.repository.RepositoryChange;

public class EmptyChange<LinkMetaObject extends EObject, LinkEndMetaObject extends EObject,
MetaClass extends EObject, TypeUsage extends EObject, ClassUsage extends TypeUsage>
implements Change<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> {

    @Override
    public int totalSize() {
	return 0;
    }

    @Override
    public Iterator<RepositoryChange<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>> iterator() {
	List<RepositoryChange<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>> emptyList = Collections.emptyList();
	return emptyList.iterator();
    }

    @Override
    public String toString() {
	return "<empty>";
    }
}
