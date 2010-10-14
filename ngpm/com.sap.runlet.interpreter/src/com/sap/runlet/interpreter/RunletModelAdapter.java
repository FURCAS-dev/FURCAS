package com.sap.runlet.interpreter;

import java.util.Collection;
import java.util.List;

import com.sap.runlet.abstractinterpreter.Side;
import com.sap.runlet.abstractinterpreter.util.ModelAdapter;

import data.classes.Association;
import data.classes.AssociationEnd;
import data.classes.ClassTypeDefinition;
import data.classes.SapClass;
import data.classes.TypeDefinition;

public class RunletModelAdapter implements ModelAdapter<Association, AssociationEnd, SapClass, TypeDefinition, ClassTypeDefinition> {
    @Override
    public boolean aConformsToB(TypeDefinition a, TypeDefinition b) {
	return a.conformsTo(b);
    }

    @Override
    public SapClass getClazz(ClassTypeDefinition classUsage) {
	return classUsage.getClazz();
    }

    @Override
    public String getClassUsageName(ClassTypeDefinition classUsage) {
	return classUsage.getClazz().getName();
    }

    @Override
    public String getClassName(SapClass clazz) {
	return clazz.getName();
    }

    @Override
    public boolean isValueType(SapClass clazz) {
	return clazz.isValueType();
    }

    @Override
    public Association getAssociation(AssociationEnd end) {
	return end.getAssociation();
    }

    @Override
    public String getEndName(AssociationEnd end) {
	return end.getName();
    }

    @Override
    public SapClass getEndType(AssociationEnd end) {
	return end.getType().getClazz();
    }

    @Override
    public List<AssociationEnd> getEnds(Association association) {
	return association.getEnds();
    }

    @Override
    public String getAssociationName(Association association) {
	return association.getName();
    }

    @Override
    public Side getSideOfEnd(AssociationEnd end) {
	if (end.getAssociation().getEnds().get(Side.LEFT.endNumber()).equals(end)) {
	    return Side.LEFT;
	} else {
	    return Side.RIGHT;
	}
    }

    @Override
    public boolean isOrdered(AssociationEnd end) {
	return end.getType().isOrdered();
    }

    @Override
    public boolean isUnique(AssociationEnd end) {
	return end.getType().isUnique();
    }

    @Override
    public AssociationEnd otherEnd(AssociationEnd end) {
	return getEnds(getAssociation(end)).get(getSideOfEnd(end).otherEndNumber());
    }

    @Override
    public Collection<AssociationEnd> getConformsToAssociationEnds(SapClass clazz) {
	return clazz.getConformsToAssociationEnds();
    }

    @Override
    public boolean isContributesToEquality(AssociationEnd end) {
	return end.isContributesToEquality();
    }

    @Override
    public boolean isComposite(AssociationEnd end) {
	return end.isComposite();
    }

    @Override
    public Collection<AssociationEnd> getEqualityRelevantAssociationEnds(SapClass clazz) {
	return clazz.getEqualityRelevantAssociationEnds();
    }

    @Override
    public boolean isMany(AssociationEnd end) {
	return end.getType().getUpperMultiplicity() != 1;
    }

    @Override
    public Collection<AssociationEnd> getConformsToCompositeChildAssociationEnds(SapClass clazz) {
	return clazz.getConformsToCompositeChildAssociationEnds();
    }

    @Override
    public ClassTypeDefinition getClassUsage(AssociationEnd end) {
	return end.getType();
    }
    
}
