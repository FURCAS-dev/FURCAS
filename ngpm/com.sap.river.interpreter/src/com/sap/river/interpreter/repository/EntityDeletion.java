package com.sap.river.interpreter.repository;

import java.util.Set;

import com.sap.river.interpreter.objects.EntityObject;

public class EntityDeletion extends RepositoryChange {
    public EntityDeletion(EntityObject entity) {
	super(entity);
    }

    @Override
    public EntityObject getObject() {
	return (EntityObject) super.getObject();
    }

    @Override
    public boolean isCreate() {
	return false;
    }

    @Override
    public void apply(Set<EntityObject> entities, SimpleLinkContainer links) {
	entities.remove(getObject());
    }

    @Override
    public boolean isEntityChange() {
	return true;
    }

    @Override
    public String toString() {
	return "de(" + getObject().getType().getClazz().getName() + ", " + getObject().getId()+")";
    }

    @Override
    public void addTo(ChangeSetImpl changeSetImpl) {
	changeSetImpl.entityDeleted(getObject());
    }

}
