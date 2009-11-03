package com.sap.river.interpreter.expressions;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import com.sap.tc.moin.repository.mmi.reflect.JmiException;

import persistence.expressions.Snapshot;

import com.sap.river.interpreter.Interpreter;
import com.sap.river.interpreter.RiverInterpreter;
import com.sap.river.interpreter.objects.ClassTypedObject;
import com.sap.river.interpreter.objects.EmptyObject;
import com.sap.river.interpreter.objects.NativeObject;
import com.sap.river.interpreter.objects.RiverObject;

import data.classes.ClassTypeDefinition;

public class SnapshotInterpreter implements Interpreter<Snapshot> {

    private Snapshot snapshotExpr;

    public SnapshotInterpreter(Snapshot snapshot) {
	snapshotExpr = snapshot;
    }

    @Override
    public RiverObject evaluate(RiverInterpreter interpreter) throws SecurityException,
	    IllegalArgumentException, JmiException, NoSuchMethodException, InstantiationException,
	    IllegalAccessException, InvocationTargetException {
	RiverObject object = interpreter.evaluate(snapshotExpr.getObject());
	RiverObject result = null;
	
	if (object.getType().isMany()) {
	    // iterate in case of MultiObjects
	    Collection<RiverObject> objectCollection = RiverObject.createCollection(snapshotExpr.getType()
			.isOrdered(), snapshotExpr.getType().isUnique());
	    for (RiverObject riverObject : object.flatten()) {
		com.sap.river.interpreter.repository.Snapshot snapshot = ((ClassTypedObject) riverObject)
			.getOrigin().getSnapshot();
		objectCollection.add(wrapSnapshot(snapshot, interpreter));
	    }
	    result = RiverInterpreter.getRiverObjectFromIterable(snapshotExpr.getType(), objectCollection);
	} else {
	    // wrap Snapshot in case of single object
	    com.sap.river.interpreter.repository.Snapshot snapshot = ((ClassTypedObject) object)
		.getOrigin().getSnapshot();
	    result = wrapSnapshot(snapshot, interpreter);
	}
	assert result != null;
	return result;
    }
    
    /**
     * Wraps a {@link com.sap.river.interpreter.repository.Snapshot} object into a RiverObject. 
     * If snapshot is <code>null</code> an EmptyObject will be returned.
     * @param snapshot
     * @param interpreter
     * @return
     */
    private RiverObject wrapSnapshot(com.sap.river.interpreter.repository.Snapshot snapshot, RiverInterpreter interpreter) {
	// FIXME: identify transient / new / not yet committed snapshot
	if (snapshot == null) {
	    return new EmptyObject(snapshotExpr.getType());
	} else {
	    return new NativeObject((ClassTypeDefinition) snapshotExpr
		    .getOwnedTypeDefinition(), snapshot, interpreter.getDefaultSnapshot(), interpreter);
	}
    }

}
