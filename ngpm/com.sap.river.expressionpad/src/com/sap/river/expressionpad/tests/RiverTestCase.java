package com.sap.river.expressionpad.tests;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import junit.framework.TestCase;

import com.sap.river.expressionpad.Main;
import com.sap.river.interpreter.objects.NativeObject;
import com.sap.river.interpreter.objects.RiverObject;
import com.sap.river.interpreter.repository.Repository;
import com.sap.river.interpreter.repository.simpleimpl.InMemoryRepository;

public abstract class RiverTestCase extends TestCase {

    protected Main main;

    protected void setUp() throws Exception {
        super.setUp();
        main = new Main("ngpm.stdlib", createRepository());
    }
    
    /**
     * Factory method for repository used by interpreters. This implementation
     * returns the default {@link InMemoryRepository} implementation.
     */
    protected Repository createRepository() {
	return new InMemoryRepository();
    }
    
    public void assertNOEquals(Object expected, RiverObject riverObject) {
	assertTrue(riverObject instanceof NativeObject);
	NativeObject no = (NativeObject) riverObject;
	assertEquals(expected, no.getNativeObject());
    }

    protected void assertMultiObjectOfNativeObjectsEqualsIgnoringOrdering(Object[] expected, RiverObject multiObjectOfNativeObjects) {
        Set<Object> found = new HashSet<Object>();
        assertEquals("Expected same size of "+multiObjectOfNativeObjects+" and "+expected+" but were "+
        	multiObjectOfNativeObjects.size()+" and "+expected.length+", respectively",
        	multiObjectOfNativeObjects.size(), expected.length);
        for (RiverObject o : multiObjectOfNativeObjects) {
            if (o.size() > 0) { // not empty object?
        	found.add(((NativeObject) o).getNativeObject());
            }
        }
        assertEquals(new HashSet<Object>(Arrays.asList(expected)), found);
    }

}
