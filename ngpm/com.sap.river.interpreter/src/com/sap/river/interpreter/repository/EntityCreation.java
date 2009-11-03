package com.sap.river.interpreter.repository;

import java.util.Set;

import com.sap.river.interpreter.objects.EntityObject;

public class EntityCreation extends RepositoryChange {

    public EntityCreation(EntityObject entity) {
	super(entity);
    }

    @Override
    public EntityObject getObject() {
	return (EntityObject) super.getObject();
    }

    @Override
    public boolean isCreate() {
	return true;
    }

    @Override
    public void apply(Set<EntityObject> entities, SimpleLinkContainer links) {
	entities.add(getObject().clone());
    }

    @Override
    public boolean isEntityChange() {
	return true;
    }
    
    @Override
    public String toString() {
	return "ce("+getObject().getType().getClazz().getName()+", "+
		getObject().getId()+")";
    }

    @Override
    public void addTo(ChangeSetImpl changeSetImpl) {
	changeSetImpl.entityCreated(getObject());
    }

}
