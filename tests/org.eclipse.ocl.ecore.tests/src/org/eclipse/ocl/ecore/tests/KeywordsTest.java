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
 *   E.D.Willink Bug 283509
 *
 * </copyright>
 *
 * $Id: KeywordsTest.java,v 1.3 2009/10/23 20:55:59 ewillink Exp $
 */

package org.eclipse.ocl.ecore.tests;

import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.ocl.OCLInput;
import org.eclipse.ocl.expressions.Variable;

/**
 * Tests for usages of model features whose names coincide with "keywords"
 * defined as reserved words by the OCL specification.
 * 
 * @author Christian W. Damus (cdamus)
 */
@SuppressWarnings("nls")
public class KeywordsTest
    extends AbstractTestSuite {

    Resource res;
    EPackage smalltalk;
    EClass collection;
    EClass block;
    EClass elseClass;
    EClass clazz;
    EClass property;
    EClass constraint;

    public void test_isUnique_162300() {
        helper.setContext(property);

        try {
            helper.createInvariant("self.isUnique implies self.upper > 1");
            helper.createInvariant("isUnique implies self.upper > 1");
        } catch (Exception e) {
            fail("Failed to parse: " + e.getLocalizedMessage());
        }
    }

    public void test_package_162300() {
        helper.setContext(clazz);

        try {
            helper
                .createInvariant("self._package.oclIsUndefined() implies Set{VisibilityKind::protected, VisibilityKind::_package}->excludes(self.visibility)");
            helper
                .createInvariant("_package.oclIsUndefined() implies Set{VisibilityKind::protected, VisibilityKind::_package}->excludes(self.visibility)");
        } catch (Exception e) {
            fail("Failed to parse: " + e.getLocalizedMessage());
        }
    }

    public void test_context_162300() {
        helper.setContext(constraint);

        try {
            helper
                .createInvariant("self._context <> null implies _context.oclIsKindOf(Class)");
            helper
                .createInvariant("_context <> null implies self._context.oclIsKindOf(Class)");
        } catch (Exception e) {
            fail("Failed to parse: " + e.getLocalizedMessage());
        }
    }

    public void test_isUniqueOperation_162300() {
        helper.setContext(collection);

        Variable<EClassifier, EParameter> var = ocl.getEnvironment()
            .getOCLFactory().createVariable();
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

        Variable<EClassifier, EParameter> var = ocl.getEnvironment()
            .getOCLFactory().createVariable();
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
            helper
                .createInvariant("Smalltalk::runtime::_context::language.allInstances()->notEmpty()");
        } catch (Exception e) {
            fail("Failed to parse: " + e.getLocalizedMessage());
        }
    }

    public void test_reservedPackageName_packageContext_183362() {
        try {
            ocl
                .parse(new OCLInput(
                    "package Smalltalk::runtime::_context context language inv: true endpackage"));
        } catch (Exception e) {
            fail("Failed to parse: " + e.getLocalizedMessage());
        }
    }

    public void test_reservedClassName_183362() {
        helper.setContext(elseClass);

        try {
            helper
                .createInvariant("let e : _else = self in _else.allInstances()->forAll(oclIsKindOf(_else))");
        } catch (Exception e) {
            fail("Failed to parse: " + e.getLocalizedMessage());
        }

        try {
            helper.createInvariant("self.oclIsKindOf(_context::_else)");
        } catch (Exception e) {
            fail("Failed to parse: " + e.getLocalizedMessage());
        }
    }

    public void test_reservedClassName_operationContext_183362() {
        try {
            ocl
                .parse(new OCLInput(
                    "package Smalltalk context runtime::_context::_else::doIt() : pre: true endpackage"));
            ocl
                .parse(new OCLInput(
                    "package Smalltalk::runtime::_context context _else::doIt() : pre: true endpackage"));
        } catch (Exception e) {
            fail("Failed to parse: " + e.getLocalizedMessage());
        }
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

    //
    // Framework methods
    //

    @Override
    protected void setUp() {
        super.setUp();

        // create a little test model for a Smalltalk-like collection class that
        // defines operations corresponding to OCL iterators

        res = new ResourceImpl(URI.createURI("foo://smalltalk"));

        smalltalk = EcoreFactory.eINSTANCE.createEPackage();
        smalltalk.setName("Smalltalk");
        smalltalk.setNsPrefix("st");
        smalltalk.setNsURI("foo://smalltalk");

        res.getContents().add(smalltalk);
        resourceSet.getPackageRegistry().put(smalltalk.getNsURI(), smalltalk);

        EClass object = EcoreFactory.eINSTANCE.createEClass();
        object.setName("Object");
        smalltalk.getEClassifiers().add(object);

        collection = EcoreFactory.eINSTANCE.createEClass();
        collection.setName("Collection");
        smalltalk.getEClassifiers().add(collection);

        block = EcoreFactory.eINSTANCE.createEClass();
        block.setName("Block");
        smalltalk.getEClassifiers().add(block);

        clazz = EcoreFactory.eINSTANCE.createEClass();
        clazz.setName("Class");
        smalltalk.getEClassifiers().add(clazz);

        property = EcoreFactory.eINSTANCE.createEClass();
        property.setName("Property");
        smalltalk.getEClassifiers().add(property);

        constraint = EcoreFactory.eINSTANCE.createEClass();
        constraint.setName("Constraint");
        smalltalk.getEClassifiers().add(constraint);

        constraint.getESuperTypes().add(object);
        property.getESuperTypes().add(object);
        clazz.getESuperTypes().add(object);
        block.getESuperTypes().add(object);
        collection.getESuperTypes().add(object);

        EEnum visibilityKind = EcoreFactory.eINSTANCE.createEEnum();
        visibilityKind.setName("VisibilityKind");
        smalltalk.getEClassifiers().add(visibilityKind);
        createLiteral(visibilityKind, "public");
        createLiteral(visibilityKind, "protected");
        createLiteral(visibilityKind, "package");
        createLiteral(visibilityKind, "private");
        
        createAttribute(clazz, "name", EcorePackage.Literals.ESTRING);
        createAttribute(clazz, "visibility", visibilityKind);
        createReference(clazz, "package", object);
        createAttribute(property, "isUnique", EcorePackage.Literals.EBOOLEAN);
        createAttribute(property, "upper", EcorePackage.Literals.EINT);
        createReference(constraint, "context", clazz);
        
        EList<String> names = new BasicEList<String>(1);
        EList<EClassifier> types = new BasicEList<EClassifier>(1);

        names.add("object");
        types.add(object);
        createOwnedOperation(block, "context", names, types, clazz);

        names.set(0, "block");
        types.set(0, block);
        createOwnedOperation(collection,
            "isUnique", names, types, EcorePackage.Literals.EBOOLEAN);
        createOwnedOperation(collection, "select", names, types, collection);

        names.clear();
        types.clear();
        createOwnedOperation(collection,
            "isEmpty", names, types, EcorePackage.Literals.EBOOLEAN);

        // create some qualified classifier and package names that need
        // escaping of one or more segments. Likewise state names
        EPackage nested = EcoreFactory.eINSTANCE.createEPackage();
        nested.setName("runtime");
        smalltalk.getESubpackages().add(nested);

        EPackage contextPackage = EcoreFactory.eINSTANCE.createEPackage();
        contextPackage.setName("context");
        nested.getESubpackages().add(contextPackage);

        EClass tmp = EcoreFactory.eINSTANCE.createEClass();
        tmp.setName("language");
        contextPackage.getEClassifiers().add(tmp);

        elseClass = EcoreFactory.eINSTANCE.createEClass();
        elseClass.setName("else");
        contextPackage.getEClassifiers().add(elseClass);

        createOwnedOperation(elseClass, "doIt", null, null, null);
    }

    private static EOperation createOwnedOperation(EClass eclass, String name,
            List<String> paramNames, List<EClassifier> paramTypes,
            EClassifier type) {
        EOperation result = EcoreFactory.eINSTANCE.createEOperation();
        result.setName(name);
        result.setEType(type);
        eclass.getEOperations().add(result);

        if (paramNames != null) {
            for (int i = 0; i < paramNames.size(); i++) {
                EParameter param = EcoreFactory.eINSTANCE.createEParameter();
                param.setName(paramNames.get(i));
                param.setEType(paramTypes.get(i));
                result.getEParameters().add(param);
            }
        }

        return result;
    }

    private static EAttribute createAttribute(EClass eclass, String name,
            EDataType type) {
        EAttribute result = EcoreFactory.eINSTANCE.createEAttribute();
        result.setName(name);
        result.setEType(type);
        eclass.getEStructuralFeatures().add(result);
        return result;
    }

    private static EReference createReference(EClass eclass, String name,
            EClass type) {
        EReference result = EcoreFactory.eINSTANCE.createEReference();
        result.setName(name);
        result.setEType(type);
        eclass.getEStructuralFeatures().add(result);
        return result;
    }
    
    private static EEnumLiteral createLiteral(EEnum eenum, String name) {
        EEnumLiteral result = EcoreFactory.eINSTANCE.createEEnumLiteral();
        result.setName(name);
        eenum.getELiterals().add(result);
        return result;
    }
}
