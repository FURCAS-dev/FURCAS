package com.sap.river.interpreter.repository;

import java.util.Set;

import com.sap.river.interpreter.objects.EntityObject;
import com.sap.river.interpreter.objects.Link;

public class LinkDeletion extends LinkChange {

    public LinkDeletion(Link link, Integer insertPosition) {
	super(link, insertPosition);
    }
    
    @Override
    public boolean isCreate() {
	return false;
    }

    @Override
    public void apply(Set<EntityObject> entities, SimpleLinkContainer links) {
	links.removeLink(getObject(), getPosition());
    }
    
    @Override
    public String toString() {
	return "dl(" + (getObject().isOrdered() ? getPosition() + ", " : "") + getObject() +")";
    }

    @Override
    public void addTo(ChangeSetImpl changeSetImpl) {
	changeSetImpl.linkDeleted(getObject(), getPosition());
    }

}
