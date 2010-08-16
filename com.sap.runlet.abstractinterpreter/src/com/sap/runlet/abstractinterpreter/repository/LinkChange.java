package com.sap.runlet.abstractinterpreter.repository;

import org.eclipse.emf.ecore.EObject;

import com.sap.runlet.abstractinterpreter.objects.Link;

public abstract class LinkChange<LinkMetaObject extends EObject, LinkEndMetaObject extends EObject,
MetaClass extends EObject, TypeUsage extends EObject, ClassUsage extends TypeUsage>
extends RepositoryChange<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> {
    private Integer position;

    public LinkChange(Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> link, Integer insertPosition) {
	super(link);
	this.position = insertPosition;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> getObject() {
	return (Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>) super.getObject();
    }

    @Override
    public boolean isEntityChange() {
	return false;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer newPosition) {
        this.position = newPosition;
    }
    
}
