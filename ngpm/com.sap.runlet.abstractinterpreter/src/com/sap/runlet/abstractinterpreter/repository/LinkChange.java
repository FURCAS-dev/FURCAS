package com.sap.runlet.abstractinterpreter.repository;

import com.sap.runlet.abstractinterpreter.objects.Link;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

public abstract class LinkChange<LinkMetaObject extends RefObject, LinkEndMetaObject extends RefObject,
MetaClass extends RefObject, TypeUsage extends RefObject, ClassUsage extends TypeUsage>
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
