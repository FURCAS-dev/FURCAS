package com.sap.runlet.abstractinterpreter.repository;

import java.util.Set;

import org.eclipse.emf.ecore.EObject;

import com.sap.runlet.abstractinterpreter.objects.EntityObject;
import com.sap.runlet.abstractinterpreter.objects.Link;

public class LinkCreation<LinkMetaObject extends EObject, LinkEndMetaObject extends EObject,
MetaClass extends EObject, TypeUsage extends EObject, ClassUsage extends TypeUsage>
extends LinkChange<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> {

    public LinkCreation(Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> link, Integer insertPosition) {
	super(link, insertPosition);
    }

    @Override
    public boolean isCreate() {
	return true;
    }

    @Override
    public void apply(Set<EntityObject<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>> entities,
	    SimpleLinkContainer<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> links) {
	links.addLink(getObject().clone(), getPosition());
    }
    
    @Override
    public String toString() {
	return "cl(" + (getObject().isOrdered() ? getPosition() + ", " : "") + getObject() +")";
    }

    @Override
    public void addTo(ChangeSetImpl<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> changeSetImpl) {
	changeSetImpl.linkCreated(getObject(), getPosition());
    }

}
