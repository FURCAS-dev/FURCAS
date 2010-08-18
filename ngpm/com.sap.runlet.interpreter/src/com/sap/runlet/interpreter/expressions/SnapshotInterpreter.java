package com.sap.runlet.interpreter.expressions;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import persistence.expressions.Snapshot;
import behavioral.actions.Statement;

import com.sap.runlet.abstractinterpreter.Interpreter;
import com.sap.runlet.abstractinterpreter.objects.ClassTypedObject;
import com.sap.runlet.abstractinterpreter.objects.EmptyObject;
import com.sap.runlet.abstractinterpreter.objects.RunletObject;
import com.sap.runlet.interpreter.RunletInterpreter;
import com.sap.runlet.interpreter.RunletStackFrame;
import com.sap.runlet.interpreter.objects.NativeObject;

import data.classes.Association;
import data.classes.AssociationEnd;
import data.classes.ClassTypeDefinition;
import data.classes.NativeImpl;
import data.classes.SapClass;
import data.classes.SignatureImplementation;
import data.classes.TypeDefinition;
import dataaccess.expressions.Expression;

public class SnapshotInterpreter implements Interpreter<Snapshot, SapClass, TypeDefinition, ClassTypeDefinition, Association, AssociationEnd, Statement, Expression, SignatureImplementation, RunletStackFrame, NativeImpl, RunletInterpreter> {

    private Snapshot snapshotExpr;

    public SnapshotInterpreter(Snapshot snapshot) {
	snapshotExpr = snapshot;
    }

    @Override
    public RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> evaluate(RunletInterpreter interpreter) throws SecurityException,
	    IllegalArgumentException, JmiException, NoSuchMethodException, InstantiationException,
	    IllegalAccessException, InvocationTargetException {
	RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> object = interpreter.evaluate(snapshotExpr.getObject());
	RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> result = null;
	
	if (object.getType().isMany()) {
	    // iterate in case of MultiObjects
	    Collection<RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>> objectCollection = RunletObject.createCollection(snapshotExpr.getType()
			.isOrdered(), snapshotExpr.getType().isUnique());
	    for (RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> riverObject : object.flatten()) {
		com.sap.runlet.abstractinterpreter.repository.Snapshot snapshot = ((ClassTypedObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>) riverObject)
			.getOrigin().getSnapshot();
		objectCollection.add(wrapSnapshot(snapshot, interpreter));
	    }
	    result = RunletInterpreter.getRunletObjectFromIterable(snapshotExpr.getType(), objectCollection,
		    interpreter.getModelAdapter(), snapshotExpr.getType().isOrdered(), snapshotExpr.getType().isUnique());
	} else {
	    // wrap Snapshot in case of single object
	    com.sap.runlet.abstractinterpreter.repository.Snapshot snapshot = ((ClassTypedObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>) object)
		.getOrigin().getSnapshot();
	    result = wrapSnapshot(snapshot, interpreter);
	}
	assert result != null;
	return result;
    }
    
    /**
     * Wraps a {@link com.sap.runlet.abstractinterpreter.repository.Snapshot} object into a RiverObject. 
     * If snapshot is <code>null</code> an EmptyObject will be returned.
     * @param snapshot
     * @param interpreter
     * @return
     */
    private RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> wrapSnapshot(com.sap.runlet.abstractinterpreter.repository.Snapshot snapshot, RunletInterpreter interpreter) {
	// FIXME: identify transient / new / not yet committed snapshot
	if (snapshot == null) {
	    return new EmptyObject<AssociationEnd, SapClass, TypeDefinition, ClassTypeDefinition>(snapshotExpr.getType(), interpreter.getModelAdapter());
	} else {
	    return new NativeObject((ClassTypeDefinition) snapshotExpr
		    .getOwnedTypeDefinition(), snapshot, interpreter.getDefaultSnapshot(), interpreter);
	}
    }

}
