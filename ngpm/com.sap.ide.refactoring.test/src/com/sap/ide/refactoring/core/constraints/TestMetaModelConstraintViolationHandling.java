package com.sap.ide.refactoring.core.constraints;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Collection;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sap.ide.refactoring.test.RefactoringBaseTest;

import data.classes.SapClass;

public class TestMetaModelConstraintViolationHandling extends RefactoringBaseTest {

    /**
     * System under test
     */
    private MetaModelConstraintRegistry registry;
    
    @Before
    public void setupInvalidationListeners() {
	registry = new MetaModelConstraintRegistry(connection);
	registry.registerAllMetaModelConstraintsForIncrementalEvaluation(new NullProgressMonitor());
    }
    
    @After
    public void tearDownListeners() {
	registry.deregisterRegisteredMetaModelConstraintListeners(new NullProgressMonitor());
    }

    @Test
    public void testRenameTriggeringAnInvalidation() throws Exception {
	SapClass clazz = findRunletClass("Class1");

	// same name; nothing should happen at all
	clazz.setName("Class1"); 
	Collection<ConstraintViolation> violations = registry.evaluateConstraints(new NullProgressMonitor());
	assertTrue(violations.isEmpty());
	
	// name that will not trigger a conflict
	clazz.setName("SomeNameThatIsProbablyUsedNoWhereElse");
	violations = registry.evaluateConstraints(new NullProgressMonitor());
	assertTrue(violations.isEmpty());
	
	clazz.setName("Class2");
	violations = registry.evaluateConstraints(new NullProgressMonitor());
	assertEquals("There must be clashing class names", 1, violations.size());
	ConstraintViolation violation = violations.iterator().next();
	assertEquals("[modelmanagement, Package, DistinctClassNamesPerPackage]",
		violation.registration.getName());
    }

    /**
     * Same testcase as above. Just run a second time to be able to
     * see the correct timings with a warm cache (e.g., without the
     * path construction times)
     * 
     * @throws Exception
     */
    @Test
    public void testRenameTriggeringAnInvalidation2() throws Exception {
	SapClass clazz = findRunletClass("Class1");

	// same name; nothing should happen at all
	clazz.setName("Class1"); 
	Collection<ConstraintViolation> violations = registry.evaluateConstraints(new NullProgressMonitor());
	assertTrue(violations.isEmpty());
	
	// name that will not trigger a conflict
	clazz.setName("SomeNameThatIsProbablyUsedNoWhereElse");
	violations = registry.evaluateConstraints(new NullProgressMonitor());
	assertTrue(violations.isEmpty());
	
	clazz.setName("Class2");
	violations = registry.evaluateConstraints(new NullProgressMonitor());
	assertEquals("There must be clashing class names", 1, violations.size());
	ConstraintViolation violation = violations.iterator().next();
	assertEquals("[modelmanagement, Package, DistinctClassNamesPerPackage]",
		violation.registration.getName());
    }
    
    @Test
    public void testTemporaryInValidation() throws Exception {
	SapClass clazz = findRunletClass("Class1");
	
	clazz.setName("Class2");  // invalidation
	clazz.setName("SomeNameThatIsProbablyUsedNoWhereElse");
	
	Collection<ConstraintViolation> violations = registry.evaluateConstraints(new NullProgressMonitor());
	assertTrue("There should be no final invalidation", violations.isEmpty());
	
    }
}
