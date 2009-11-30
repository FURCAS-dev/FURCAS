package com.sap.finex.interpreter;

import java.util.Collection;
import java.util.Iterator;

import structure.Field;
import structure.FinexClass;
import structure.Type;

import com.sap.runlet.abstractinterpreter.objects.MultiValuedObject;
import com.sap.runlet.abstractinterpreter.objects.RunletObject;

public class ConcatRunletObjectIterable
implements Iterable<com.sap.runlet.abstractinterpreter.objects.RunletObject<Field, Type, FinexClass>> {
    private final Iterator<RunletObject<Field, Type, FinexClass>> flatteningIterator;
    
    public ConcatRunletObjectIterable(Collection<RunletObject<Field, Type, FinexClass>> objectsToConcatenate) {
	flatteningIterator = new MultiValuedObject<Field, Type, FinexClass>(
		objectsToConcatenate.iterator().next().getType(),
		objectsToConcatenate, /* ordered */ false, /* unique */ false).flatten().iterator();
    }
    
    @Override
    public Iterator<RunletObject<Field, Type, FinexClass>> iterator() {
	return flatteningIterator;
    }
}
