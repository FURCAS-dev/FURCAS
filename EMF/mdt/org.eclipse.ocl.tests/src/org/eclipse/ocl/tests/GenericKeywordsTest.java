/**
 * <copyright>
 * 
 * Copyright (c) 2007, 2010 IBM Corporation and others.
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
 * $Id: GenericKeywordsTest.java,v 1.3 2010/02/09 21:04:25 ewillink Exp $
 */

package org.eclipse.ocl.tests;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * Tests for usages of model features whose names coincide with "keywords"
 * defined as reserved words by the OCL specification.
 * 
 * @author Christian W. Damus (cdamus)
 */
@SuppressWarnings("nls")
public abstract class GenericKeywordsTest<E extends EObject, PK extends E, T extends E, C extends T, CLS extends C, DT extends C, PT extends C, ET extends DT, O extends E, PM extends E, P extends E, PA extends P, PR extends P, EL, S, COA, SSA, CT>
	extends GenericTestSuite<E, PK, T, C, CLS, DT, PT, ET, O, PM, P, PA, PR, EL, S, COA, SSA, CT> {

    PK smalltalk;
    CLS collection;
    CLS block;
    protected CLS elseClass;
    CLS clazz;
    CLS property;
    CLS constraint;

    @Override
    protected void setUp() {
        super.setUp();

        // create a little test model for a Smalltalk-like collection class that
        // defines operations corresponding to OCL iterators
        smalltalk = reflection.createPackage("Smalltalk");
        registerPackage(smalltalk, "st", "foo://smalltalk");

        CLS object = reflection.createOwnedClass(smalltalk, "Object", false);
        collection = reflection.createOwnedClass(smalltalk, "Collection", false);
        block = reflection.createOwnedClass(smalltalk, "Block", false);
        clazz = reflection.createOwnedClass(smalltalk, "Class", false);
        property = reflection.createOwnedClass(smalltalk, "Property", false);
        constraint = reflection.createOwnedClass(smalltalk, "Constraint", false);
        reflection.addSupertype(constraint, object);
        reflection.addSupertype(property, object);
        reflection.addSupertype(clazz, object);
        reflection.addSupertype(block, object);
        reflection.addSupertype(collection, object);

        ET visibilityKind = reflection.createOwnedEnumeration(smalltalk, "VisibilityKind");
        reflection.createOwnedLiteral(visibilityKind, "public");
        reflection.createOwnedLiteral(visibilityKind, "protected");
        reflection.createOwnedLiteral(visibilityKind, "package");
        reflection.createOwnedLiteral(visibilityKind, "private");
        
        reflection.createOwnedAttribute(clazz, "name", reflection.getUMLString());
        reflection.createOwnedAttribute(clazz, "visibility", visibilityKind);
        reflection.createOwnedReference(clazz, "package", object);
        reflection.createOwnedAttribute(property, "isUnique", reflection.getUMLBoolean());
        reflection.createOwnedAttribute(property, "upper", reflection.getUMLInteger());
        reflection.createOwnedReference(constraint, "context", clazz);
        
        EList<String> names = new BasicEList<String>(1);
        EList<T> types = new BasicEList<T>(1);

        names.add("object");
        types.add(object);
        reflection.createOwnedOperation(block, "context",
        	names, types, clazz, true);

        names.set(0, "block");
        types.set(0, block);
        reflection.createOwnedOperation(collection, "isUnique",
        	names, types, reflection.getUMLBoolean(), true);
        reflection.createOwnedOperation(collection, "select", 
        	names, types, collection, true);

        names.clear();
        types.clear();
        reflection.createOwnedOperation(collection, "isEmpty",
        	names, types, reflection.getUMLBoolean(), true);

        // create some qualified classifier and package names that need
        // escaping of one or more segments. Likewise state names
        PK nested = reflection.createNestedPackage(smalltalk, "runtime");
        PK contextPackage = reflection.createNestedPackage(nested, "context");

        reflection.createOwnedClass(contextPackage, "language", false);
        elseClass = reflection.createOwnedClass(contextPackage, "else", false);
        reflection.createOwnedOperation(elseClass, "doIt",
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
