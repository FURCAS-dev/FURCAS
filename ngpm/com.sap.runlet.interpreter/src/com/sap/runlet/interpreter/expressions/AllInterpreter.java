package com.sap.runlet.interpreter.expressions;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;

import persistence.expressions.All;
import persistence.expressions.SnapshotSelection;
import behavioral.actions.Statement;

import com.sap.ap.metamodel.utils.MetamodelUtils;
import com.sap.runlet.abstractinterpreter.Interpreter;
import com.sap.runlet.abstractinterpreter.objects.EmptyObject;
import com.sap.runlet.abstractinterpreter.objects.EntityObject;
import com.sap.runlet.abstractinterpreter.objects.RunletObject;
import com.sap.runlet.abstractinterpreter.repository.FixedSnapshot;
import com.sap.runlet.abstractinterpreter.repository.Snapshot;
import com.sap.runlet.abstractinterpreter.repository.SnapshotIdentifier;
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

public class AllInterpreter implements Interpreter<All, SapClass, TypeDefinition, ClassTypeDefinition, Association, AssociationEnd, Statement, Expression, SignatureImplementation, RunletStackFrame, NativeImpl, RunletInterpreter> {
    private All all;
    
    public AllInterpreter(All all) {
	this.all = all;
    }

    @Override
    public RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> evaluate(RunletInterpreter interpreter) throws SecurityException,
	    IllegalArgumentException, NoSuchMethodException, InstantiationException,
	    IllegalAccessException, InvocationTargetException {
	SnapshotSelection snapshotSelection = all.getSnapshot();
	Iterable<EntityObject<Association, AssociationEnd, SapClass, TypeDefinition, ClassTypeDefinition>> result;
	
	if (snapshotSelection.equals(SnapshotSelection.DEFAULT)) {
	    // retrieve all instances of HEAD snapshot
	    result = interpreter.all(all.getOfClass(), interpreter.getDefaultSnapshot());
	} else if (snapshotSelection.equals(SnapshotSelection.SPECIFIED)) {
	    // retrieve all instances at Snapshot / before or at TimePoint
	    NativeObject snapshotIdentifier = (NativeObject) interpreter.evaluate(all
		    .getSnapshotIdentifier());
	    SapClass clazz = snapshotIdentifier.getType().getClazz();
	    if (clazz.equals(MetamodelUtils.findClass(interpreter.getResourceSet(), "Snapshot"))) {
		SnapshotIdentifier si = new FixedSnapshot((Snapshot)snapshotIdentifier.getNativeObject());
		result = interpreter.all(all.getOfClass(), si);
	    } else if (clazz.equals(MetamodelUtils.findClass(interpreter.getResourceSet(), "TimePoint"))) {
		result = interpreter.all(all.getOfClass(), (Date)snapshotIdentifier.getNativeObject() );
	    } else {
		// be robust - a Constraint Violation will be reported because of the wrong type of the expression 
		result = null;
	    }
	} else if (snapshotSelection.equals(SnapshotSelection.CHANGED)) {
	    // retrieve all changed instances from all snapshots 
	    result = interpreter.allChanged(all.getOfClass());
	} else if (snapshotSelection.equals(SnapshotSelection.ALL)) {
	    // retrieve all instances from all snapshots
	    result = interpreter.all(all.getOfClass());
	} else {
	    throw new RuntimeException("Unknown snapshot selection: "+snapshotSelection.toString());
	}
	if (result == null) {
	    return new EmptyObject<AssociationEnd, SapClass, TypeDefinition, ClassTypeDefinition>(all.getType(), interpreter.getModelAdapter());
	} else {
	    return RunletInterpreter.getRunletObjectFromIterable(all.getType(), result, interpreter.getModelAdapter(),
		    all.getType().isOrdered(), all.getType().isUnique());
	}
    }
}
