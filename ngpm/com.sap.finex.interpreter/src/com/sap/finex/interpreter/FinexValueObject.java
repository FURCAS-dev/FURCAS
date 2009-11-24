package com.sap.finex.interpreter;

import java.util.Collection;
import java.util.Map;

import structure.Association;
import structure.Field;
import structure.FinexClass;
import structure.Type;

import com.sap.runlet.abstractinterpreter.objects.AbstractValueObject;
import com.sap.runlet.abstractinterpreter.objects.ClassTypedObject;
import com.sap.runlet.abstractinterpreter.repository.SnapshotIdentifier;

public class FinexValueObject
extends AbstractValueObject<Association, Field, FinexClass, Type, FinexClass>
implements Cloneable {

    public FinexValueObject(FinexClass type, Map<Field, Collection<ClassTypedObject<Field, Type, FinexClass>>> propertyValues,
	    SnapshotIdentifier snapshot, FinexInterpreter interpreter) {
	super(type, propertyValues, snapshot, interpreter.getModelAdapter());
    }

}
