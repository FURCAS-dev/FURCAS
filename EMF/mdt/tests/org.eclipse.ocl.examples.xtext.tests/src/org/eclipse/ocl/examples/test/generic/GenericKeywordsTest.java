/**
 * <copyright>
 * 
 * Copyright (c) 2007,2011 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *   E.D.Willink - Bugs 296409, 295166
 *
 * </copyright>
 *
 * $Id: GenericKeywordsTest.java,v 1.5 2011/05/20 15:27:16 ewillink Exp $
 */

package org.eclipse.ocl.examples.test.generic;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.tests.PivotTestSuite;

/**
 * Tests for usages of model features whose names coincide with "keywords"
 * defined as reserved words by the OCL specification.
 * 
 * @author Christian W. Damus (cdamus)
 */
@SuppressWarnings("nls")
public abstract class GenericKeywordsTest
	extends PivotTestSuite {

    org.eclipse.ocl.examples.pivot.Package smalltalk;
    org.eclipse.ocl.examples.pivot.Class collection;
    org.eclipse.ocl.examples.pivot.Class block;
    protected org.eclipse.ocl.examples.pivot.Class elseClass;
    org.eclipse.ocl.examples.pivot.Class clazz;
    org.eclipse.ocl.examples.pivot.Class property;
    org.eclipse.ocl.examples.pivot.Class constraint;

    @Override
    protected void setUp() {
        super.setUp();

        // create a little test model for a Smalltalk-like collection class that
        // defines operations corresponding to OCL iterators
        smalltalk = typeManager.createPackage("Smalltalk", null);
        registerPackage(smalltalk, "st", "foo://smalltalk");

        org.eclipse.ocl.examples.pivot.Class object = createOwnedClass(smalltalk, "Object", false);
        collection = createOwnedClass(smalltalk, "Collection", false);
        block = createOwnedClass(smalltalk, "Block", false);
        clazz = createOwnedClass(smalltalk, "Class", false);
        property = createOwnedClass(smalltalk, "Property", false);
        constraint = createOwnedClass(smalltalk, "Constraint", false);
        addSupertype(constraint, object);
        addSupertype(property, object);
        addSupertype(clazz, object);
        addSupertype(block, object);
        addSupertype(collection, object);

        org.eclipse.ocl.examples.pivot.Enumeration visibilityKind = createOwnedEnumeration(smalltalk, "VisibilityKind");
        createOwnedLiteral(visibilityKind, "public");
        createOwnedLiteral(visibilityKind, "protected");
        createOwnedLiteral(visibilityKind, "package");
        createOwnedLiteral(visibilityKind, "private");
        
        createOwnedAttribute(clazz, "name", typeManager.getStringType());
        createOwnedAttribute(clazz, "visibility", visibilityKind);
        createOwnedReference(clazz, "package", object);
        createOwnedAttribute(property, "isUnique", typeManager.getBooleanType());
        createOwnedAttribute(property, "upper", typeManager.getIntegerType());
        createOwnedReference(constraint, "context", clazz);
        
        EList<String> names = new BasicEList<String>(1);
        EList<Type> types = new BasicEList<Type>(1);

        names.add("object");
        types.add(object);
        createOwnedOperation(block, "context",
        	names, types, clazz, true);

        names.set(0, "block");
        types.set(0, block);
        createOwnedOperation(collection, "isUnique",
        	names, types, typeManager.getBooleanType(), true);
        createOwnedOperation(collection, "select", 
        	names, types, collection, true);

        names.clear();
        types.clear();
        createOwnedOperation(collection, "isEmpty",
        	names, types, typeManager.getBooleanType(), true);

        // create some qualified classifier and package names that need
        // escaping of one or more segments. Likewise state names
        org.eclipse.ocl.examples.pivot.Package nested = createPackage(smalltalk, "runtime");
        org.eclipse.ocl.examples.pivot.Package contextPackage = createPackage(nested, "context");

        createOwnedClass(contextPackage, "language", false);
        elseClass = createOwnedClass(contextPackage, "else", false);
        createOwnedOperation(elseClass, "doIt",
        	null, null, null, false);
    }

	public void test_isUnique_162300() {
        assertInvariant(property, "self.isUnique implies self.upper > 1");
        assertInvariant(property, "isUnique implies self.upper > 1");
    }

    public void test_package_162300() {
        assertInvariant(clazz, "self._package.oclIsUndefined() implies Set{VisibilityKind::protected, VisibilityKind::_package}->excludes(self.visibility)");
        assertInvariant(clazz, "_package.oclIsUndefined() implies Set{VisibilityKind::protected, VisibilityKind::_package}->excludes(self.visibility)");
        assertInvariant(clazz, "_'package'.oclIsUndefined() implies Set{VisibilityKind::protected, VisibilityKind::_package}->excludes(self.visibility)");
    }

    public void test_context_162300() {
        assertInvariant(constraint, "self._context <> null implies _context.oclIsKindOf(Class)");
        assertInvariant(constraint, "_context <> null implies self._context.oclIsKindOf(Class)");
        assertInvariant(constraint, "_'con''te' 'x'\n't' <> null implies self._context.oclIsKindOf(Class)");
    }

    public void test_isUniqueOperation_162300() {
        createVariableInEnvironment("aBlock", block);
        assertInvariant(collection, "self.isUnique(aBlock)");
        assertInvariant(collection, "isUnique(aBlock)");
    }

    public void test_selectOperation_162300() {
        createVariableInEnvironment("aBlock", block);
        assertInvariant(collection, "self.select(aBlock).isEmpty()");
        assertInvariant(collection, "select(aBlock).isEmpty()");
   }

    public void test_contextOperation_162300() {
        assertInvariant(block, "self._context(self).name = 'Block'");
        assertInvariant(block, "_context(self).name = 'Block'");
        assertInvariant(block, "_'context'(self).name = 'Block'");
    }

    public void test_reservedPackageName_183362() {
        assertInvariant(block, "Smalltalk::runtime::_context::language.allInstances()->notEmpty()");
   }

    public void test_reservedPackageName_packageContext_183362() {
        createDocument("package Smalltalk::runtime::_context context language inv: true endpackage");
    }

    public void test_reservedClassName_183362() {
        assertInvariant(elseClass, "let e : _else = self in _else.allInstances()->forAll(oclIsKindOf(_else))");
        assertInvariant(elseClass, "self.oclIsKindOf(_context::_else)");
    }

    public void test_reservedClassName_operationContext_183362() {
    	createDocument("package Smalltalk context runtime::_context::_else::doIt() : pre: true endpackage");
    	createDocument("package Smalltalk::runtime::_context context _else::doIt() : pre: true endpackage");
    }

	public void test_unexpectedCharacter_283509() {
        helper.setContext(property);

        try {
            helper.createInvariant("self = #self");
            fail("Missing exception");
        } catch (Exception e) {
            assertEquals("2:6 \"#\" unexpected character ignored", e.getLocalizedMessage());
        }
    }
}
