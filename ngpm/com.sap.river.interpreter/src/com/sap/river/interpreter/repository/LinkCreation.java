package com.sap.river.interpreter.repository;

import java.util.Set;

import com.sap.river.interpreter.objects.EntityObject;
import com.sap.river.interpreter.objects.Link;

public class LinkCreation extends LinkChange {

    public LinkCreation(Link link, Integer insertPosition) {
	super(link, insertPosition);
    }

    @Override
    public boolean isCreate() {
	return true;
    }

    @Override
    public void apply(Set<EntityObject> entities, SimpleLinkContainer links) {
	links.addLink(getObject().clone(), getPosition());
    }
    
    @Override
    public String toString() {
	return "cl(" + (getObject().isOrdered() ? getPosition() + ", " : "") + getObject() +")";
    }

    @Override
    public void addTo(ChangeSetImpl changeSetImpl) {
	changeSetImpl.linkCreated(getObject(), getPosition());
    }

}
