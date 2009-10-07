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
 * $Id: KeywordsTest.java,v 1.6 2009/10/07 20:41:45 ewillink Exp $
 */

package org.eclipse.ocl.uml.tests;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.ocl.OCLInput;
import org.eclipse.ocl.expressions.Variable;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.State;
import org.eclipse.uml2.uml.StateMachine;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * Tests for usages of model features whose names coincide with "keywords"
 * defined as reserved words by the OCL specification and/or by the LPG grammar.
 *
 * @author Christian W. Damus (cdamus)
 */
public class KeywordsTest
	extends AbstractTestSuite {

    Resource res;    
    Package smalltalk;
    Class collection;
    Class block;
    Class elseClass;
	
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
                "self._package.oclIsUndefined() implies Set{VisibilityKind::protected, VisibilityKind::_package}->excludes(self.visibility)"); //$NON-NLS-1$
            helper.createInvariant(
                "_package.oclIsUndefined() implies Set{VisibilityKind::protected, VisibilityKind::_package}->excludes(self.visibility)"); //$NON-NLS-1$
        } catch (Exception e) {
            fail("Failed to parse: " + e.getLocalizedMessage()); //$NON-NLS-1$
        }
    }
    
    public void test_context_162300() {
        helper.setContext(getMetaclass("Constraint")); //$NON-NLS-1$
        
        try {
            helper.createInvariant("self._context <> null implies _context.oclIsKindOf(Classifier)"); //$NON-NLS-1$
            helper.createInvariant("_context <> null implies self._context.oclIsKindOf(Classifier)"); //$NON-NLS-1$
        } catch (Exception e) {
            fail("Failed to parse: " + e.getLocalizedMessage()); //$NON-NLS-1$
        }
    }
    
    public void test_body_162300() {
        helper.setContext(getMetaclass("OpaqueExpression")); //$NON-NLS-1$
        
        try {
            helper.createInvariant("self.language->includes('OCL') implies self._body->notEmpty()"); //$NON-NLS-1$
            helper.createInvariant("language->includes('OCL') implies _body->notEmpty()"); //$NON-NLS-1$
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
            helper.createInvariant("self._context(self).name = 'Block'"); //$NON-NLS-1$
            helper.createInvariant("_context(self).name = 'Block'"); //$NON-NLS-1$
        } catch (Exception e) {
            fail("Failed to parse: " + e.getLocalizedMessage()); //$NON-NLS-1$
        }
    }
    
    public void test_reservedPackageName_183362() {
        helper.setContext(block);
        
        try {
            helper.createInvariant(
                "Smalltalk::runtime::_context::language.allInstances()->notEmpty()"); //$NON-NLS-1$
        } catch (Exception e) {
            fail("Failed to parse: " + e.getLocalizedMessage()); //$NON-NLS-1$
        }
    }
    
    public void test_reservedPackageName_packageContext_183362() {
        try {
            ocl.parse(new OCLInput(
                "package Smalltalk::runtime::_context context language inv: true endpackage")); //$NON-NLS-1$
        } catch (Exception e) {
            fail("Failed to parse: " + e.getLocalizedMessage()); //$NON-NLS-1$
        }
    }
    
    public void test_reservedClassName_183362() {
        helper.setContext(elseClass);
        
        try {
            helper.createInvariant(
                "let e : _else = self in _else.allInstances()->forAll(oclIsKindOf(_else))"); //$NON-NLS-1$
        } catch (Exception e) {
            fail("Failed to parse: " + e.getLocalizedMessage()); //$NON-NLS-1$
        }
        
        try {
            helper.createInvariant(
                "self.oclIsKindOf(_context::_else)"); //$NON-NLS-1$
        } catch (Exception e) {
            fail("Failed to parse: " + e.getLocalizedMessage()); //$NON-NLS-1$
        }
    }
    
    public void test_reservedClassName_operationContext_183362() {
        try {
            ocl.parse(new OCLInput(
                "package Smalltalk context runtime::_context::_else::doIt() : pre: true endpackage")); //$NON-NLS-1$
            ocl.parse(new OCLInput(
                "package Smalltalk::runtime::_context context _else::doIt() : pre: true endpackage")); //$NON-NLS-1$
        } catch (Exception e) {
            fail("Failed to parse: " + e.getLocalizedMessage()); //$NON-NLS-1$
        }
    }
    
    public void test_reservedStateName_183362() {
        helper.setContext(elseClass);
        
        try {
            helper.createInvariant(
                "not self.oclIsInState(_init::_body)"); //$NON-NLS-1$
        } catch (Exception e) {
            fail("Failed to parse: " + e.getLocalizedMessage()); //$NON-NLS-1$
        }
    }
    
    //
    // Framework methods
    //
    
    @Override
    protected void setUp() {
        
        super.setUp();
        
        // create a little test model for a Smalltalk-like collection class that
        //    defines operations corresponding to OCL iterators
        
        res = new ResourceImpl(URI.createURI("foo://uml")); //$NON-NLS-1$
        resourceSet.getResources().add(res);
        
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
        
        // create some qualified classifier and package names that need
        //    escaping of one or more segments.  Likewise state names
        Package contextPackage = smalltalk.createNestedPackage("runtime") //$NON-NLS-1$
            .createNestedPackage("context"); //$NON-NLS-1$
        contextPackage.createOwnedClass("language", false); //$NON-NLS-1$
        elseClass = contextPackage.createOwnedClass("else", false); //$NON-NLS-1$
        
        elseClass.createOwnedOperation("doIt", null, null); //$NON-NLS-1$
        
        StateMachine machine = (StateMachine) elseClass.createOwnedBehavior(
            "StateMachine", UMLPackage.Literals.STATE_MACHINE); //$NON-NLS-1$
        State state = (State) machine.createRegion("region").createSubvertex( //$NON-NLS-1$
            "init", UMLPackage.Literals.STATE); //$NON-NLS-1$
        state.createRegion("region").createSubvertex("body", //$NON-NLS-1$ //$NON-NLS-2$
            UMLPackage.Literals.STATE);
    }
}
