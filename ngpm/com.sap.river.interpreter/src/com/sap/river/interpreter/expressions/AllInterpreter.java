package com.sap.river.interpreter.expressions;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;

import com.sap.tc.moin.repository.mmi.reflect.JmiException;

import persistence.expressions.All;
import persistence.expressions.SnapshotSelection;
import persistence.expressions.SnapshotSelectionEnum;

import com.sap.river.interpreter.Interpreter;
import com.sap.river.interpreter.RiverInterpreter;
import com.sap.river.interpreter.objects.EmptyObject;
import com.sap.river.interpreter.objects.EntityObject;
import com.sap.river.interpreter.objects.NativeObject;
import com.sap.river.interpreter.objects.RiverObject;
import com.sap.river.interpreter.repository.Snapshot;
import com.sap.river.interpreter.repository.SnapshotIdentifier;
import com.sap.river.interpreter.repository.simpleimpl.FixedSnapshot;

import data.classes.SapClass;

public class AllInterpreter implements Interpreter<All> {
    private All all;
    
    public AllInterpreter(All all) {
	this.all = all;
    }

    @Override
    public RiverObject evaluate(RiverInterpreter interpreter) throws SecurityException,
	    IllegalArgumentException, JmiException, NoSuchMethodException, InstantiationException,
	    IllegalAccessException, InvocationTargetException {
	SnapshotSelection snapshotSelection = all.getSnapshot();
	Iterable<EntityObject> result;
	
	if (snapshotSelection.equals(SnapshotSelectionEnum.DEFAULT)) {
	    // retrieve all instances of HEAD snapshot
	    result = interpreter.all(all.getOfClass(), interpreter.getDefaultSnapshot());
	} else if (snapshotSelection.equals(SnapshotSelectionEnum.SPECIFIED)) {
	    // retrieve all instances at Snapshot / before or at TimePoint
	    NativeObject snapshotIdentifier = (NativeObject) interpreter.evaluate(all
		    .getSnapshotIdentifier());
	    SapClass clazz = snapshotIdentifier.getType().getClazz();
	    if (clazz.equals(interpreter.findClass("Snapshot"))) {
		SnapshotIdentifier si = new FixedSnapshot((Snapshot)snapshotIdentifier.getNativeObject());
		result = interpreter.all(all.getOfClass(), si);
	    } else if (clazz.equals(interpreter.findClass("TimePoint"))) {
		result = interpreter.all(all.getOfClass(), (Date)snapshotIdentifier.getNativeObject() );
	    } else {
		// be robust - a Constraint Violation will be reported because of the wrong type of the expression 
		result = null;
	    }
	} else if (snapshotSelection.equals(SnapshotSelectionEnum.CHANGED)) {
	    // retrieve all changed instances from all snapshots 
	    result = interpreter.allChanged(all.getOfClass());
	} else if (snapshotSelection.equals(SnapshotSelectionEnum.ALL)) {
	    // retrieve all instances from all snapshots
	    result = interpreter.all(all.getOfClass());
	} else {
	    throw new RuntimeException("Unknown snapshot selection: "+snapshotSelection.toString());
	}
	if (result == null) {
	    return new EmptyObject(all.getType());
	} else {
	    return RiverInterpreter.getRiverObjectFromIterable(all.getType(), result);
	}
    }
}
