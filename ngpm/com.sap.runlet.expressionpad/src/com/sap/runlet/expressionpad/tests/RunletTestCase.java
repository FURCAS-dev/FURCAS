package com.sap.runlet.expressionpad.tests;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import junit.framework.TestCase;

import com.sap.runlet.abstractinterpreter.objects.RunletObject;
import com.sap.runlet.abstractinterpreter.repository.Repository;
import com.sap.runlet.expressionpad.RunletEvaluator;
import com.sap.runlet.interpreter.Activator;
import com.sap.runlet.interpreter.objects.NativeObject;
import com.sap.runlet.interpreter.repository.simpleimpl.RunletInMemoryRepository;

import data.classes.Association;
import data.classes.AssociationEnd;
import data.classes.ClassTypeDefinition;
import data.classes.SapClass;
import data.classes.TypeDefinition;

public abstract class RunletTestCase extends TestCase {

    protected RunletEvaluator main;

    protected void setUp() throws Exception {
        super.setUp();
        main = new RunletEvaluator("ngpm.stdlib", createRepository());
    }
    
    /**
     * Factory method for repository used by interpreters. This implementation
     * returns the default {@link RunletInMemoryRepository} implementation.
     */
    protected Repository<Association, AssociationEnd, SapClass, TypeDefinition, ClassTypeDefinition> createRepository() {
	return new RunletInMemoryRepository(Activator.getDefault().getModelAdapter());
    }
    
    public void assertNOEquals(Object expected, RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> riverObject) {
	assertTrue(riverObject instanceof NativeObject);
	NativeObject no = (NativeObject) riverObject;
	assertEquals(expected, no.getNativeObject());
    }

    protected void assertMultiObjectOfNativeObjectsEqualsIgnoringOrdering(Object[] expected, RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> multiObjectOfNativeObjects) {
        Set<Object> found = new HashSet<Object>();
        assertEquals("Expected same size of "+multiObjectOfNativeObjects+" and "+expected+" but were "+
        	multiObjectOfNativeObjects.size()+" and "+expected.length+", respectively",
        	multiObjectOfNativeObjects.size(), expected.length);
        for (RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> o : multiObjectOfNativeObjects) {
            if (o.size() > 0) { // not empty object?
        	found.add(((NativeObject) o).getNativeObject());
            }
        }
        assertEquals(new HashSet<Object>(Arrays.asList(expected)), found);
    }

}
