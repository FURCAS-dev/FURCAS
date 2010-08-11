package com.sap.runlet.abstractinterpreter.repository;

import java.util.Set;

import org.eclipse.emf.ecore.EObject;

import com.sap.runlet.abstractinterpreter.objects.EntityObject;
import com.sap.runlet.abstractinterpreter.util.ModelAdapter;

public class EntityCreation<LinkMetaObject extends EObject, LinkEndMetaObject extends EObject,
MetaClass extends EObject, TypeUsage extends EObject, ClassUsage extends TypeUsage>
extends RepositoryChange<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> {
    private final ModelAdapter<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> modelAdapter;

    private ModelAdapter<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> getModelAdapter() {
        return modelAdapter;
    }

    public EntityCreation(EntityObject<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> entity,
	    ModelAdapter<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> modelAdapter) {
	super(entity);
	this.modelAdapter = modelAdapter;
    }

    @SuppressWarnings("unchecked")
    @Override
    public EntityObject<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> getObject() {
	return (EntityObject<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>) super.getObject();
    }

    @Override
    public boolean isCreate() {
	return true;
    }

    @Override
    public void apply(Set<EntityObject<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage>> entities,
	    SimpleLinkContainer<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> links) {
	entities.add(getObject().clone());
    }

    @Override
    public boolean isEntityChange() {
	return true;
    }
    
    @Override
    public String toString() {
	return "ce("+getModelAdapter().getClassUsageName(getObject().getType())+", "+
		getObject().getId()+")";
    }

    @Override
    public void addTo(ChangeSetImpl<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> changeSetImpl) {
	changeSetImpl.entityCreated(getObject());
    }

}
