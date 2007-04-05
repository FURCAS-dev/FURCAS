/**
 * <copyright>
 * 
 * Copyright (c) 2007 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: KeywordsTest.java,v 1.1 2007/04/05 20:35:50 cdamus Exp $
 */

package org.eclipse.ocl.uml.tests;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.ocl.expressions.Variable;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLFactory;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * Tests for usages of model features whose names coincide with "keywords"
 * defined by the LPG grammar but not as reserved words by the OCL spec, or that
 * conflict with OCL reserved words.
 *
 * @author Christian W. Damus (cdamus)
 */
public class KeywordsTest
	extends AbstractTestSuite {

    private Resource res;
    
    private Package smalltalk;
    private Class collection;
    private Class block;
    
	public KeywordsTest(String name) {
		super(name);
	}
	
	public static Test suite() {
		return new TestSuite(KeywordsTest.class, "LPG Keyword Tests"); //$NON-NLS-1$
	}
	
	public void test_isUnique_162300() {
		helper.setContext(getMetaclass("Property")); //$NON-NLS-1$
		
		try {
			helper.createInvariant("self.isUnique implies self.upper > 1"); //$NON-NLS-1$
            helper.createInvariant("isUnique implies self.upper > 1"); //$NON-NLS-1$
		} catch (Exception e) {
			fail("Failed to parse: " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
	}
    
    public void test_package_162300() {
        helper.setContext(getMetaclass("Class")); //$NON-NLS-1$
        
        try {
            helper.createInvariant(
                "self.package.oclIsUndefined() implies Set{VisibilityKind::protected, VisibilityKind::package}->excludes(self.visibility)"); //$NON-NLS-1$
            helper.createInvariant(
                "package.oclIsUndefined() implies Set{VisibilityKind::protected, VisibilityKind::package}->excludes(self.visibility)"); //$NON-NLS-1$
        } catch (Exception e) {
            fail("Failed to parse: " + e.getLocalizedMessage()); //$NON-NLS-1$
        }
    }
    
    public void test_context_162300() {
        helper.setContext(getMetaclass("Constraint")); //$NON-NLS-1$
        
        try {
            helper.createInvariant("self.context <> null implies context.oclIsKindOf(Classifier)"); //$NON-NLS-1$
            helper.createInvariant("context <> null implies self.context.oclIsKindOf(Classifier)"); //$NON-NLS-1$
        } catch (Exception e) {
            fail("Failed to parse: " + e.getLocalizedMessage()); //$NON-NLS-1$
        }
    }
    
    public void test_isUniqueOperation_162300() {
        helper.setContext(collection);
        
        Variable<Classifier, Parameter> var = ocl.getEnvironment().getOCLFactory().createVariable();
        var.setName("aBlock"); //$NON-NLS-1$
        var.setType(block);
        
        ocl.getEnvironment().addElement(var.getName(), var, true);
        
        try {
            helper.createInvariant("self.isUnique(aBlock)"); //$NON-NLS-1$
            helper.createInvariant("isUnique(aBlock)"); //$NON-NLS-1$
        } catch (Exception e) {
            fail("Failed to parse: " + e.getLocalizedMessage()); //$NON-NLS-1$
        }
    }
    
    public void test_selectOperation_162300() {
        helper.setContext(collection);
        
        Variable<Classifier, Parameter> var = ocl.getEnvironment().getOCLFactory().createVariable();
        var.setName("aBlock"); //$NON-NLS-1$
        var.setType(block);
        
        ocl.getEnvironment().addElement(var.getName(), var, true);
        
        try {
            helper.createInvariant("self.select(aBlock).isEmpty()"); //$NON-NLS-1$
            helper.createInvariant("select(aBlock).isEmpty()"); //$NON-NLS-1$
        } catch (Exception e) {
            fail("Failed to parse: " + e.getLocalizedMessage()); //$NON-NLS-1$
        }
    }
    
    public void test_contextOperation_162300() {
        helper.setContext(block);
        
        try {
            helper.createInvariant("self.context(self).name = 'Block'"); //$NON-NLS-1$
            helper.createInvariant("context(self).name = 'Block'"); //$NON-NLS-1$
        } catch (Exception e) {
            fail("Failed to parse: " + e.getLocalizedMessage()); //$NON-NLS-1$
        }
    }
    
    //
    // Framework methods
    //
    
    @Override
    protected void setUp()
        throws Exception {
        
        super.setUp();
        
        // create a little test model for a Smalltalk-like collection class that
        //    defines operations corresponding to OCL iterators
        
        res = new ResourceImpl(URI.createURI("foo://uml")); //$NON-NLS-1$
        
        smalltalk = UMLFactory.eINSTANCE.createPackage();
        smalltalk.setName("Smalltalk"); //$NON-NLS-1$
        
        res.getContents().add(smalltalk);
        
        Class object = smalltalk.createOwnedClass("Object", false); //$NON-NLS-1$
        collection = smalltalk.createOwnedClass("Collection", false); //$NON-NLS-1$
        block = smalltalk.createOwnedClass("Block", false); //$NON-NLS-1$
        Class clazz = smalltalk.createOwnedClass("Class", false); //$NON-NLS-1$
        
        clazz.createGeneralization(object);
        block.createGeneralization(object);
        collection.createGeneralization(object);
        
        clazz.createOwnedAttribute("name", getUMLString()); //$NON-NLS-1$
        
        EList<String> names = new BasicEList<String>(1);
        EList<Type> types = new BasicEList<Type>(1);
        
        names.add("object"); //$NON-NLS-1$
        types.add(object);
        block.createOwnedOperation("context", names, types, clazz).setIsQuery(true); //$NON-NLS-1$
        
        names.set(0, "block"); //$NON-NLS-1$
        types.set(0, block);
        collection.createOwnedOperation("isUnique", names, types, getUMLBoolean()).setIsQuery(true); //$NON-NLS-1$
        collection.createOwnedOperation("select", names, types, collection).setIsQuery(true); //$NON-NLS-1$
        
        names.clear();
        types.clear();
        collection.createOwnedOperation("isEmpty", names, types, getUMLBoolean()).setIsQuery(true); //$NON-NLS-1$
    }
    
    @Override
    protected void tearDown()
        throws Exception {
        
        smalltalk = null;
        collection = null;
        block = null;
        
        res.unload();
        res = null;
        
        super.tearDown();
    }
}
