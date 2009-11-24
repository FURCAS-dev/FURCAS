package com.sap.finex.interpreter;

import java.util.Collection;
import java.util.List;

import structure.Association;
import structure.Field;
import structure.FinexClass;
import structure.Type;

import com.sap.runlet.abstractinterpreter.Side;
import com.sap.runlet.abstractinterpreter.util.ModelAdapter;

public class FinexModelAdapter implements ModelAdapter<Association, Field, FinexClass, Type, FinexClass> {

    @Override
    public boolean aConformsToB(Type a, Type b) {
	return a.equals(b);
    }

    @Override
    public String getClassName(FinexClass clazz) {
	return clazz.getName();
    }

    @Override
    public String getClassUsageName(FinexClass classUsage) {
	return classUsage.getName();
    }

    @Override
    public FinexClass getClazz(FinexClass classUsage) {
	return classUsage;
    }

    @Override
    public Collection<Field> getConformsToCompositeChildAssociationEnds(FinexClass clazz) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public boolean isValueType(FinexClass clazz) {
	return clazz.isValueType();
    }

    @Override
    public Association getAssociation(Field end) {
	return end.getAssociation();
    }

    @Override
    public Collection<Field> getEqualityRelevantAssociationEnds(FinexClass clazz) {
	return clazz.getNavigableFields();
    }

    @Override
    public String getAssociationName(Association association) {
	return association.getName();
    }

    @Override
    public FinexClass getClassUsage(Field end) {
	return (FinexClass) end.getType();
    }

    @Override
    public Collection<Field> getConformsToAssociationEnds(FinexClass clazz) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public String getEndName(Field end) {
	return end.getName();
    }

    @Override
    public FinexClass getEndType(Field end) {
	return (FinexClass) end.getType();
    }

    @Override
    public List<Field> getEnds(Association association) {
	return association.getEnds();
    }

    @Override
    public Side getSideOfEnd(Field end) {
	if (end.getAssociation().getEnds().get(0).equals(end)) {
	    return Side.LEFT;
	} else {
	    return Side.RIGHT;
	}
    }

    /**
     * If the field's type is owned by the other end's type, this strongly suggests composition.
     */
    @Override
    public boolean isComposite(Field end) {
	return otherEnd(end) instanceof FinexClass &&
		((FinexClass) otherEnd(end)).getOwner() != null &&
		((FinexClass) otherEnd(end)).getOwner().equals(otherEnd(end).getType());
    }

    @Override
    public boolean isContributesToEquality(Field end) {
	return end.isNavigable();
    }

    @Override
    public boolean isMany(Field end) {
	return !end.isSingleMultiplicity();
    }

    @Override
    public boolean isOrdered(Field end) {
	// currently there is no explicit notion of ordering in FINEX 
	return false;
    }

    @Override
    public boolean isUnique(Field end) {
	// currently, uniqueness is not explicitly modeled on types in FINEX
	return false;
    }

    @Override
    public Field otherEnd(Field end) {
	return getEnds(getAssociation(end)).get(getSideOfEnd(end).otherEndNumber());
    }

}
