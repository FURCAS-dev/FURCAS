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
 * $Id: KeywordsTest.java,v 1.7 2009/11/28 18:07:24 ewillink Exp $
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
@SuppressWarnings("nls")
public class KeywordsTest
	extends AbstractTestSuite {

    Resource res;    
    Package smalltalk;
    Class collection;
    Class block;
    Class elseClass;
	
	public void test_isUnique_162300() {
		helper.setContext(getMetaclass("Property"));
		
		try {
			helper.createInvariant("self.isUnique implies self.upper > 1");
            helper.createInvariant("isUnique implies self.upper > 1");
		} catch (Exception e) {
			fail("Failed to parse: " + e.getLocalizedMessage());
		}
	}
    
	public void test_package_162300() {
        helper.setContext(getMetaclass("Class"));
        
        try {
            helper.createInvariant(
                "self._package.oclIsUndefined() implies Set{VisibilityKind::protected, VisibilityKind::_package}->excludes(self.visibility)");
            helper.createInvariant(
                "_package.oclIsUndefined() implies Set{VisibilityKind::protected, VisibilityKind::_package}->excludes(self.visibility)");
        } catch (Exception e) {
            fail("Failed to parse: " + e.getLocalizedMessage());
        }
    }
    
    public void test_context_162300() {
        helper.setContext(getMetaclass("Constraint"));
        
        try {
            helper.createInvariant("self._context <> null implies _context.oclIsKindOf(Classifier)");
            helper.createInvariant("_context <> null implies self._context.oclIsKindOf(Classifier)");
        } catch (Exception e) {
            fail("Failed to parse: " + e.getLocalizedMessage());
        }
    }
    
    public void test_body_162300() {
        helper.setContext(getMetaclass("OpaqueExpression"));
        
        try {
            helper.createInvariant("self.language->includes('OCL') implies self._body->notEmpty()");
            helper.createInvariant("language->includes('OCL') implies _body->notEmpty()");
        } catch (Exception e) {
            fail("Failed to parse: " + e.getLocalizedMessage());
        }
    }
    
    public void test_isUniqueOperation_162300() {
        helper.setContext(collection);
        
        Variable<Classifier, Parameter> var = ocl.getEnvironment().getOCLFactory().createVariable();
        var.setName("aBlock");
        var.setType(block);
        
        ocl.getEnvironment().addElement(var.getName(), var, true);
        
        try {
            helper.createInvariant("self.isUnique(aBlock)");
            helper.createInvariant("isUnique(aBlock)");
        } catch (Exception e) {
            fail("Failed to parse: " + e.getLocalizedMessage());
        }
    }
    
    public void test_selectOperation_162300() {
        helper.setContext(collection);
        
        Variable<Classifier, Parameter> var = ocl.getEnvironment().getOCLFactory().createVariable();
        var.setName("aBlock");
        var.setType(block);
        
        ocl.getEnvironment().addElement(var.getName(), var, true);
        
        try {
            helper.createInvariant("self.select(aBlock).isEmpty()");
            helper.createInvariant("select(aBlock).isEmpty()");
        } catch (Exception e) {
            fail("Failed to parse: " + e.getLocalizedMessage());
        }
    }
    
    public void test_contextOperation_162300() {
        helper.setContext(block);
        
        try {
            helper.createInvariant("self._context(self).name = 'Block'");
            helper.createInvariant("_context(self).name = 'Block'");
        } catch (Exception e) {
            fail("Failed to parse: " + e.getLocalizedMessage());
        }
    }
    
    public void test_reservedPackageName_183362() {
        helper.setContext(block);
        
        try {
            helper.createInvariant(
                "Smalltalk::runtime::_context::language.allInstances()->notEmpty()");
        } catch (Exception e) {
            fail("Failed to parse: " + e.getLocalizedMessage());
        }
    }
    
    public void test_reservedPackageName_packageContext_183362() {
        try {
            ocl.parse(new OCLInput(
                "package Smalltalk::runtime::_context context language inv: true endpackage"));
        } catch (Exception e) {
            fail("Failed to parse: " + e.getLocalizedMessage());
        }
    }
    
    public void test_reservedClassName_183362() {
        helper.setContext(elseClass);
        
        try {
            helper.createInvariant(
                "let e : _else = self in _else.allInstances()->forAll(oclIsKindOf(_else))");
        } catch (Exception e) {
            fail("Failed to parse: " + e.getLocalizedMessage());
        }
        
        try {
            helper.createInvariant(
                "self.oclIsKindOf(_context::_else)");
        } catch (Exception e) {
            fail("Failed to parse: " + e.getLocalizedMessage());
        }
    }
    
    public void test_reservedClassName_operationContext_183362() {
        try {
            ocl.parse(new OCLInput(
                "package Smalltalk context runtime::_context::_else::doIt() : pre: true endpackage"));
            ocl.parse(new OCLInput(
                "package Smalltalk::runtime::_context context _else::doIt() : pre: true endpackage"));
        } catch (Exception e) {
            fail("Failed to parse: " + e.getLocalizedMessage());
        }
    }
    
    public void test_reservedStateName_183362() {
        helper.setContext(elseClass);
        
        try {
            helper.createInvariant(
                "not self.oclIsInState(_init::_body)");
        } catch (Exception e) {
            fail("Failed to parse: " + e.getLocalizedMessage());
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
        
        res = new ResourceImpl(URI.createURI("foo://uml"));
        resourceSet.getResources().add(res);
        
        smalltalk = UMLFactory.eINSTANCE.createPackage();
        smalltalk.setName("Smalltalk");
        
        res.getContents().add(smalltalk);
        
        Class object = smalltalk.createOwnedClass("Object", false);
        collection = smalltalk.createOwnedClass("Collection", false);
        block = smalltalk.createOwnedClass("Block", false);
        Class clazz = smalltalk.createOwnedClass("Class", false);
        
        clazz.createGeneralization(object);
        block.createGeneralization(object);
        collection.createGeneralization(object);
        
        clazz.createOwnedAttribute("name", getUMLString());
        
        EList<String> names = new BasicEList<String>(1);
        EList<Type> types = new BasicEList<Type>(1);
        
        names.add("object");
        types.add(object);
        block.createOwnedOperation("context", names, types, clazz).setIsQuery(true);
        
        names.set(0, "block");
        types.set(0, block);
        collection.createOwnedOperation("isUnique", names, types, getUMLBoolean()).setIsQuery(true);
        collection.createOwnedOperation("select", names, types, collection).setIsQuery(true);
        
        names.clear();
        types.clear();
        collection.createOwnedOperation("isEmpty", names, types, getUMLBoolean()).setIsQuery(true);
        
        // create some qualified classifier and package names that need
        //    escaping of one or more segments.  Likewise state names
        Package contextPackage = smalltalk.createNestedPackage("runtime")
            .createNestedPackage("context");
        contextPackage.createOwnedClass("language", false);
        elseClass = contextPackage.createOwnedClass("else", false);
        
        elseClass.createOwnedOperation("doIt", null, null);
        
        StateMachine machine = (StateMachine) elseClass.createOwnedBehavior(
            "StateMachine", UMLPackage.Literals.STATE_MACHINE);
        State state = (State) machine.createRegion("region").createSubvertex(
            "init", UMLPackage.Literals.STATE);
        state.createRegion("region").createSubvertex("body",
            UMLPackage.Literals.STATE);
    }
}
