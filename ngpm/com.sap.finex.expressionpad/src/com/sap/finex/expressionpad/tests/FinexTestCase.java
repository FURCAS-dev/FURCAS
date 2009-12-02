package com.sap.finex.expressionpad.tests;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import junit.framework.TestCase;
import structure.Association;
import structure.Field;
import structure.FinexClass;
import structure.Type;

import com.sap.finex.expressionpad.FinexEvaluator;
import com.sap.finex.interpreter.Activator;
import com.sap.finex.interpreter.FinexInMemoryRepository;
import com.sap.finex.interpreter.objects.FinexNativeObject;
import com.sap.runlet.abstractinterpreter.objects.RunletObject;
import com.sap.runlet.abstractinterpreter.repository.Repository;

public abstract class FinexTestCase extends TestCase {

    protected FinexEvaluator main;

    protected void setUp() throws Exception {
        super.setUp();
        main = new FinexEvaluator("finex.stdlib", createRepository());
    }
    
    /**
     * Factory method for repository used by interpreters. This implementation
     * returns the default {@link RunletInMemoryRepository} implementation.
     */
    protected Repository<Association, Field, FinexClass, Type, FinexClass> createRepository() {
	return new FinexInMemoryRepository(Activator.getDefault().getModelAdapter());
    }
    
    public void assertNOEquals(Object expected, RunletObject<Field, Type, FinexClass> runletObject) {
	assertTrue(runletObject instanceof FinexNativeObject);
	FinexNativeObject no = (FinexNativeObject) runletObject;
	assertEquals(expected, no.getNativeObject());
    }

    protected void assertMultiObjectOfNativeObjectsEqualsIgnoringOrdering(Object[] expected, RunletObject<Field, Type, FinexClass> multiObjectOfNativeObjects) {
        Set<Object> found = new HashSet<Object>();
        assertEquals("Expected same size of "+multiObjectOfNativeObjects+" and "+expected+" but were "+
        	multiObjectOfNativeObjects.size()+" and "+expected.length+", respectively",
        	expected.length, multiObjectOfNativeObjects.size());
        for (RunletObject<Field, Type, FinexClass> o : multiObjectOfNativeObjects) {
            if (o.size() > 0) { // not empty object?
        	found.add(((FinexNativeObject) o).getNativeObject());
            }
        }
        assertEquals(new HashSet<Object>(Arrays.asList(expected)), found);
    }

}
